package org.dementhium.model.combat.impl.npc;

import org.dementhium.model.Projectile;
import org.dementhium.model.World;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatTask;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.util.Misc;

/**
 * Handles the NecroLord's combat action.
 * @author Emperor
 * @author Wildking72 - Additions
 *
 */
public class NecroLordAction extends CombatAction {

	private static void modifyLevel(Interaction interaction, int skill, double modification) {
		int mod = (int) Math.floor(2 + (interaction.getVictim().getPlayer().getSkills().getLevelForExperience(skill) * modification));
		interaction.getVictim().getPlayer().getSkills().decreaseLevelToZero(skill, mod);
	}
	
	private static enum Attack {
		AIR(Animation.create(10546),
				Graphic.create(457, 96 << 16), 
				Projectile.create(null, null, 462, 30, 32, 52, 75, 3, 11), 
				Graphic.create(2700, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		WATER(Animation.create(10542),
				Graphic.create(2701, 96 << 16), 
				Projectile.create(null, null, 2707, 30, 32, 52, 75, 3, 11), 
				Graphic.create(2712, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		EARTH(Animation.create(14209),
				Graphic.create(2717, 96 << 16), 
				Projectile.create(null, null, 2722, 30, 32, 52, 75, 3, 11), 
				Graphic.create(272, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		FIRE(Animation.create(2791),
				Graphic.create(2728, 96 << 16), 
				Projectile.create(null, null, 2736, 30, 32, 52, 75, 3, 11), 
				Graphic.create(2741, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		ENTANGLE(Animation.create(710),
				Graphic.create(177, 96 << 16), 
				Projectile.create(null, null, 178, 30, 32, 52, 75, 3, 11), 
				Graphic.create(179, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						if (interaction.getDamage().getHit() > -1 && interaction.getVictim().getAttribute("freezeImmunity", -1) < World.getTicks()) {
							interaction.getVictim().setAttribute("freezeTime", World.getTicks() + 25);
							interaction.getVictim().setAttribute("freezeImmunity", World.getTicks() + 30);
						}
						return true;
					}
				}
		),
		STUN(Animation.create(711),
				Graphic.create(173, 96 << 16), 
				Projectile.create(null, null, -1, 175, 32, 52, 75, 3, 11), 
				Graphic.create(180, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						modifyLevel(interaction, 2, 0.10);
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
	private CombatType type = CombatType.MAGIC;
	
	/**
	 * The current attack used.
	 */
	private Attack attack;
	
	/**
	 * Constructs a new {@code NecroLordAction} {@code Object}.
	 */
	public NecroLordAction() {
		super(false);
	}

	@Override
	public boolean commenceSession() {
	int spell = Misc.random(1, 6);
	int hit;
		interaction.getSource().getCombatExecutor().setTicks(5);
		if (interaction.getSource().getRandom().nextInt(10) < 5) {
			attack = Attack.values()[interaction.getSource().getRandom().nextInt(Attack.values().length)];
		}
		if (spell == 1) {
			attack = Attack.AIR;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(300);
		} else if (spell == 2) {
			attack = Attack.WATER;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(300);
		} else if (spell == 3) {
			attack = Attack.EARTH;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(300);
		} else if (spell == 4) {
			attack = Attack.FIRE;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(300);
		} else if (spell == 5) {
			attack = Attack.ENTANGLE;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(300);
		} else {
			attack = Attack.STUN;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.0, 1.0, 1.0);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(300);
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