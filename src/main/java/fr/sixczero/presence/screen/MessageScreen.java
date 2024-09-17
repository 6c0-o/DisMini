package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class MessageScreen {
    public MessageScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("heheh")
                .setDetails("Initialization")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
