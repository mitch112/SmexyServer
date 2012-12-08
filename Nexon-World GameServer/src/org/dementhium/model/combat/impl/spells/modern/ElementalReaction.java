package org.dementhium.model.combat.impl.spells.modern;

import java.util.ArrayList;

import org.dementhium.model.Item;
import org.dementhium.model.Mob;
import org.dementhium.model.Projectile;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.ExtraTarget;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MagicSpell;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.ProjectileManager;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.util.Misc;

/**
 * Handles the spell Elemental reaction
 * @author Wildking72
 * @author Emperor
 */
public class ElementalReaction extends MagicSpell {

	@Override
	public boolean castSpell(Interaction interaction) {
		int type = Misc.random(1, 4);
		/*if (interaction.getVictim().isPlayer()) {
			player.sendMessage("You cannot use this on players.");
				return false;
			}*/
		if (interaction.getSource().getPlayer().getSkills().getLevel(6) >= 60) {
			MagicFormulae.setDamage(interaction);
			int speed = (int) (46 + interaction.getSource().getLocation().getDistance(interaction.getVictim().getLocation()) * 10);
			if (type == 1) {
				ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 1937, 22, 32, 60, speed, 0, 90));
				interaction.getSource().graphics(1936, 0);
				interaction.getSource().animate(12031);
				interaction.setEndGraphic(Graphic.create(1938, 96 << 16));
			} else if (type == 2) {
				if (!interaction.getSource().isMulti() || !interaction.getVictim().isMulti()) {
			interaction.setTargets(new ArrayList<ExtraTarget>());
			interaction.getTargets().add(new ExtraTarget(interaction.getVictim()));
		} else {
			interaction.setTargets(CombatUtils.getTargetList(interaction.getSource(), interaction.getVictim(), 1, 8));
		}
		interaction.getSource().animate(12009);
		ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 2880, 22, 32, 60, speed, 0, 90));
		int maximum = (int) MagicFormulae.getMaximumDamage(interaction.getSource().getPlayer(), interaction.getVictim(), this);
		for (ExtraTarget m : interaction.getTargets()) {
			if (m.getVictim().isPlayer()) {
				m.setDeflected(m.getVictim().getPlayer().getPrayer().usingPrayer(1, 7));
			}
			m.setDamage(Damage.getDamage(interaction.getSource(), m.getVictim(), CombatType.MAGIC, 
				MagicFormulae.getDamage(interaction.getSource().getPlayer(), m.getVictim(), this)));
			m.getDamage().setMaximum(maximum);
			if (m.getDamage().getHit() > -1 && m.getVictim().isPlayer() && m.getVictim().getRandom().nextInt(20) < 4) {
				Player p = (Player) m.getVictim();
				int defenceLevel = p.getSkills().getLevel(Skills.DEFENCE);
				defenceLevel -= defenceLevel * 0.15;
				p.getSkills().set(Skills.DEFENCE, defenceLevel);
			}
			Interaction inter = new Interaction(interaction.getSource(), m.getVictim());
			inter.setDamage(m.getDamage());
			interaction.getSource().preCombatTick(inter);
		}
			interaction.setEndGraphic(Graphic.create(2815, 96 << 16));
			} else if (type == 3) {
				ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 1926, 22, 32, 60, speed, 0, 90));
				interaction.getSource().graphics(1925, 0);
				interaction.getSource().animate(12031);
				interaction.setEndGraphic(Graphic.create(1927, 96 << 16));
			} else {
				ProjectileManager.sendProjectile(Projectile.create(interaction.getSource(), interaction.getVictim(), 2938, 22, 32, 60, speed, 0, 90));
				interaction.getSource().animate(15080);
				interaction.getSource().graphics(-1, 0);
				interaction.setEndGraphic(Graphic.create(2941, 96 << 16));
			}
			return true;
		} else {
			interaction.getSource().getPlayer().sendMessage("You need a magic level of 98 to cast this spell.");
			return false;
		}
	}

	@Override
	public double getExperience(Interaction interaction) {
		double xp = 254.5;
		if (interaction.getDamage().getHit() > 0) {
			xp += interaction.getDamage().getHit() * 0.2;
		}
		return xp;
	}
	
	@Override
	public int getStartDamage(Player source, Mob victim) {
		if (Misc.random(1, 50) < 3) {
			source.sendMessage("You hit the target with a fiercum blow.");
			source.heal(getBaseDamage());
			return 460 + (2 * getBaseDamage());
		} else {
			return 365;
		}
	}

	@Override
	public int getNormalDamage() {
		return 30;
	}

	@Override
	public int getBaseDamage() {
		return Misc.random(50, 100);
	}
	
	@Override
	public int getAutocastConfig() {
		return 1;
	}

	@Override
	public Item[] getRequiredRunes() {
		return new Item[] {new Item(554, 2), new Item(556, 4), new Item(565, 2)};
	}
}