package net.badbird5907.simplemessages.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class SimplePlayer {
    private final UUID uuid;
    private String name;
    private UUID lastMessaged = null;
}