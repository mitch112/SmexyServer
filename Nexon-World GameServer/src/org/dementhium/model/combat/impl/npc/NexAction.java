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
import java.util.Random;

/**
 * @author Wildking72
 */
public class NexAction extends CombatAction {

	Random RANDOM = new Random();

    private static final Animation ATTACK_ANIM = Animation.create(12696);
	private static final Animation FIRST_ATTACK = Animation.create(12703);
	
    private static final Graphic FIRST_GFX = Graphic.create(2754);
	

	

	
	private static final Graphic TURMOIL_GRAPHICS = Graphic.create(1204);
	public static final int FUMUS = 13451, UMBRA = 13452, CRUOR = 13453, GLACIES = 13454;
	
	private boolean noEscapeAttack;
	@SuppressWarnings("static-access")
	public void setFirst(int first) {
		this.first = first;
	}
	
	public int getFirst() {
		return first;
	}
	
    /**
     * Constructs a new {@code NomadAction} {@code Object}.
     */
	public NexAction() {
		super(true);
	}
	
	private static int first = 0;

	public boolean noEscapeAttack() {
		return noEscapeAttack;
	}
	
		@Override
		public boolean commenceSession() {
		int type = RANDOM.nextInt(4);
			interaction.getSource().getCombatExecutor().setTicks(interaction.getSource().getAttackDelay());
			if (interaction.getSource().getRandom().nextInt(10) < 5) {
				interaction.getSource().animate(ATTACK_ANIM);
				if (first < 1) {
					interaction.getSource().animate(FIRST_ATTACK);
					World.getWorld().submit(new Tick(2) {
					int count;
					@Override
						public void execute() {
								if (count < 1) {
									interaction.getSource().graphics(FIRST_GFX);
									count++;
									first++;
									setFirst(1);
							} else {
								this.stop();
							}
						}
					});
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 4000) {
					interaction.getSource().forceText("Now the Power of Zaros!");
					interaction.getSource().graphics(TURMOIL_GRAPHICS);
					this.stop();
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 3900) {
					interaction.getSource().forceText("May the virus flow within you!");
					interaction.getVictim().forceText("*Cough*");
					interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 220);
					this.stop();
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 3800) {
					interaction.getSource().forceText(" ");
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 7000) {
	                interaction.getSource().teleport(2916, 5193, 0);
	                this.stop();
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 5000) {
	                interaction.getSource().teleport(2934, 5214, 0);
	                this.stop();
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 3000) {
	                interaction.getSource().teleport(2925, 5203, 0);
	                this.stop();
				} else if (first >= 1 && interaction.getSource().getHitPoints() < 9000) {
					interaction.getSource().forceText("May the virus flow within you!");
					interaction.getVictim().forceText("*Cough*");
					interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 220);
					this.stop();
				interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 220);
				this.stop();
				interaction.getSource().heal(RANDOM.nextInt(350));
				interaction.getVictim().heal(RANDOM.nextInt(400)); //He heals you too!
				interaction.getSource().setAttribute("damageType", DamageType.HEAL);
			} else if (first >= 1 && type >= 2) {
				interaction.getVictim().getPoisonManager().poison(interaction.getSource(), 110);
				interaction.getSource().setAttribute("damageType", DamageType.MAGE);
			} else if (first >= 1 && type < 2) {
				interaction.getSource().setAttribute("damageType", DamageType.DISEASED);
			}
			interaction.setDamage(Damage.getDamage(interaction.getSource(), 
					interaction.getVictim(), CombatType.MAGIC, 
					interaction.getSource().getRandom().nextInt(700)));
			interaction.getDamage().setMaximum(700);
			return true;
		}
			interaction.getSource().setAttribute("damageType", DamageType.RED_DAMAGE);
		if (interaction.getVictim().isPlayer()) {
			interaction.setDeflected(interaction.getVictim().getPlayer().getPrayer().usingPrayer(1, 9));
		}
		interaction.getSource().animate(ATTACK_ANIM);
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
		return CombatType.MAGIC;
	}

}