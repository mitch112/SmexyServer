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
import org.dementhium.model.World;

/**
 * Handles the casting of the Power spell.
 * @author Wildking72
 *
 */
public class TeleBlock extends MagicSpell {
	
	
	@SuppressWarnings("static-access")
	@Override
	public boolean castSpell(Interaction interaction) {
		if (interaction.getSource().getPlayer().getSkills().getLevel(Skills.MAGIC) < 85) {
			interaction.getSource().getPlayer().sendMessage("You need a magic level of 85 to use Teleblock.");
			return false;
		}
		interaction.getSource().turnTo(interaction.getVictim());
		MagicFormulae.setDamage(interaction);
		if (interaction.getVictim().getAttribute("teleblock", 0) < 1 && interaction.getDamage().getHit() > -1) {
			int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
			ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 1842, 28, 32, 55, speed, 3, 161));
			interaction.getSource().animate(10503);
			interaction.getSource().graphics(1841, 0);
			interaction.setEndGraphic(Graphic.create(1843, 96 << 16));
			interaction.getVictim().setAttribute("teleblock", World.getWorld().getTicks() + 20);
			return false;
		} else {
			interaction.getSource().getPlayer().sendMessage("You have already teleblocked your victim!");
			return true;
		}
	}
	
	@Override
	public double getExperience(Interaction interaction) {
		return 40;
	}
	
	@Override
	public int getStartDamage(Player source, Mob victim) {
			return 0;
	} 

	@Override
	public int getNormalDamage() {
		return 0;
	}

	@Override
	public int getBaseDamage() {
		return 0;
	}
	
	@Override
	public int getAutocastConfig() {
		return -1;
	}

	@Override
	public Item[] getRequiredRunes() {
		return new Item[] {new Item(562, 1), new Item(563, 1), new Item(560, 1)};
	}
}