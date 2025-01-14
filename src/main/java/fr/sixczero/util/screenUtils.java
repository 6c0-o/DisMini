package fr.sixczero.util;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.client.gui.screen.multiplayer.AddServerScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.DirectConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.LevelLoadingScreen;
import net.minecraft.client.realms.gui.screen.RealmsScreen;

public class screenUtils {

    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static screenType getCurrentScreenType() {
        Screen currentScreen = client.currentScreen;

        if (currentScreen == null) {
            return screenType.UNKNOWN_SCREEN;
        }

        if (currentScreen instanceof GameOptionsScreen) {
            return screenType.OPTIONS_SCREEN;
        }

        if (currentScreen instanceof RealmsScreen) {
            return screenType.REALMS_SCREEN;
        }

        switch (currentScreen) {
            case AddServerScreen addServerScreen -> { return screenType.MULTIPLAYER_SCREEN; }
            case AdvancementsScreen advancementsScreen -> { return screenType.ADVANCEMENTS_SCREEN; }
            case ConnectScreen connectScreen -> { return screenType.CONNECT_SCREEN; }
            case DeathScreen deathScreen -> { return screenType.DEATH_SCREEN; }
            case DirectConnectScreen directConnectScreen -> { return screenType.MULTIPLAYER_SCREEN; }
            case GameMenuScreen gameMenuScreen -> { return screenType.GAMEMENU_SCREEN; }
            case LevelLoadingScreen levelLoadingScreen -> { return screenType.LOADINGWORLD_SCREEN; }
            case DownloadingTerrainScreen downloadingTerrainScreen -> { return screenType.LOADINGWORLD_SCREEN; }
            case MessageScreen messageScreen -> { return screenType.MESSAGE_SCREEN; }
            case MultiplayerScreen multiplayerScreen -> { return screenType.MULTIPLAYER_SCREEN; }
            case OptionsScreen optionsScreen -> { return screenType.OPTIONS_SCREEN; }
            case StatsScreen statsScreen -> { return screenType.STATS_SCREEN; }
            default -> { return screenType.TITLE_SCREEN; }
        }
    }
}

