package fr.sixczero.presence;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class Multiplayer {
    public Multiplayer() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("qsdqsdqs")
                .setDetails("Multi")
                .setBigImage("day", "OverworldDay")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
