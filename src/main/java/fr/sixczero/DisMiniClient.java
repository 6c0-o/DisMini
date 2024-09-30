package fr.sixczero;

import com.sun.jna.platform.win32.COM.Unknown;
import fr.sixczero.presence.Multiplayer;
import fr.sixczero.presence.Singleplayer;
import fr.sixczero.presence.screen.*;
import fr.sixczero.util.presencesEqual;
import fr.sixczero.util.screenUtils;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class DisMiniClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("dismini");
    private static final String CLIENT_ID = "1285192441351245885";
    private static DiscordRichPresence rich;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            Screen currentScreen = client.currentScreen;
            if (currentScreen != null) {
                LOGGER.info("Current screen: {}", currentScreen.getClass().getSimpleName());
            } else {
                //LOGGER.info("No screen is currently open.");
            }
        });

        DiscordRPC.discordInitialize(CLIENT_ID, createEventHandlers(), true);

        rich = new DiscordRichPresence.Builder("The mod just turned on !").setBigImage("dismini", "Initialization").build();
        DisMiniClient.updateRichPresence(rich);

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runUpdate();
            }
        }, 3000, 3000);

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

    private void runUpdate() {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.world != null || client.player != null) {
            try {
                switch (screenUtils.getCurrentScreenType()) {
                    case ADVANCEMENTS_SCREEN -> new AdvancementsScreen();
                    case DEATH_SCREEN -> new DeathScreen();
                    case GAMEMENU_SCREEN -> new GameMenuScreen();
                    case OPTIONS_SCREEN -> new OptionsScreen();
                    case STATS_SCREEN -> new StatsScreen();
                    default -> {
                        if (client.isInSingleplayer()) new Singleplayer();
                        else if (client.getCurrentServerEntry() != null) new Multiplayer();
                        else new Unknown();
                    }
                }
            } catch (Exception e) {
                LOGGER.error(String.valueOf(e));
            }
        } else {
            switch (screenUtils.getCurrentScreenType()) {
                case CONNECT_SCREEN -> new ConnectScreen();
                case GAMEMENU_SCREEN -> new GameMenuScreen();
                case LOADINGWORLD_SCREEN -> new LoadingWorldScreen();
                case MESSAGE_SCREEN -> new MessageScreen();
                case MULTIPLAYER_SCREEN -> new MultiplayerScreen();
                case OPTIONS_SCREEN -> new OptionsScreen();
                case UNKNOWN_SCREEN -> new UnknownScreen();
                default -> new TitleScreen();
            }
        }
    }

    public static void updateRichPresence(DiscordRichPresence presence) {
        if (rich == null || !presencesEqual.arePresencesEqual(rich, presence)) {
            rich = presence;
            LOGGER.warn("My states change");
            DiscordRPC.discordUpdatePresence(presence);
        }
    }

    private DiscordEventHandlers createEventHandlers() {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        handlers.ready = user -> LOGGER.info("DisMini is ready, user: " + user.username);
        handlers.disconnected = (code, message) -> LOGGER.warn("Disconnected from Discord, code: " + code + ", message: " + message);
        handlers.errored = (code, message) -> LOGGER.error("Error with Discord RPC, code: " + code + ", message: " + message);
        return handlers;
    }
}
