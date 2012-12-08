
package org.dementhium.model.mask;

import org.dementhium.model.player.Player;


/**
 * @author Byte Me
 */
public class Appearance {
    public static enum Gender {
        FEMALE(1), MALE(0);

        public static Gender forValue(int value) {
            switch (value) {
                case 0:
                    return MALE;
                case 1:
                    return FEMALE;
            }
            return null;
        }

        private int value;

        private Gender(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }
    }

    private int[] color = new int[5];
    private Gender gender = Gender.MALE;
    private int[] look = new int[7];
    private int mobStatus = 0;
    private int npcType = -1;
    private int pkIcon = -1;
    @SuppressWarnings("unused")
	private Player player;
    private int prayerIcon = -1;

	public void resetAppearence() {
		this.setLooks(new int[7]);
		this.setColors(new int[5]);
		look[0] = 3; // Hair
		look[1] = 14; // Beard
		look[2] = 18; // Torso
		look[3] = 26; // Arms
		look[4] = 34; // Bracelets
		look[5] = 38; // Legs
		look[6] = 42; // Shoes
		color[2] = 16;
		color[1] = 16;
		for (int i = 0; i < 5; i++) {
			color[2] = 16;
			color[1] = 16;
			color[0] = 3;
		}
}
	
	public Appearance(Player player) {
		this.player = player;
		this.setNpcType(-1);
	}

    public int[] getLooks() {
        return look;
    }

    public int[] getColors() {
        return color;
    }

    public int getArms() {
        return look[3];
    }

    public int getBeard() {
        return look[1];
    }

    public int getColor(int index) {
        return color[index];
    }

    public int getFeet() {
        return look[6];
    }

    public int getFeetColor() {
        return color[4];
    }

    public Gender getGender() {
        return gender;
    }

    public int getHairColor() {
        return color[1];
    }

    public int getHands() {
        return look[4];
    }

    public int getHead() {
        return look[0];
    }

    public int getLegs() {
        return look[5];
    }

    public int getLegsColor() {
        return color[3];
    }

    public int getLook(int index) {
        return look[index];
    }

    public int getMobStatus() {
        return mobStatus;
    }

    public int getNpcType() {
        return npcType;
    }

    public int getPKIcon() {
        return pkIcon;
    }

    public int getPrayerIcon() {
        return prayerIcon;
    }

    public int getSkinColor() {
        return color[0];
    }

    public int getTorso() {
        return look[2];
    }

    public int getTorsoColor() {
        return color[2];
    }

    public boolean isNPC() {
        return npcType != -1;
    }
    
    public void setColor(int index, int color) {
        this.color[index] = color;
    }

    public void setColors(int[] colors) {
        this.color = colors;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLook(int index, int look) {
        this.look[index] = look;
    }

    public void setLooks(int[] looks) {
        this.look = looks;
    }

    public void setMobStatus(int mobStatus) {
        this.mobStatus = mobStatus;
    }

    public void setPKIcon(int pkIcon) {
        this.pkIcon = pkIcon;
    }

    public void setPrayerIcon(int prayerIcon) {
        this.prayerIcon = prayerIcon;
    }

    public void setNpcType(int npcType) {
        this.npcType = npcType;
    }

    public void toPlayer() {
        npcType = -1;
    }
}
