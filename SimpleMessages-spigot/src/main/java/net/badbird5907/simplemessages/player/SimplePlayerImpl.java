package net.badbird5907.simplemessages.player;

import lombok.RequiredArgsConstructor;
import net.badbird5907.simplemessages.core.player.SimplePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

@RequiredArgsConstructor
public class SimplePlayerImpl implements SimplePlayer {
    private final Player base;

    @Override
    public void sendMessage(String message) {
        base.sendMessage(message);
    }

    @Override
    public String getName() {
        return base.getDisplayName();
    }

    @Override
    public UUID getUUID() {
        return base.getUniqueId();
    }
}
