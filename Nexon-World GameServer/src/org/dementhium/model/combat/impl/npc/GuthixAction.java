package org.dementhium.model.combat.impl.npc;

import java.util.Random;

import org.dementhium.model.Projectile;
import org.dementhium.model.World;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatMovement;
import org.dementhium.model.combat.CombatTask;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.util.Misc;

/**
 * Handles the chaos elemental's combat action.
 * @author Emperor
 * @author Wildking72 - Additions
 *
 */
public class GuthixAction extends CombatAction {

	private static Random RANDOM = new Random();

	@SuppressWarnings("unused")
	private static void modifyLevel(Interaction interaction, int skill, double modification) {
		int mod = (int) Math.floor(2 + (interaction.getVictim().getPlayer().getSkills().getLevelForExperience(skill) * modification));
		interaction.getVictim().getPlayer().getSkills().decreaseLevelToZero(skill, mod);
	}
	
	private static enum Attack {
		MELEE(Animation.create(402),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(-1, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		MAGIC(Animation.create(1979),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, 368, 30, 32, 52, 75, 3, 11), 
				Graphic.create(369), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						if (interaction.getVictim().getAttribute("freezeImmunity", -1) < World.getTicks()) {
							interaction.getVictim().setAttribute("freezeTime", World.getTicks() + 24);
							interaction.getVictim().setAttribute("freezeImmunity", World.getTicks() + 28);
						} else {
							interaction.getVictim().graphics(1677, 96 << 16);
						}
						return true;
					}
				}
		),
		SPECIAL(Animation.create(1062),
				Graphic.create(252, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(-1, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 350), DamageType.MELEE);
						if (RANDOM.nextInt(10) > 7) {
							interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 80);
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
	 * Constructs a new {@code GuthixAction} {@code Object}.
	 */
	public GuthixAction() {
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
		if (CombatMovement.canMelee(interaction.getSource(), interaction.getVictim()) && arg > 4) {
			attack = Attack.MELEE;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(350);
		} else if (arg < 4) {
			attack = Attack.MAGIC;
			type = CombatType.MAGIC;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(320);
		} else {
			attack = Attack.SPECIAL;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(350);
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