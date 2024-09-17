package fr.sixczero.presence.screen;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class TitleScreen {
    public TitleScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("Hmm what can I do..")
                .setDetails("On main menu")
                .setBigImage("title", "Main menu")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
