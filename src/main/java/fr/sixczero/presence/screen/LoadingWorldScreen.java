package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class LoadingWorldScreen {
    public LoadingWorldScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("hehehdqsdq")
                .setDetails("I see")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
