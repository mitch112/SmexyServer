package org.dementhium.model.player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class ShopManager {

    public static int currency;
	public HashMap<Integer, Shop> shops = new HashMap<Integer, Shop>();

    public void load() {
        try {
            RandomAccessFile shopFile = new RandomAccessFile("data/shops.bin", "r");
            int shopsAmt = shopFile.readShort();
            for (int shopId = 0; shopId < shopsAmt; shopId++) {
                int npcId = shopFile.readShort();
                int[] items = new int[shopFile.readByte()];
		int currency = 995;
		if (npcId == 9711) {
			currency = 11180;
		}
		if (npcId == 650) {
			currency = 14639;
		}
		if (npcId == 105) {
			currency = 19864;
		}
		if (npcId == 2620) {
			currency = 6529;
		}
		if (npcId == 1282) {
			currency = 5020;
		}
                int[] amounts = new int[items.length];
                boolean isGeneral = shopFile.read() == 1;
                for (int itemData = 0; itemData < items.length; itemData++) {
                    items[itemData] = shopFile.readShort();
                    amounts[itemData] = shopFile.readInt();
                }
                shops.put(npcId, new Shop(npcId, currency, isGeneral, items, amounts, true));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Loaded " + shops.size() + " Shops");
    }

    public boolean openShop(Player player, int id) {
    	if(id == 650) {
    		if(player.getDonor() < 1) {
    			player.sendMessage("You must be a donator to open this shop");
    			return false;
    		}
    	}
        if (shops.get(id) != null) {
            player.setAttribute("shopId", id);
            shops.get(id).open(player);
            shops.get(id).addPlayer(player);
            return true;
        } else {
            return false;
        }
    }

    public Shop getShop(int id) {
        return shops.get(id);
    }


}