package org.dementhium.model.combat.impl.npc;

import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.MeleeFormulae;
import org.dementhium.model.mask.Animation;
import org.dementhium.model.mask.Graphic;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.model.World;
import org.dementhium.tickable.Tick;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.player.Skills;

import java.util.Random;

/**
 * @author Wildking72
 */
public class NomadAction extends CombatAction {

	@SuppressWarnings("unused")
	private static NPC npc;
	private int attack = 0;

	Random RANDOM = new Random();

    private static final Animation ATTACK_ANIM = Animation.create(12696);
	private static final Animation FIRST_ATTACK = Animation.create(12703);
	
    private static final Graphic FIRST_GFX = Graphic.create(2754);
	private static final Graphic ORB = Graphic.create(2855);
	private static final Graphic ORB_TAKE = Graphic.create(2755);
	private static final Graphic TORNADO = Graphic.create(2788);
	private static final Graphic SMOKE = Graphic.create(2845);
	
	@SuppressWarnings("static-access")
	public void setFirst(int first) {
		this.first = first;
	}
	
	public int getFirst() {
		return first;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getAttack() {
		return attack;
	}
	
    /**
     * Constructs a new {@code NomadAction} {@code Object}.
     */
	public NomadAction() {
		super(true);
	}
	
	private static int first = 0;
	
	@Override
	public boolean commenceSession() {
	setFirst(0);
	int type1 = 1 + RANDOM.nextInt(3);
	int type = RANDOM.nextInt(3);
		interaction.getSource().getCombatExecutor().setTicks(interaction.getSource().getAttackDelay());
		if (type1 == 2) {
			interaction.getSource().animate(ATTACK_ANIM);
			if (attack < 1) {
				interaction.getSource().animate(FIRST_ATTACK);
					World.getWorld().submit(new Tick(2) {
					int count;
						@Override
						public void execute() {
						if (count < 1) {
							interaction.getSource().graphics(FIRST_GFX);
							int Modifications = (int) Math.floor(2 + (interaction.getVictim().getPlayer().getSkills().getLevelForExperience(Skills.STRENGTH) * 0.25));
							int Modifications1 = (int) Math.floor(2 + (interaction.getVictim().getPlayer().getSkills().getLevelForExperience(Skills.ATTACK) * 0.25));
							int Modifications2 = (int) Math.floor(2 + (interaction.getVictim().getPlayer().getSkills().getLevelForExperience(Skills.DEFENCE) * 0.25));
							interaction.getVictim().getPlayer().getSkills().decreaseLevelToZero(Skills.STRENGTH, Modifications);
							interaction.getVictim().getPlayer().getSkills().decreaseLevelToZero(Skills.DEFENCE, Modifications1);
							interaction.getVictim().getPlayer().getSkills().decreaseLevelToZero(Skills.ATTACK, Modifications2);
							interaction.getSource().forceText("Feel the shock!");
							count++;
							attack++;
						} else {
							this.stop();
						}
					}
				});
				interaction.getSource().setAttribute("damageType", DamageType.MAGE);
			} else if (attack >= 1 && interaction.getSource().getHitPoints() < 2000) {
				interaction.getSource().animate(12697);
				interaction.getSource().graphics(ORB);
				interaction.getVictim().graphics(ORB_TAKE);
				interaction.getSource().heal(RANDOM.nextInt(400));
				interaction.getVictim().heal(RANDOM.nextInt(800)); //He heals you too!
				interaction.getSource().setAttribute("damageType", DamageType.HEAL);
			} else if (attack >= 1 && type >= 2) {
				interaction.getSource().animate(12697);
				interaction.getSource().graphics(SMOKE);
				interaction.getVictim().graphics(TORNADO);
				interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 110);
				interaction.getSource().setAttribute("damageType", DamageType.MAGE);
			} else if (attack >= 1 && type <= 1) {
				interaction.getSource().animate(12697);
				interaction.getVictim().graphics(2867);
				interaction.getSource().setAttribute("damageType", DamageType.DISEASED);
			}
			interaction.setDamage(Damage.getDamage(interaction.getSource(), 
					interaction.getVictim(), CombatType.MAGIC, 
					interaction.getSource().getRandom().nextInt(500)));
			interaction.getDamage().setMaximum(500);
			return true;
			} else if (type1 == 3) {
				setFirst(1);
				interaction.getSource().animate(ATTACK_ANIM);
				interaction.getSource().setAttribute("damageType", DamageType.MELEE);
				interaction.setDamage(Damage.getDamage(interaction.getSource(), 
				interaction.getVictim(), CombatType.MELEE, 
				interaction.getSource().getRandom().nextInt(400)));
				interaction.getDamage().setMaximum(400);
				return true;
		}
		interaction.getSource().animate(ATTACK_ANIM);
		if (interaction.getVictim().isPlayer()) {
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, 9));
		}
		interaction.setDamage(
				Damage.getDamage(interaction.getSource(), interaction.getVictim(), 
						CombatType.MELEE, MeleeFormulae.getDamage(interaction.getSource(), 
								interaction.getVictim())));
		interaction.getDamage().setMaximum(MeleeFormulae.getMeleeDamage(interaction.getSource(), 1.0));
		return true;
	}

	@Override
	public boolean executeSession() {
		if (!interaction.getVictim().isAnimating()) {
			interaction.getVictim().animate(interaction.isDeflected() ? 12573 : interaction.getVictim().getDefenceAnimation());
		}
		if (interaction.isDeflected()) {
			interaction.getVictim().graphics(2230);
		}
		return true;
	}

	@Override
	public boolean endSession() {
		interaction.getVictim().getDamageManager().damage(
				interaction.getSource(), interaction.getDamage(), 
				(DamageType) interaction.getSource().getAttribute("damageType"));
		if (interaction.getDamage().getVenged() > 0) {
			interaction.getVictim().submitVengeance(
					interaction.getSource(), interaction.getDamage().getVenged());
		}
		if (interaction.getDamage().getDeflected() > 0) {
			interaction.getSource().getDamageManager().damage(interaction.getVictim(),
					interaction.getDamage().getDeflected(), interaction.getDamage().getDeflected(), DamageType.DEFLECT);
		}
		if (interaction.getDamage().getRecoiled() > 0) {
			interaction.getSource().getDamageManager().damage(interaction.getVictim(),
					interaction.getDamage().getRecoiled(), interaction.getDamage().getRecoiled(), DamageType.DEFLECT);
		}
		interaction.getVictim().retaliate(interaction.getSource());
		return true;
	}

	@Override
	public CombatType getCombatType() {
		if (getFirst() == 1) {
			return CombatType.MELEE;
		} else {
			return CombatType.MAGIC;
		}
	}
}
