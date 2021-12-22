package net.badbird5907.simplemessages.commands;

import net.badbird5907.blib.command.BaseCommand;
import net.badbird5907.blib.command.Command;
import net.badbird5907.blib.command.CommandResult;
import net.badbird5907.blib.command.Sender;
import net.badbird5907.blib.util.CC;
import net.badbird5907.blib.util.Logger;
import net.badbird5907.blib.utils.StringUtils;
import net.badbird5907.simplemessages.manager.PlayerManager;
import net.badbird5907.simplemessages.player.SimplePlayer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand extends BaseCommand {
    @Command(name = "reply",aliases = {"r"},playerOnly = true,usage = "&cUsage: /reply <message>")
    public CommandResult execute(Sender sender, String[] args) {
        if (!(args.length > 0)){
            return CommandResult.INVALID_ARGS;
        }
        SimplePlayer senderData = PlayerManager.getData(sender.getPlayer().getUniqueId());
        if (senderData.getLastMessaged() == null){
            sender.sendMessage("You have not messaged anyone/been messaged!");
            return CommandResult.SUCCESS;
        }
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(" ").append(arg);
        }

        UUID target = senderData.getLastMessaged();
        String toFormat = CC.PINK + "From " + CC.AQUA + "%1:" + CC.WHITE + "%2";
        String fromFormat = CC.PINK + "To " + CC.AQUA + "%1:" + CC.WHITE + "%2";
        if (target.toString().equalsIgnoreCase(new UUID(0,0).toString())){
            Logger.info(toFormat,sender.getName(),sb.toString());
            sender.sendMessage(fromFormat,"CONSOLE",sb.toString());
        }else{
            Player targetPlayer = Bukkit.getPlayer(target);
            if (targetPlayer == null){
                sender.sendMessage(CC.RED + "The player you last messaged / were messaged by is offline!");
                return CommandResult.SUCCESS;
            }
            targetPlayer.sendMessage(StringUtils.replacePlaceholders(toFormat,sender.getName(),sb.toString()));
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1f,1f);
            senderData.setLastMessaged(target);
            PlayerManager.getData(target).setLastMessaged(sender.getPlayer().getUniqueId());
            sender.sendMessage(fromFormat,targetPlayer.getName(),sb.toString());
        }
        return CommandResult.SUCCESS;
    }
}
