package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class ConnectScreen {
    public ConnectScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("heheh")
                .setDetails("conenection")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
