package net.badbird5907.simplemessages.core.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.badbird5907.simplemessages.core.player.SimplePlayer;

@AllArgsConstructor
@Getter
public abstract class Command {
    private String name;
    private String description;
    private String usage;
    private String permission;
    private String[] aliases;
    public abstract CommandResult execute(SimplePlayer player,String[] args);
}
