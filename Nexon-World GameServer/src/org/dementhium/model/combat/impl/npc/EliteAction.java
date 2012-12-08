package org.dementhium.model.combat.impl.npc;

import java.util.Random;

import org.dementhium.model.Projectile;
import org.dementhium.model.combat.CombatAction;
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
 * Handles the Elite black knight's combat action.
 * @author Emperor
 * @author Wildking72 - Additions
 *
 */
public class EliteAction extends CombatAction {

	@SuppressWarnings("unused")
	private static Random RANDOM = new Random();
	
	private static enum Attack {
		MELEE(Animation.create(7041),
				Graphic.create(-1, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(-1, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						return true;
					}
				}
		),
		SPECIAL(Animation.create(7072),
				Graphic.create(1224, 96 << 16), 
				Projectile.create(null, null, -1, 30, 32, 52, 75, 3, 11), 
				Graphic.create(1194, 96 << 16), new CombatTask() {
					@Override
					public boolean execute(Interaction interaction) {
						interaction.getVictim().getDamageManager().miscDamage(Misc.random(150, 400), DamageType.MAGE);
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
	 * Constructs a new {@code EliteAction} {@code Object}.
	 */
	public EliteAction() {
		super(false);
	}

	@Override
	public boolean commenceSession() {
	int arg = Misc.random(1, 7);
	int hit;
		interaction.getSource().getCombatExecutor().setTicks(5);
		if (interaction.getSource().getRandom().nextInt(10) < 5) {
			attack = Attack.values()[interaction.getSource().getRandom().nextInt(Attack.values().length)];
		}
		if (arg > 1) {
			attack = Attack.MELEE;
			type = CombatType.MELEE;
			hit = MeleeFormulae.getDamage(interaction.getSource(), interaction.getVictim());
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(297);
		} else {
			attack = Attack.SPECIAL;
			type = CombatType.MAGIC;
			hit = MagicFormulae.getDamage(interaction.getSource().getNPC(), interaction.getVictim(), 1.5, 1.5, 1.5);
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, type.getDeflectCurse()));
			interaction.setDamage(Damage.getDamage(interaction.getSource(), interaction.getVictim(), type, hit));
			interaction.getDamage().setMaximum(415);
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