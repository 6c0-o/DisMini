package fr.sixczero.presence;

import fr.sixczero.DisMiniClient;
import net.arikia.dev.drpc.DiscordRichPresence;

public class Unknown {
    public Unknown() {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("heheh")
                .setDetails("IQS?./FHQSDKf")
                .setBigImage("unknown", "Unknown Screen")
                .build();

        DisMiniClient.updateRichPresence(presence);
    }
}
