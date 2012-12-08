package org.dementhium.model.npc.impl;

import org.dementhium.model.Mob;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.impl.npc.NecroLordAction;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.combat.Interaction;
import java.util.Random;

/**
 * @author Wildking72
 */
public class NecroLord extends NPC {

	@SuppressWarnings("unused")
	private static Interaction interaction;
	@SuppressWarnings("unused")
	private static Random RANDOM = new Random();

	/**
	 * The combat action to use.
	 */
	private static CombatAction combatAction = new NecroLordAction();
	
    /**
     * Constructs a new {@code NecroLord} {@code Object}.
     *
     * @param id The npc id.
     */
    public NecroLord(int id) {
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
		return new Damage(hit);
	}
	
	@Override
	public CombatAction getCombatAction() {
		return combatAction;
	}
}