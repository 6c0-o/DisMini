package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class AdvancementsScreen {
    public AdvancementsScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("heheh")
                .setDetails("In dqsdqs")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
