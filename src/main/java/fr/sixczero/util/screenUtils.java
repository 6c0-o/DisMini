package fr.sixczero.util;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.*;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import net.minecraft.client.gui.screen.multiplayer.ConnectScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.LevelLoadingScreen;

public class screenUtils {

    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static screenType getCurrentScreenType() {

        switch (client.currentScreen) {
            case AdvancementsScreen advancementsScreen -> { return screenType.ADVANCEMENTS_SCREEN; }
            case ConnectScreen connectScreen -> { return screenType.CONNECT_SCREEN; }
            case DeathScreen deathScreen -> { return screenType.DEATH_SCREEN; }
            case GameMenuScreen gameMenuScreen -> { return screenType.GAMEMENU_SCREEN; }
            case LevelLoadingScreen levelLoadingScreen -> { return screenType.LOADINGWORLD_SCREEN; }
            case DownloadingTerrainScreen downloadingTerrainScreen -> { return screenType.LOADINGWORLD_SCREEN; }
            case MultiplayerScreen multiplayerScreen -> { return screenType.MULTIPLAYER_SCREEN; }
            case OptionsScreen optionsScreen -> { return screenType.OPTIONS_SCREEN; }
            case TitleScreen titleScreen -> { return screenType.TITLE_SCREEN; }
            default -> { return screenType.UNKNOWN_SCREEN; }
        }
    }
}

