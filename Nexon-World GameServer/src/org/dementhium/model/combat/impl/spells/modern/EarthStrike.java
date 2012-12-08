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
 * Handles the casting of the Earth strike spell.
 * @author Emperor
 *
 */
public class EarthStrike extends MagicSpell {
	
	@Override
	public boolean castSpell(Interaction interaction) {
		if (interaction.getSource().getPlayer().getSkills().getLevel(Skills.MAGIC) < 9) {
			interaction.getSource().getPlayer().sendMessage("You need a level of 9 Magic to use earth strike.");
			return false;
		}
		MagicFormulae.setDamage(interaction);
		int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
		ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 2718, 38, 32, 54, speed, 0, 124));
		interaction.getSource().animate(14209);
		interaction.getSource().graphics(2713, 0);
		interaction.setEndGraphic(Graphic.create(2723, 96 << 16));
		return true;
	}

	@Override
	public double getExperience(Interaction interaction) {
		double xp = 9.5;
		if (interaction.getDamage().getHit() > 0) {
			xp += interaction.getDamage().getHit() * 0.2;
		}
		return xp;
	}

	@Override
	public int getStartDamage(Player source, Mob victim) {
		return victim.isNPC() && victim.getNPC().getId() == 205 ? 
				80 + getBaseDamage() : 2 * getBaseDamage();
	}

	@Override
	public int getNormalDamage() {
		return 4;
	}

	@Override
	public int getBaseDamage() {
		return 30;
	}
	
	@Override
	public int getAutocastConfig() {
		return 7;
	}
	
	@Override
	public Item[] getRequiredRunes() {
		return new Item[] { new Item(556, 1), new Item(557, 2), new Item(558, 1) };
	}
}
