package net.badbird5907.simplemessages.impl;

import lombok.RequiredArgsConstructor;
import net.badbird5907.simplemessages.core.player.SimplePlayer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

@RequiredArgsConstructor
public class SimplePlayerImpl implements SimplePlayer {
    private final ProxiedPlayer base;
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
