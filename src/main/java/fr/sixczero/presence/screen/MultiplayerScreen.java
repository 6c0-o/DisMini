package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class MultiplayerScreen {
    public MultiplayerScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("heheh")
                .setDetails("In multi")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
