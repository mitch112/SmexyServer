package org.dementhium.model.combat.impl.spells.ancient;

import java.util.ArrayList;

import org.dementhium.model.Item;
import org.dementhium.model.Mob;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.ExtraTarget;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.combat.MagicFormulae;
import org.dementhium.model.combat.MagicSpell;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.net.ActionSender;

/** 
 * Handles the Blood barrage ancient spell.
 * @author Emperor
 *
 */
public class BloodBarrage extends MagicSpell {
	public Player player;
	@Override
	public boolean castSpell(Interaction interaction) {
		
		
		if (interaction.getSource().getPlayer().getSkills().getLevel(Skills.MAGIC) < 92) {
			interaction.getSource().getPlayer().sendMessage("You need a level of 92 Magic to use blood barrage.");
			return false;
		}
			
		
		if (!interaction.getSource().isMulti() || !interaction.getVictim().isMulti()) {
			interaction.setTargets(new ArrayList<ExtraTarget>());
			interaction.getTargets().add(new ExtraTarget(interaction.getVictim()));
		} else {
			interaction.setTargets(CombatUtils.getTargetList(interaction.getSource(), interaction.getVictim(), 1, 8));
		}
		interaction.getSource().animate(1979);
		int toHeal = 0;
		int maximum = (int) MagicFormulae.getMaximumDamage(interaction.getSource().getPlayer(), interaction.getVictim(), this);
		for (ExtraTarget m : interaction.getTargets()) {
			if (m.getVictim().isPlayer()) {
				m.setDeflected(m.getVictim().getPlayer().getPrayer().usingPrayer(1, 7));
			}
			m.setDamage(Damage.getDamage(interaction.getSource(), m.getVictim(), CombatType.MAGIC, 
				MagicFormulae.getDamage(interaction.getSource().getPlayer(), m.getVictim(), this)));
			m.getDamage().setMaximum(maximum);
			if (m.getDamage().getHit() > 0) {
				if (m.getVictim().isPlayer()) {
					ActionSender.sendMessage(m.getVictim().getPlayer(), "Your lifepoints have been drained.");
				}
				toHeal += m.getDamage().getHit();
			}
			Interaction inter = new Interaction(interaction.getSource(), m.getVictim());
			inter.setDamage(m.getDamage());
			interaction.getSource().preCombatTick(inter);
		}
		if (toHeal > 0) {
			interaction.getSource().heal((int) (toHeal * 0.25));
			ActionSender.sendMessage(interaction.getSource().getPlayer(), "You drain some of your opponents' lifepoints.");
		}
		
		return true;
	}
	
	@Override
	public boolean tick(Interaction interaction) {
		
		if (interaction.getTicks() < 2) {
			for (ExtraTarget m : interaction.getTargets()) {
				if (m.isDeflected()) {
					m.getVictim().graphics(2228);
				}
				m.getVictim().animate(m.isDeflected() ? 12573 : m.getVictim().getDefenceAnimation());
			}
		}
		
		return false;
	}

	@Override
	public boolean endSpell(Interaction interaction) {
		
		for (ExtraTarget m : interaction.getTargets()) {
			if (m.getDamage().getHit() > -1) {
				m.getVictim().graphics(377, 0);
				m.getVictim().getDamageManager().damage(
						interaction.getSource(), m.getDamage(), DamageType.MAGE);
			} else {
				m.getVictim().graphics(85, 96);
			}
			if (m.getDamage().getVenged() > 0) {
				m.getVictim().submitVengeance(interaction.getSource(), m.getDamage().getVenged());
			}
			if (m.getDamage().getDeflected() > 0) {
				interaction.getSource().getDamageManager().damage(m.getVictim(), 
						m.getDamage().getDeflected(), 
						m.getDamage().getDeflected(), DamageType.DEFLECT);
			}
			if (m.getDamage().getRecoiled() > 0) {
				interaction.getSource().getDamageManager().damage(m.getVictim(), 
						m.getDamage().getRecoiled(), 
						m.getDamage().getRecoiled(), DamageType.DEFLECT);
			}
			m.getVictim().retaliate(interaction.getSource());
		}
		return true;
		
		
	}
	
	@Override
	public double getExperience(Interaction interaction) {
		
		double total = 0;;
		
		for (ExtraTarget e : interaction.getTargets()) {
			total += 51.0;
			if (e.getDamage().getHit() > 0) {
				interaction.getSource().getPlayer().getSkills().addExperience(Skills.HITPOINTS, e.getDamage().getHit() * 0.133);
				total += e.getDamage().getHit() * 0.2;
			}
		}
		return total;


	}

	@Override
	public int getStartDamage(Player source, Mob victim) {
		return 260 + getBaseDamage();
	}

	@Override
	public int getNormalDamage() {
		return 24;
	}

	@Override
	public int getBaseDamage() {
		return 30;
	}
	
	@Override
	public int getAutocastConfig() {
		return 91;
	}

	@Override
	public Item[] getRequiredRunes() {
		return new Item[] { new Item(565, 4), new Item(560, 4), new Item(566, 1) };
	}
}