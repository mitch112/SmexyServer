package org.dementhium.model.combat.impl.spells.ancient;

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
import org.dementhium.model.player.Skills;
import org.dementhium.net.ActionSender;

/** 
 * Handles the Shadow rush ancient spell.
 * @author Emperor
 *
 */
public class ShadowRush extends MagicSpell {

	/**
	 * The {@code Random} instance.
	 */
	private static final Random RANDOM = new Random();
	
	@Override
	public boolean castSpell(Interaction interaction) {
		if (interaction.getSource().getPlayer().getSkills().getLevel(Skills.MAGIC) < 52) {
			interaction.getSource().getPlayer().sendMessage("You need a level of 52 Magic to use shadow rush.");
			return false;
		}
		MagicFormulae.setDamage(interaction);
		int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
		ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 378, 43, 0, 51, speed, 16, 64));
		interaction.getSource().animate(1978);
		if (interaction.getDamage().getHit() > -1 && interaction.getVictim().isPlayer() && RANDOM.nextInt(20) < 4) {
			Player p = interaction.getVictim().getPlayer();
			ActionSender.sendMessage(p, "You have been blinded.");
			int attackLevel = p.getSkills().getLevel(Skills.ATTACK);
			attackLevel -= attackLevel * 0.1;
			p.getSkills().set(Skills.ATTACK, attackLevel);
		}
		interaction.setEndGraphic(Graphic.create(379));
		return true;
	}

	@Override
	public double getExperience(Interaction interaction) {
		
		double xp = 31;
		
		if (interaction.getDamage().getHit() > 0) {
			xp += interaction.getDamage().getHit() * 0.2;
		}
		return xp;

	}

	@Override
	public int getStartDamage(Player source, Mob victim) {
		return 140 + getBaseDamage();
	}

	@Override
	public int getNormalDamage() {
		return 9;
	}

	@Override
	public int getBaseDamage() {
		return 20;
	}
	
	@Override
	public int getAutocastConfig() {
		return 65;
	}

	@Override
	public Item[] getRequiredRunes() {
		return new Item[] { new Item(556, 1), new Item(566, 1), new Item(562, 2), new Item(560, 2) };
	}
}