package org.dementhium.model.npc.impl;

import org.dementhium.model.Mob;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.impl.npc.ChillerAction;
import org.dementhium.model.npc.NPC;

/**
 * @author Wildking72
 */
public class Chiller extends NPC {

	/**
	 * The combat action to use.
	 */
	private static CombatAction combatAction = new ChillerAction();
	
    /**
     * Constructs a new {@code Chiller} {@code Object}.
     *
     * @param id The npc id.
     */
    public Chiller(int id) {
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