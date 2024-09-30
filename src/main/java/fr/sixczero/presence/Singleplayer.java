package fr.sixczero.presence;

import fr.sixczero.DisMiniClient;
import fr.sixczero.util.timeUtils;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.World;

public class Singleplayer {
    public Singleplayer() {
        MinecraftClient client = MinecraftClient.getInstance();

        DiscordRichPresence.Builder presenceBuilder = new DiscordRichPresence.Builder("qsdqsdqs")
                .setDetails("I'm playing");
            if (client.player.getWorld().getRegistryKey() == World.OVERWORLD) {
                switch (timeUtils.getTimeOfDay(client.player.getWorld().getTimeOfDay())) {
                    case MORNING -> presenceBuilder.setBigImage("morning", "Exploring the Overworld | Morning");
                    case DAY -> presenceBuilder.setBigImage("day", "Exploring the Overworld | Day");
                    case EVENING -> presenceBuilder.setBigImage("evening", "Exploring the Overworld | Evening");
                    case NIGHT -> presenceBuilder.setBigImage("night", "Exploring the Overworld | Night");
                }
            }

        DiscordRichPresence presence = presenceBuilder.build();

        DisMiniClient.updateRichPresence(presence);
    }
}
