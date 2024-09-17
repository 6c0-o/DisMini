package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class GameMenuScreen {
    public GameMenuScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("Let me take coffe")
                .setDetails("Pause")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
