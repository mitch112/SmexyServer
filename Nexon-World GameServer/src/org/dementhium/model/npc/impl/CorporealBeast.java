package org.dementhium.model.npc.impl;

import java.util.List;

import org.dementhium.model.Mob;
import org.dementhium.model.Projectile;
import org.dementhium.model.World;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.impl.npc.CorporealBeastAction;
import org.dementhium.model.map.Region;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.player.Player;
import org.dementhium.tickable.Tick;

/**
 * Represents a tormented demon.
 * @author Grumpy
 *
 */
public class CorporealBeast extends NPC {

	/**
	 * The combat action to use.
	 */
	private final CorporealBeastAction combatAction = new CorporealBeastAction();
	
	/**
	 * The shield graphic.
	 */
	//private static final Graphic SHIELD_GRAPHIC = Graphic.create(1885);
	
	/**
	 * The switching combat types animation.
	 */
	private static final Animation SWITCH_COMBAT_TYPE = Animation.create(10055);
	
	/**
	 * The melee protection demon npc id
	 */
	private static final int CORP = 8133;
	
	/**
	 * The projectile the demon uses for its location-based magic attack.
	 */
	private final Projectile projectile = 
			Projectile.create(this, null, 1824, 43, 0, 56, 76, 3, size());
	
	/**
	 * The amount of damage received.
	 */
	private int damageReceived;
	
	/**
	 * The shield restoration tick.
	 */
	private final Tick shieldRestoreTick = new Tick(100) {
		@Override
		public void execute() {
			//stop();
			//shieldActive = true;
			List<Player> players = Region.getLocalPlayers(getLocation());
			for (Player p : players) {
				if (p.getCombatExecutor().getVictim() == CorporealBeast.this) {
					//p.sendMessage("The Tormented demon has regained its strength against your weapon.");
				}
			}
		}
	};
	
	/**
	 * If the shield is active.
	 */
	//private boolean shieldActive = true;
		
	/**
	 * Constructs a new {@code TormentedDemon} {@code Object}.
	 * @param id The npc id.
	 */
	public CorporealBeast(int id) {
		super(id);
		//shieldRestoreTick.stop();
	}
	
	@Override
	public int size() {
		return 4;
	}
	
	@Override
	public void tick() {
		super.tick();
		if (getAttribute("nextSwitch", -1) < World.getTicks()) {
			setAttribute("nextSwitch", World.getTicks() + 27);//3 minutes delay till next auto-switch.
			World.getWorld().submit(new Tick(1) {
				@Override
				public void execute() {
					stop();
					animate(SWITCH_COMBAT_TYPE);
					CorporealBeastAction.sendLocationAttack(CorporealBeast.this);
					combatAction.setType(CombatType.values()[getRandom().nextInt(3)]);
				}				
			});
		}
	}
	
	@Override
    public int getDefenceAnimation() {
		return getDefinition().getDefenceAnimation();
    }
	
	@Override
	public Damage updateHit(Mob source, int hit, CombatType type) {
		int currentHit = hit;
		if (CombatUtils.usingProtection(this, type)) {
			currentHit = (int) (hit * (source.isPlayer() ? 0.6 : 0));
		}
		
		/*if (source.isPlayer() && currentHit > 0) {
			if (source.getPlayer().getEquipment().getSlot(3) == 6746) {
				shieldRestoreTick.setTime(100);
				shieldActive = false;
				if (!shieldRestoreTick.isRunning()) {
					shieldRestoreTick.start();
					World.getWorld().submit(shieldRestoreTick);
					source.getPlayer().sendMessage("The demon is temporarily weakened by your weapon.");
				}
			}
		}*/
		damageReceived += currentHit < 20 ? 20 : currentHit;
		if (damageReceived >= 50) {
			switchDemonType(type);
		}
		return new Damage(currentHit);
	}
	
	@Override
	public void postCombatTick(Interaction interaction) {
		super.postCombatTick(interaction);
	}
	
	/**
	 * Switches the current demon type.
	 */
	private void switchDemonType(final CombatType type) {
		damageReceived = 0;
		World.getWorld().submit(new Tick(1) {
			@Override
			public void execute() {
				stop();
				getMask().setSwitchId(CORP);
			}				
		});
	}
	
	@Override
	public CombatAction getCombatAction() {
		return combatAction;
	}

	/**
	 * @return the projectile
	 */
	public Projectile getProjectile() {
		return projectile;
	}
	}