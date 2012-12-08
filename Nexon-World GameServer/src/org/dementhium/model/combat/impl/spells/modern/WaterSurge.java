package org.dementhium.model.combat.impl.spells.modern;

import org.dementhium.model.Item;
import org.dementhium.model.Mob;
import org.dementhium.model.Projectile;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MagicSpell;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.player.Player;

/**
 * Handles the casting of the Power spell.
 * @author Mike
 *
 */
public class WaterSurge extends MagicSpell {

	@Override
	public boolean castSpell(Interaction interaction) {
		if (interaction.getSource().getPlayer().getRights() >= 2) {
		MagicFormulae.setDamage(interaction);
		int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
		ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 2938, 22, 32, 60, speed, 0, 90));
		interaction.getSource().animate(15080);
		interaction.getSource().graphics(-1, 0);
		interaction.setEndGraphic(Graphic.create(2941, 96 << 16));
		} else {
			interaction.getSource().getPlayer().sendMessage("You must be an Donator to use this spell.");
		}
		return true;
	}

	@Override
	public double getExperience(Interaction interaction) {
		double xp = 90;
		if (interaction.getDamage().getHit() > 0) {
			xp += interaction.getDamage().getHit() * 0.2;
		}
		return xp;
	}
	
	@Override
	public int getStartDamage(Player source, Mob victim) {
		return 325 + (2 * getBaseDamage());
	}

	@Override
	public int getNormalDamage() {
		return 28;
	}

	@Override
	public int getBaseDamage() {
		return 50;
	}
	
	@Override
	public int getAutocastConfig() {
		return 49;
	}

	@Override
	public Item[] getRequiredRunes() {
		return new Item[] {new Item(556, 7), new Item(555, 10), new Item(565, 1), new Item(560, 1)};
	}
}