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
import org.dementhium.model.player.Skills;

/**
 * Handles the casting of the Water wave spell.
 * @author Emperor
 *
 */
public class WaterWave extends MagicSpell {
	
	@Override
	public boolean castSpell(Interaction interaction) {
		if (interaction.getSource().getPlayer().getSkills().getLevel(Skills.MAGIC) < 65) {
			interaction.getSource().getPlayer().sendMessage("You need a level of 65 Magic to use water wave.");
			return false;
		}
		MagicFormulae.setDamage(interaction);
		int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
		ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 2706, 28, 32, 55, speed, 3, 161));
		interaction.getSource().animate(10542);
		interaction.getSource().graphics(2701, 0);
		interaction.setEndGraphic(Graphic.create(2711, 96 << 16));
		return true;
	}

	@Override
	public double getExperience(Interaction interaction) {
		double xp = 37.5;
		if (interaction.getDamage().getHit() > 0) {
			xp += interaction.getDamage().getHit() * 0.2;
		}
		return xp;
	}

	@Override
	public int getStartDamage(Player source, Mob victim) {
		return 160 + getBaseDamage();
	}

	@Override
	public int getNormalDamage() {
		return 12;
	}

	@Override
	public int getBaseDamage() {
		return 20;
	}
	
	@Override
	public int getAutocastConfig() {
		return 29;
	}
	
	@Override
	public Item[] getRequiredRunes() {
		return new Item[] { new Item(556, 5), new Item(555, 7), new Item(565, 1) };
	}
}