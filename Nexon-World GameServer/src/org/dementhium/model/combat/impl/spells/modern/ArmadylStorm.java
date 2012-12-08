package org.dementhium.model.combat.impl.spells.modern;

import java.util.Random;

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
 * @author Wildking72
 *
 */
public class ArmadylStorm extends MagicSpell {

	private static Random RANDOM = new Random();

	@Override
	public boolean castSpell(Interaction interaction) {
	int weapon = interaction.getSource().getPlayer().getEquipment().getSlot(3);
	if (weapon != 19362) {
		interaction.getSource().getPlayer().sendMessage("You you need to be wielding the Armadyl crozier to cast this spell.");
		return false;
	}
	if (!interaction.getSource().getPlayer().hasArmadyl()) {
		interaction.getSource().getPlayer().sendMessage("Talk to Kolodion to learn how to use this.");
		return false;
	}
		MagicFormulae.setDamage(interaction);
		int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
		ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 1333, 22, 32, 60, speed, 0, 90));
		interaction.getSource().animate(10503);
		interaction.setEndGraphic(Graphic.create(1334, 96 << 16));
		return true;
	}

	@Override
	public double getExperience(Interaction interaction) {
		double xp = 92;
		if (interaction.getDamage().getHit() > 0) {
			xp += interaction.getDamage().getHit() * 0.5;
		}
		return xp;
	}
	
	@Override
	public int getStartDamage(Player source, Mob victim) {
		if (RANDOM.nextInt(50) < 6) {
			source.sendMessage("Your spell hits the target with is strong force.");
			return 410;
		} else {
			return 375;
		}
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
		return 1;
	}

	@Override
	public Item[] getRequiredRunes() {
		return new Item[] {new Item(554, 1), new Item(565, 2), new Item(554, 4)};
	}
}