package fr.sixczero.util;

import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.Objects;

public class presencesEqual {
    public static boolean arePresencesEqual(DiscordRichPresence a, DiscordRichPresence b) {
        return  Objects.equals(a.state, b.state) &&
                Objects.equals(a.details, b.details) &&
                Objects.equals(a.largeImageKey, b.largeImageKey) &&
                Objects.equals(a.largeImageText, b.largeImageText) &&
                Objects.equals(a.smallImageKey, b.smallImageKey) &&
                Objects.equals(a.smallImageText, b.smallImageText) &&
                Objects.equals(a.partyId, b.partyId) &&
                a.partySize == b.partySize &&
                a.partyMax == b.partyMax &&
                Objects.equals(a.matchSecret, b.matchSecret) &&
                Objects.equals(a.joinSecret, b.joinSecret) &&
                Objects.equals(a.spectateSecret, b.spectateSecret) &&
                a.instance == b.instance;
    }

}
