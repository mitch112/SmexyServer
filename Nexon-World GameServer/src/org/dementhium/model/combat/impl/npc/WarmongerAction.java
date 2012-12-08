package org.dementhium.model.combat.impl.npc;

import org.dementhium.content.areas.Area;
import org.dementhium.model.Projectile;
import org.dementhium.model.World;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatMovement;
import org.dementhium.model.combat.CombatTask;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.util.Misc;

/**
 * Handles the Warmonger's combat action.
 * @author Emperor
 * @author Wildking72 - Additions
 *
 */
public class WarmongerAction extends CombatAction {

	private static int[] Ramokee = {13023, 13013};
	
	public static int randomRamokee() {
		return Ramokee[(int)(Math.random()*Ramokee.length)];
	}

	public static final Area COMBAT_AREA = World.getWorld().getAreaManager().getAreaByName("Warmonger");

	private static void modifyLevel(Interaction interaction, int skill, double modification) {
		int mod = (int) Math.floor(2 + (interaction.getVictim().getPlayer().getSkills().getLevelForExperience(skill) * modification));
		interaction.getVictim().getPlayer().getSkills().decreaseLevelToZero(skill, mod);
	}
	
	private static enum Attack {
		ATTACK1(Animation.create(14962),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, 1196, 30, 32, 52, 75, 3, 11), 
				Graphic.create(1196, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						interaction.getSource().forceText("Feel the pain " + interaction.getVictim().getPlayer().getUsername() + "!");
						modifyLevel(interaction, Misc.random(0, 2), 0.1);
						modifyLevel(interaction, Misc.random(4, 6), 0.1);
						modifyLevel(interaction, Misc.random(0, 2), 0.1);
						modifyLevel(interaction, Misc.random(0, 2), 0.1);
						return true;
					}
				}
		),
		ATTACK2(Animation.create(14393),
				Graphic.create(2876, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(-1, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 200), DamageType.MAGE);
						interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 200), DamageType.RANGE);
						return true;
					}
				}
		),
		ATTACK3(Animation.create(14962),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(2877, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		MINIONS(Animation.create(14965),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(1555, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						if (Misc.random(1, 10) < 4) {
							World.getWorld().register(randomRamokee(), interaction.getSource().getLocation()).setUnrespawnable(true);
						}
						return true;
					}
				}
		),
		ATTACK5(Animation.create(14963),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(-1, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		ACTION1(Animation.create(14961),
				Graphic.create(-1, 96 << 16),
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(2583, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 100);
						return true;
					}
				}
		),
		ACTION2(Animation.create(14961),
				Graphic.create(-1, 96 << 16),
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(1592, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						//COMBAT_AREA.randomTeleport(interaction.getVictim());
						if (interaction.getDamage().getHit() > -1 && interaction.getVictim().getAttribute("freezeImmunity", -1) < World.getTicks()) {
							interaction.getVictim().setAttribute("freezeTime", World.getTicks() + 25);
							interaction.getVictim().setAttribute("freezeImmunity", World.getTicks() + 30);
						}
							return true;
					}
				}
		);
		

		private final Animation anim;
		
		private final Graphic start;
		
		private final Projectile projectile;

		private final Graphic end;

		private final CombatTask task;

		private Attack(Animation anim, Graphic start, Projectile projectile, Graphic end, CombatTask task) {
			this.anim = anim;
			this.start = start;
			this.projectile = projectile;
			this.end = end;
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
	 * Constructs a new {@code WarmongerAction} {@code Object}.
	 */
	public WarmongerAction() {
		super(false);
	}

	@Override
	public boolean commenceSession() {
	int arg = Misc.random(1, 8);
	int hit;
		interaction.getSource().getCombatExecutor().setTicks(5);
		if (interaction.getSource().getRandom().nextInt(10) < 5) {
			attack = Attack.values()[interaction.getSource().getRandom().nextInt(Attack.values().length)];
		}
		if (CombatMovement.canMelee(interaction.getSource(), interaction.getVictim()) && arg >= 7) {
			attack = Attack.ATTACK5;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(525);
		} else if (arg == 4) {
			attack = Attack.ATTACK1;
			type = CombatType.MAGIC;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(415);
		} else if (arg == 3) {
			attack = Attack.ATTACK3;
			type = CombatType.RANGE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(435);
		} else if (interaction.getSource().getHitPoints() < 1250 && arg == 1) {
			attack = Attack.MINIONS;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(600);
		} else if (CombatMovement.canMelee(interaction.getSource(), interaction.getVictim()) && arg == 2) {
			attack = Attack.ATTACK2;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(400);
		} else {
			attack = Attack.ACTION2;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(120);
		}
		ProjectileManager.sendProjectile(attack.projectile.transform(interaction.getSource(), interaction.getVictim()));
		interaction.getSource().animate(attack.anim);
		interaction.getSource().graphics(attack.start);
        int ticks = (int) Math.floor(attack.projectile.getSourceLocation().distance(interaction.getVictim().getLocation()) * 0.3);
		interaction.setTicks(ticks);
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
		interaction.getVictim().graphics(attack.end);
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
		return CombatType.MELEE;
	}

}