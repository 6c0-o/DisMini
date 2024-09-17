package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class OptionsScreen {
    public OptionsScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("heheh")
                .setDetails("In options")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
