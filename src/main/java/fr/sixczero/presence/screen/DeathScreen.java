package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class DeathScreen {
    public DeathScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("omg noob")
                .setDetails("Dead")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
