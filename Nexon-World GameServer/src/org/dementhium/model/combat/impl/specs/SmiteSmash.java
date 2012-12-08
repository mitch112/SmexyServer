package org.dementhium.model.combat.impl.specs;

import org.dementhium.model.SpecialAttack;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MeleeFormulae;

/**
 * Executes the Statius's warhammer special attack - Smash.
 * @author Emperor
 *
 */
public class SmiteSmash extends SpecialAttack {
	
	/**
	 * The animation the player has to perform.
	 */
	private static final short ANIMATION = 10505;

	/**
	 * The graphics the player should cast when using the special.
	 */
	private static final short GRAPHICS = 1840;
	
	@Override
	public boolean commenceSpecialAttack(Interaction interaction) {
		interaction.getVictim().getPlayer().getSkills().drainPray(48.0);
		interaction.setDamage(Damage.getDamage(interaction.getSource(), 
				interaction.getVictim(), CombatType.MELEE, 
				MeleeFormulae.getDamage(interaction.getSource(), 
						interaction.getVictim(), 1.049, 1.25, 0.998)));
		interaction.getDamage().setMaximum(MeleeFormulae.getMeleeDamage(interaction.getSource(), 1.25));
		if (interaction.getVictim().isPlayer()) {
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, 9));
		}
		interaction.getSource().animate(ANIMATION);
		interaction.getSource().graphics(GRAPHICS);
		interaction.getVictim().animate(interaction.isDeflected() ? 12573 : interaction.getVictim().getDefenceAnimation());
		if (interaction.isDeflected()) {
			interaction.getVictim().graphics(2230);
		}
		return true;
	}

	@Override
	public CombatType getCombatType() {
		return CombatType.MELEE;
	}

	@Override
	public int getSpecialEnergyAmount() {
		return 500;
	}

	@Override
	public int getCooldownTicks() {
		return 5;
	}

}