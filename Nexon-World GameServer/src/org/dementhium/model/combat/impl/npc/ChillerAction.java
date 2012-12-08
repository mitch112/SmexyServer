package org.dementhium.model.combat.impl.npc;

import org.dementhium.model.Projectile;
import org.dementhium.model.World;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatTask;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.combat.RangeFormulae;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.util.Misc;
import org.dementhium.model.npc.NPC;

/**
 * Handles the Chiller's combat action.
 * @author Emperor
 * @author Wildking72 - Additions
 *
 */
public class ChillerAction extends CombatAction {

	private static enum Attack {
		
		HEAL(Animation.create(14962), Graphic.create(-1),
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
					Animation.create(14962), Graphic.create(-1),
						Graphic.create(-1), new CombatTask() {
			@Override
			public boolean execute(Interaction interaction) {
				interaction.getSource().forceText("Heal me!");
				interaction.getSource().heal(Misc.random(100, 1000));
				//NPC ramokee = new NPC(13023);
				//ramokee.graphics(2794);
				return true;
				}
			}
		),
		SUMMON(Animation.create(14962), Graphic.create(-1),
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
					Animation.create(14962), Graphic.create(-1),
						Graphic.create(-1), new CombatTask() {
			@Override
			public boolean execute(Interaction interaction) {
				interaction.getSource().forceText("Come forth my minions!");
				NPC ramokee = new NPC(13023, interaction.getVictim().getPlayer().getLocation().getX() + 1,
				interaction.getVictim().getPlayer().getLocation().getY() + 1, 
				interaction.getVictim().getPlayer().getLocation().getZ());
				World.getWorld().getNpcs().add(ramokee);
				ramokee.graphics(2794);
				ramokee.setAttribute("enemyIndex", interaction.getVictim().getPlayer().getIndex());
				ramokee.getMask().setInteractingEntity(interaction.getVictim().getPlayer());
				ramokee.getCombatExecutor().setVictim(interaction.getVictim().getPlayer());
				return true;
				}
			}
		),
		RAGE(Animation.create(14383), Graphic.create(2876),
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11),
					Animation.create(14383), Graphic.create(2876),
						Graphic.create(-1), new CombatTask() {
			@Override
			public boolean execute(Interaction interaction) {
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 100), DamageType.MELEE);
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 100), DamageType.MELEE);
				return true;
				}
			}
		),
		RANGE(Animation.create(14373), Graphic.create(-1),
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
					Animation.create(14373), Graphic.create(-1),
						Graphic.create(2787), new CombatTask() {
			@Override
			public boolean execute(Interaction interaction) {
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 90), DamageType.RANGE);
				interaction.setTicks(5);
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 90), DamageType.RANGE);
				interaction.setTicks(5);
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 90), DamageType.RANGE);
				interaction.setTicks(5);
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 90), DamageType.RANGE);
				return true;
				}
			}
		);
		

		private final Animation startAnim;
		
		private final Animation endAnim;
		
		private final Graphic victimGfx;
		
		private final Graphic startGfx;

		private final Graphic endGfx;
		
		private final Projectile projectile;
		
		private final CombatTask task;

		private Attack(Animation startAnim, Graphic startGfx, Projectile projectile, Animation endAnim, Graphic endGfx, Graphic victimGfx, CombatTask task) {
			this.startAnim = startAnim;
			this.startGfx = startGfx;
			this.projectile = projectile;
			this.endAnim = endAnim;
			this.endGfx = endGfx;
			this.victimGfx = victimGfx;
			this.task = task;
		}
	}
	
	/**
	 * The current combat type used.
	 */
	private CombatType type = CombatType.MELEE;
	
	/**
	 * The current attack used.
	 */
	private Attack attack;
	
	/**
	 * Constructs a new {@code ChillerAction} {@code Object}.
	 */
	public ChillerAction() {
		super(false);
	}

	@Override
	public boolean commenceSession() {
	int arg = Misc.random(1, 20);
	int hit;
		if (interaction.getSource().getRandom().nextInt(10) < 5) {
			attack = Attack.values()[interaction.getSource().getRandom().nextInt(Attack.values().length)];
		}
		if (interaction.getSource().getHitPoints() < 2000 && arg > 17) {
			attack = Attack.HEAL;
		} else if (arg < 7) {
			attack = Attack.RANGE;
			type = CombatType.RANGE;
			hit = RangeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(500);
		} else if (arg == 15) {
			attack = Attack.SUMMON;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(10);
		} else {
			attack = Attack.RAGE;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(500);
		}
		ProjectileManager.sendProjectile(attack.projectile.transform(interaction.getSource(), interaction.getVictim()));
		interaction.getSource().animate(attack.startAnim);
		interaction.getSource().graphics(attack.startGfx);
        int ticks = (int) Math.floor(attack.projectile.getSourceLocation().distance(interaction.getVictim().getLocation()) * 0.3);
		interaction.setTicks(ticks);
		interaction.getSource().animate(attack.endAnim);
		interaction.getSource().graphics(attack.endGfx);
		return true;
	}

	@Override
	public boolean executeSession() {
		if (interaction.getTicks() < 2) {
			if (interaction.isDeflected()) {
				interaction.getVictim().graphics(2230 - type.ordinal());
			}
			interaction.getVictim().animate(interaction.isDeflected() ? 12573 : interaction.getVictim().getDefenceAnimation());
		}
		interaction.setTicks(interaction.getTicks() - 1);
		return interaction.getTicks() < 1;
	}

	@Override
	public boolean endSession() {
		interaction.getVictim().graphics(attack.victimGfx);
		if (attack.task.execute(interaction) && interaction.getDamage() != null) {
			if (interaction.getDamage().getHit() > -1) {
				interaction.getVictim().getDamageManager().damage(
						interaction.getSource(), interaction.getDamage(), type.getDamageType());
			} else {
				interaction.getVictim().graphics(85, 96 << 16);
			}
			if (interaction.getDamage().getVenged() > 0) {
				interaction.getVictim().submitVengeance(interaction.getSource(), interaction.getDamage().getVenged());
			}
			if (interaction.getDamage().getDeflected() > 0) {
				interaction.getSource().getDamageManager().damage(interaction.getVictim(), 
						interaction.getDamage().getDeflected(), 
						interaction.getDamage().getDeflected(), DamageType.DEFLECT);
			}
			if (interaction.getDamage().getRecoiled() > 0) {
				interaction.getSource().getDamageManager().damage(interaction.getVictim(), 
						interaction.getDamage().getRecoiled(), 
						interaction.getDamage().getRecoiled(), DamageType.DEFLECT);
			}
			interaction.getVictim().retaliate(interaction.getSource());
		}
		return true;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MAGIC;
	}

}