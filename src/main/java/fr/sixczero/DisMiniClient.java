package fr.sixczero;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class DisMiniClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("dismini");
    private static final String CLIENT_ID = "1285192441351245885";

    @Override
    public void onInitializeClient() {
        DiscordRPC.discordInitialize(CLIENT_ID, createEventHandlers(), true);

        final int[] test = {1};

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateDiscordPresence(String.valueOf(test[0]));
                MinecraftClient.getInstance().getToastManager().add(new CustomToast(
                        Text.literal("DisMini"),
                        Text.literal("Initialized " + test[0]),
                        Identifier.of("dismini", "textures/dis.png"),
                        6000,
                        0xff7289da
                )); // Future "EasyLib" to-do Custom Toast
                test[0]++;
            }
        }, 10000, 10000);

        new Thread(() -> {
            while (true) {
                DiscordRPC.discordRunCallbacks();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LOGGER.error("Error in Discord RPC thread", e);
                }
            }
        }).start();
    }

    private void updateDiscordPresence(String oui) {
        DiscordRichPresence presence = new DiscordRichPresence.Builder("Playing My Mod")
                .setDetails("Playing on my server%s".formatted(oui))
                .setBigImage("sun", "Overworld Sun")
                .build();

        DiscordRPC.discordUpdatePresence(presence);
    }

    private DiscordEventHandlers createEventHandlers() {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = user -> LOGGER.info("DisMini is ready, user: " + user.username);
        handlers.disconnected = (code, message) -> LOGGER.warn("Disconnected from Discord, code: " + code + ", message: " + message);
        handlers.errored = (code, message) -> LOGGER.error("Error with Discord RPC, code: " + code + ", message: " + message);
        return handlers;
    }
}
