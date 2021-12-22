package net.badbird5907.simplemessages.core.player;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerManager {
    private static Map<UUID,SimplePlayer> playerMap = new ConcurrentHashMap<>();

    public static SimplePlayer getPlayer(UUID uuid){
        return playerMap.get(uuid);
    }
    public static SimplePlayer getPlayer(String name){
        return playerMap.values().stream().filter(player -> player.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static void addPlayer(SimplePlayer player){
        playerMap.put(player.getUUID(),player);
    }

    public static void removePlayer(UUID uuid){
        playerMap.remove(uuid);
    }
}
