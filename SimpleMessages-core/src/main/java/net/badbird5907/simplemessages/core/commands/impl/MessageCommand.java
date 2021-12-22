package net.badbird5907.simplemessages.core.commands.impl;

import net.badbird5907.simplemessages.core.commands.Command;
import net.badbird5907.simplemessages.core.commands.CommandResult;
import net.badbird5907.simplemessages.core.player.PlayerManager;
import net.badbird5907.simplemessages.core.player.SimplePlayer;

public class MessageCommand extends Command {
    public MessageCommand() {
        super("message", "Message a player", "<player> <message>", "simplemessages.message",new String[]{"m","msg","tell","w","whisper","t"});
    }

    @Override
    public CommandResult execute(SimplePlayer player, String[] args) {
        if (args.length < 2) {
            return CommandResult.INVALID_ARGS;
        }
        SimplePlayer target = PlayerManager.getPlayer(args[0]);
        if (target == null) {
            return CommandResult.PLAYER_NOT_FOUND;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String arg : args) {
            i++;
            sb.append(i == 1 ? "" : " " + arg);
        }
        //TODO finish this
        return CommandResult.SUCCESS;
    }
}
