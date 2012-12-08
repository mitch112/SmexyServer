package org.dementhium.model.npc.impl;

import org.dementhium.model.Mob;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.model.combat.impl.npc.WarmongerAction;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.combat.Interaction;
import org.dementhium.util.Misc;

import java.util.Random;

/**
 * @author Wildking72
 */
public class Warmonger extends NPC {

	@SuppressWarnings("unused")
	private static Interaction interaction;
	@SuppressWarnings("unused")
	private static Random RANDOM = new Random();

	/**
	 * The combat action to use.
	 */
	private static CombatAction combatAction = new WarmongerAction();
	
    /**
     * Constructs a new {@code Warmonger} {@code Object}.
     *
     * @param id The npc id.
     */
    public Warmonger(int id) {
        super(id);
    }
    
    @Override
    public int getAttackDelay() {
    	return 6;
    }
    
	@SuppressWarnings("unused")
	@Override
	public Damage updateHit(Mob source, int hit, CombatType type) {
	int currentHit = hit;
	if (CombatUtils.usingProtection(this, type)) {
			currentHit = (int) (hit * (source.isPlayer() ? 0.6 : 0));
		}
		if (type == CombatType.MAGIC) {
			return new Damage(0);
		}
		if (source.isPlayer()) {
			if (source.getAttribute("vengeance", true)) {
				source.getPlayer().sendMessage("The Warmonger reversed the vengeance effect!.");
				source.setAttribute("vengeance", false);
				source.getDamageManager().miscDamage(Misc.random(1, 300), DamageType.RED_DAMAGE);
			}
		}
		return new Damage(hit);
	}
	
	@Override
	public CombatAction getCombatAction() {
		return combatAction;
	}
}