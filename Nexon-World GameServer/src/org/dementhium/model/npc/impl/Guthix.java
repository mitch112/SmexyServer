package org.dementhium.model.npc.impl;

import org.dementhium.model.Mob;
import org.dementhium.model.combat.CombatAction;
import org.dementhium.model.combat.CombatType;
import org.dementhium.model.combat.CombatUtils;
import org.dementhium.model.combat.Damage;
import org.dementhium.model.misc.DamageManager.DamageType;
import org.dementhium.model.combat.impl.npc.GuthixAction;
import org.dementhium.model.npc.NPC;
import org.dementhium.model.combat.Interaction;
import org.dementhium.model.Item;
import org.dementhium.model.player.Equipment;
import org.dementhium.util.Misc;

import java.util.Random;

/**
 * @author Wildking72
 */
public class Guthix extends NPC {

	private static Interaction interaction;
	@SuppressWarnings("unused")
	private static Random RANDOM = new Random();

	/**
	 * The combat action to use.
	 */
	private static CombatAction combatAction = new GuthixAction();
	
    /**
     * Constructs a new {@code Guthix} {@code Object}.
     *
     * @param id The npc id.
     */
    public Guthix(int id) {
        super(id);
    }
    
    @Override
    public int getAttackDelay() {
    	return 6;
    }
    
	@Override
	public Damage updateHit(Mob source, int hit, CombatType type) {
		Item weapon = source.getPlayer().getEquipment().get(Equipment.SLOT_WEAPON);
		Item cape = source.getPlayer().getEquipment().get(Equipment.SLOT_CAPE);
		Item shield = source.getPlayer().getEquipment().get(Equipment.SLOT_SHIELD);
		Item amulet = source.getPlayer().getEquipment().get(Equipment.SLOT_AMULET);
		Item gloves = source.getPlayer().getEquipment().get(Equipment.SLOT_HANDS);
	int currentHit = hit;
	if (CombatUtils.usingProtection(this, type)) {
			currentHit = (int) (hit * (source.isPlayer() ? 0.6 : 0));
		}
		if (type == CombatType.MAGIC) {
			return new Damage(0);
		}
		if (source.isPlayer() && currentHit > 0) {
			if (weapon != null && weapon.getDefinition().getName().contains("zamorak") || 
			cape != null && cape.getDefinition().getName().contains("zamorak") ||
			shield != null && shield.getDefinition().getName().contains("zamorak") ||
			amulet != null && amulet.getDefinition().getName().contains("zamorak") ||
			gloves != null && gloves.getDefinition().getName().contains("zamorak")) {
				source.getPlayer().sendMessage("Your zamorak equipment hurts the Guthix Wizard.");
				interaction.getVictim().getDamageManager().miscDamage(Misc.random(1, 122), DamageType.RED_DAMAGE);
			}
		}
		return new Damage(hit);
	}
	
	@Override
	public CombatAction getCombatAction() {
		return combatAction;
	}
}