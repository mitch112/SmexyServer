package org.dementhium.model.npc.impl;

import org.dementhium.model.Mob;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.combat.impl.npc.NomadAction;
import org.dementhium.model.npc.NPC;

/**
 * @author Wildking72
 */
public class Nomad extends NPC {

	/**
	 * The combat action to use.
	 */
	private static CombatAction combatAction = new NomadAction();
	
    /**
     * Constructs a new {@code Nomad} {@code Object}.
     *
     * @param id The npc id.
     */
    public Nomad(int id) {
        super(id);
    }
    
    @Override
    public int getAttackDelay() {
    	return 5;
    }
    
	@Override
	public Damage updateHit(Mob source, int hit, CombatType type) {
	int currentHit = hit;
	if (CombatUtils.usingProtection(this, type)) {
			currentHit = (int) (hit * (source.isPlayer() ? 0.6 : 0));
		}
		if (type == CombatType.MAGIC) {
			return new Damage(0);
		}
		if (source.isPlayer() && currentHit > 0) {
			if (source.getPlayer().getEquipment().getSlot(3) == 19784) {
				source.getPlayer().sendMessage("You shock the Nomad with your Korasi.");
				hit *= 2.90;
				source.heal(hit);
			}
		}
		return new Damage(hit);
	}
	
	@Override
	public CombatAction getCombatAction() {
		return combatAction;
	}
}