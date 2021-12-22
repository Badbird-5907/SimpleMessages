package net.badbird5907.simplemessages.manager;

import lombok.Getter;
import net.badbird5907.simplemessages.player.SimplePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {
    @Getter
    private static final Map<UUID, SimplePlayer> map = new HashMap<UUID, SimplePlayer>();

    public static SimplePlayer getData(UUID uuid){
        return map.get(uuid);
    }
    public static void join(Player player){
        map.put(player.getUniqueId(), new SimplePlayer(player.getUniqueId()));
    }
    public static void leave(Player player){
        map.remove(player.getUniqueId());
    }
}
