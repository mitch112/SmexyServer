/*package org.dementhium.content.skills.dungtask;

import org.dementhium.model.player.Player;
import org.dementhium.model.player.Skills;
import org.dementhium.util.Misc;


/**
 * @author Wolfey
 * @author Mystic Flow
 */
/*public class DungTask {


    public enum Master {
        VANNAKA(1597, new Object[][]{
		{"Bat", 1, 25, 50, 8.0},
                {"Goblin", 1, 10, 45, 10.0},
                {"Crawling Hand", 1, 10, 60, 10.0},
                {"Cave crawler", 5, 35, 75, 22.0},
                {"Cockatrice", 25, 50, 175, 37.0},
                {"Green dragon", 35, 35, 200, 40.0},
                {"Cave horror", 58, 50, 135, 55.0},
                {"Fire giant", 62, 40, 120, 111.0},
                {"Zombie hand", 70, 40, 60, 115.0},
                {"Skeletal hand", 60, 50, 100, 90.0},
                {"Werewolf", 65, 70, 120, 105.0},
                {"Baby red dragon", 50, 60, 120, 50.0},
                {"Moss giant", 35, 30, 100, 40.0},
                {"Bronze dragon", 50, 30, 70, 125.0},
                {"Iron dragon", 65, 30, 70, 173.2},
                {"Steel dragon", 79, 30, 70, 220.4},
                {"Black dragon", 1, 30, 100, 119.4},
                {"Abyssal demon", 85, 60, 130, 150.0},
                {"Tzhaar-Ket", 1, 30, 80, 140.0},
                {"Tzhaar-Xil", 1, 30, 80, 125.0},
		{"Bloodveld", 50, 60, 90, 120.0},
		{"Gargoyle", 75, 70, 100, 105.0},
		{"Hellhound", 1, 50, 100, 116.0},
		{"Aquanite", 79, 50, 90, 125.0},
		{"Turoth", 55, 30, 80, 79.0},
		{"Kurask", 70, 40, 100, 97.0},
		{"Jelly", 52, 30, 80, 75.0},
		{"Pyrefiend", 45, 30, 100, 45.0},
		{"Basilisk", 40, 50, 90, 75.0}
	}),
	KURADAL(9084, new Object[][]{
		{"Bloodveld", 50, 60, 90, 120.0},
		{"Gargoyle", 75, 70, 100, 105.9},
		{"Dark beast", 70, 90, 130, 225.4},
		{"Greater demon", 1, 50, 90, 87},
		{"Hellhound", 1, 50, 100, 116.0},
		{"Aquanites", 78, 50, 90, 125.0},
		{"Turoth", 55, 30, 80, 79.0},
		{"Kurask", 70, 40, 100, 97.0},
		{"Jelly", 52, 30, 80, 75.0},
		{"Pyrefiend", 45, 30, 100, 45.0},
		{"Abyssal demons", 85, 60, 130, 150.0},
		{"Basilisk", 40, 50, 90, 75.0},
		{"Desert strykewyrm", 77, 50, 90, 120.0},
		{"Jungle strykewyrm", 73, 40, 80, 110.0},
		{"Ice strykewyrm", 93, 68, 120, 330.0},
		{"Spiritual mage", 83, 60, 100, 88.0},
		{"Skeletal wyvern", 72, 40, 80, 210.0}
	}),
	DURADEL(8466, new Object[][]{
		{"Bloodveld", 50, 60, 90, 120.0},
		{"Gargoyle", 75, 70, 100, 105.0},
		{"Dark beast", 70, 90, 130, 225.4},
		{"Greater demon", 1, 50, 90, 87.0},
		{"Hellhound", 1, 50, 100, 116.0},
		{"Aquanites", 78, 50, 90, 125.0},
		{"Turoth", 55, 30, 80, 79.0},
		{"Kurask", 70, 40, 100, 97.0},
		{"Jelly", 52, 30, 80, 75.0},
		{"Pyrefiend", 45, 30, 100, 45.0},
		{"Basilisk", 40, 50, 90, 75.0},
		{"Abyssal demons", 85, 60, 130, 150.0}
		//{"Desert strykewyrm", 77, 50, 90, 120},
		//{"Jungle strykewyrm", 73, 40, 80, 110},
		//{"Ice strykewyrm", 93, 68, 120, 330},
		//{"Spiritual mage", 83, 60, 100, 88},
		//{"Skeletal wyvern", 72, 40, 80, 210},
	}),
	SUMONA(7780, new Object[][]{
                {"Bat", 1, 25, 50, 8.0},
                {"Goblin", 1, 10, 45, 10.0},
                {"Crawling Hand", 1, 10, 60, 10.0},
                {"Cave crawler", 5, 35, 75, 22.0},
                {"Cockatrice", 25, 50, 175, 37.0},
                {"Green dragon", 35, 35, 200, 40.0},
                {"Cave horror", 58, 50, 135, 55.0},
                {"Fire giant", 62, 40, 120, 111.0},
                {"Zombie hand", 70, 40, 60, 115.0},
                {"Skeletal hand", 60, 50, 100, 90.0},
                {"Werewolf", 65, 70, 120, 105.0},
                {"Baby red dragon", 50, 60, 120, 50.0},
                {"Moss giant", 35, 30, 100, 40.0},
                {"Bronze dragon", 50, 30, 70, 125.0},
                {"Iron dragon", 65, 30, 70, 173.2},
                {"Steel dragon", 79, 30, 70, 220.4},
		{"Abyssal demons", 85, 60, 130, 150.0},
		{"Nechryael", 80, 60, 120, 105.0},
		{"Aberrant spectre", 60, 50, 100, 90.0},
		{"Infernal mage", 45, 30, 80, 60.0},
		{"Bloodveld", 50, 60, 90, 120.0},
		{"Gargoyle", 75, 70, 100, 105.0},
		{"Dark beast", 70, 90, 130, 225.4},
		{"Greater demon", 1, 50, 90, 87.0},
		{"Hellhound", 1, 50, 100, 116.0},
		{"Aquanites", 78, 50, 90, 125.0},
		{"Turoth", 55, 30, 80, 79.0},
		{"Kurask", 70, 40, 100, 97.0},
		{"Jelly", 52, 30, 80, 75.0},
		{"Pyrefiend", 45, 30, 100, 45.0},
		{"Basilisk", 40, 50, 90, 75.0}
		//{"Desert strykewyrm", 77, 50, 90, 120},
		//{"Jungle strykewyrm", 73, 40, 80, 110},
		//{"Ice strykewyrm", 93, 68, 120, 330},
		//{"Spiritual mage", 83, 60, 100, 88},
		//{"Skeletal wyvern", 72, 40, 80, 210},
        });


        private int id;
        private Object[][] data;

        private Master(int id, Object[][] data) {
            this.id = id;
            this.data = data;
        }

        public static Master forId(int id) {
            for (Master master : Master.values()) {
                if (master.id == id) {
                    return master;
                }
            }
            return null;
        }

        public int getId() {
            return id;
        }

    }

    private Master master;
   /* private int taskId;
    private int taskAmount;

    public SlayerTask(Master master, int taskId, int taskAmount) {
        this.master = master;
        this.taskId = taskId;
        this.taskAmount = taskAmount;
    }

    public String getName() {
        return (String) master.data[taskId][0];
    }

    public static SlayerTask random(Player player, Master master) {
        SlayerTask task = null;
        while (true) {
            int random = player.getRandom().nextInt(master.data.length);
            int requiredLevel = (Integer) master.data[random][1];
            if (player.getSkills().getLevel(Skills.SLAYER) < requiredLevel) {
                continue;
            }
            if (random == 0 && !player.getRandom().nextBoolean()) {
                continue;
            }
            int minimum = (Integer) master.data[random][2];
            int maximum = (Integer) master.data[random][3];
            task = new SlayerTask(master, random, Misc.random(minimum, maximum));
            break;
        }
        return task;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getTaskAmount() {
        return taskAmount;
    }

    public void decreaseAmount() {
        taskAmount--;
    }

    public double getXPAmount() {
        return Double.parseDouble(master.data[taskId][4].toString());
    }

    public Master getMaster() {
        return master;
    }

}
*/