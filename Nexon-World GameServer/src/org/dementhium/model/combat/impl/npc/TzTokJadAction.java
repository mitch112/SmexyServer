package org.dementhium.model.combat.impl.npc;

import org.dementhium.model.Projectile;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatMovement;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.combat.RangeFormulae;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.model.npc.impl.TzTokJad;

/**
 * Handles the TzTok-Jad combat action.
 * @author Grumpy
 *
 */
public class TzTokJadAction extends CombatAction {

	/**
	 * The jad NPC.
	 */
	private final TzTokJad jad;
	
	/**
	 * The ranged animation.
	 */
	private static final Animation RANGE_ANIMATION = Animation.create(9276);
	
	/**
	 * The range gfx.
	 */
	private static final Graphic RANGE_GFX = Graphic.create(1625);
	
	/**
	 * The range end gfx.
	 */
	private static final Graphic RANGE_END_GFX = Graphic.create(451);
	
	/**
	 * The melee animation.
	 */
	private static final Animation MELEE_ANIMATION = Animation.create(9277);
	
	/**
	 * The magic animation.
	 */
	private static final Animation MAGIC_ANIMATION = Animation.create(9278);
	
	/**
	 * The magic gfx.
	 */
	private static final Graphic MAGIC_GFX = Graphic.create(1626);
	
	/**
	 * The current combat type.
	 */
	private CombatType type = CombatType.MAGIC;
	
	/**
	 * The maximum hit.
	 */
	private int maximum;
	
	/**
	 * Constructs a new {@code TzTokJad} {@code Object}.
	 * @param jad The jad NPC.
	 */
	public TzTokJadAction(TzTokJad jad) {
		super(false);
		this.jad = jad;
	}

	@Override
	public boolean commenceSession() {
		jad.getCombatExecutor().setTicks(7);
		if (CombatMovement.canMelee(jad, interaction.getVictim()) && jad.getRandom().nextInt(10) < 5) {
            type = CombatType.MELEE;
        } else {
        	type = CombatType.values()[1 + jad.getRandom().nextInt(2)];
        }
		int ticks = 2;
		switch (type) {
		case MELEE:
			jad.animate(MELEE_ANIMATION);
			maximum = MeleeFormulae.getMeleeDamage(jad, 1.0);
			break;
		case RANGE:
			jad.animate(RANGE_ANIMATION);
			jad.graphics(RANGE_GFX);
			maximum = RangeFormulae.getRangeDamage(jad, 1.0);
			ticks = (int) Math.floor(jad.getLocation().distance(interaction.getVictim().getLocation()) * .5);
			break;
		case MAGIC:
			jad.animate(MAGIC_ANIMATION);
			jad.graphics(MAGIC_GFX);
			maximum = (int) MagicFormulae.getMaximumMagicDamage(jad, 1.0);
			ticks = (int) Math.floor(jad.getLocation().distance(interaction.getVictim().getLocation()) * 0.5);
			ProjectileManager.sendProjectile(Projectile.magic(jad, interaction.getVictim(), 1627, 43, 36, 72, 5));
			break;
		}
		interaction.setTicks(ticks);
		return true;
	}

	@Override
	public boolean executeSession() {
		if (interaction.getTicks() < 2) {
			if (interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, 9 - type.ordinal())) {
				interaction.setDeflected(true);
				interaction.getVictim().graphics(2230 - type.ordinal());
				interaction.getVictim().animate(12573);
			} else {
				interaction.getVictim().animate(interaction.getVictim().getDefenceAnimation());
			}
			int current = type == CombatType.MELEE ? MeleeFormulae.getDamage(jad, interaction.getVictim()) : 
				type == CombatType.RANGE ? RangeFormulae.getDamage(jad, interaction.getVictim()) :
					MagicFormulae.getDamage(jad, interaction.getVictim(), 1.0, 1.0, 1.0);
	        interaction.setDamage(Damage.getDamage(jad, interaction.getVictim(), type, current));
	        interaction.getDamage().setMaximum(maximum);
		}
		interaction.setTicks(interaction.getTicks() - 1);
		return interaction.getTicks() < 1;
	}

	@Override
	public boolean endSession() {
			if (type == CombatType.RANGE) {
				interaction.getVictim().graphics(RANGE_END_GFX);
			}
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
		return true;
	}

	@Override
	public CombatType getCombatType() {
		return type;
	}

}