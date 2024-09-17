package fr.sixczero.presence.screen;


import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class UnknownScreen {
    public UnknownScreen() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("On an unknown screen")
                .setDetails("Do you love me ?")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
