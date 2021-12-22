package net.badbird5907.simplemessages.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.badbird5907.blib.event.SimpleEvent;
import org.bukkit.entity.Player;

@Getter
@Setter
@AllArgsConstructor
public class PlayerMessageEvent extends SimpleEvent {
    private Player to,from;
    private String message;
}
