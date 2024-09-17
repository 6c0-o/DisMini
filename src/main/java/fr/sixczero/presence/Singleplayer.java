package fr.sixczero.presence;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class Singleplayer {
    public Singleplayer() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("qsdqsdqs")
                .setDetails("Im playing")
                .setBigImage("day", "OverworldDay")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
