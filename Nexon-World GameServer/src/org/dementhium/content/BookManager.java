package org.dementhium.content;

import org.dementhium.model.player.Player;
import org.dementhium.net.ActionSender;

/**
 * @author Lumby <lumbyjr@hotmail.com>
 */
public class BookManager {

    public static boolean proceedBook(Player player, int stage) {
		return false;
    }

    public static void processNextPage(Player player) {
        int stage;
        Object attribute = player.getAttribute("nextBookStage");
        stage = (Integer) attribute;
        if (stage == -1) {
            resetBook(player, false);
            return;
        }
        if (!proceedBook(player, stage)) {
            resetBook(player, false);
        }
    }

    public static void processPreviousPage(Player player) {
        int stage;
        Object attribute = player.getAttribute("previousBookStage");
        stage = (Integer) attribute;
        if (stage == -1) {
            resetBook(player, true);
            return;
        }
        if (!proceedBook(player, stage)) {
            resetBook(player, true);
        }
    }

    public static void sendBook(Player player, int previousBookStage,
                                int nextBookStage, boolean hideNext, boolean hideBack,
                                String title, String... content) {
        if (content.length == 0 || content.length > 22) {
            return;
        }
        ActionSender.sendString(player, 959, 5, title);
        int index = 30;
        for (String s : content) {
            ActionSender.sendString(player, 959, index, s);
            ActionSender.sendInterfaceConfig(player, 959, index, true);
            index++;
        }
        if (content.length < 22) {
            int blankContentNumber = 22 - content.length;
            int blankIndex = 30 + content.length;
            for (int i = 0; i < blankContentNumber; i++) {
                ActionSender.sendInterfaceConfig(player, 959, blankIndex + i,
                        false);
            }
        }
        ActionSender.sendString(player, 959, 53, "Next Page");
        ActionSender.sendString(player, 959, 52, "Previous Page");
        if (hideNext) {
            ActionSender.sendInterfaceConfig(player, 959, 29, false);
            ActionSender.sendInterfaceConfig(player, 959, 53, false);
        } else {
            ActionSender.sendInterfaceConfig(player, 959, 29, true);
            ActionSender.sendInterfaceConfig(player, 959, 53, true);
        }
        if (hideBack) {
            ActionSender.sendInterfaceConfig(player, 959, 28, false);
            ActionSender.sendInterfaceConfig(player, 959, 52, false);
        } else {
            ActionSender.sendInterfaceConfig(player, 959, 28, true);
            ActionSender.sendInterfaceConfig(player, 959, 52, true);
        }
        ActionSender.sendInterface(player, 959);
        player.removeAttribute("nextBookStage");
        player.removeAttribute("previousBookStage");
        player.setAttribute("nextBookStage", nextBookStage);
        player.setAttribute("previousBookStage", previousBookStage);
    }

    public static void resetBook(Player player, boolean resetPrevious) {
        if (!resetPrevious)
            player.removeAttribute("nextBookStage");
        else
            player.removeAttribute("previousBookStage");
    }
}