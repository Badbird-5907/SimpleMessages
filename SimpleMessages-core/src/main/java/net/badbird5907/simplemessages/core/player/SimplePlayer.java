package net.badbird5907.simplemessages.core.player;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

public interface SimplePlayer {
    UUID lastMessagedTo = null;
    UUID lastMessagedFrom = null;
    default UUID getLastMessagedTo(){
        return lastMessagedTo;
    }
    default UUID getLastMessagedFrom(){
        return lastMessagedFrom;
    }
    void sendMessage(String message);
    String getName();
    UUID getUUID();
    default UUID getUniqueId(){
        return getUUID();
    }
}
