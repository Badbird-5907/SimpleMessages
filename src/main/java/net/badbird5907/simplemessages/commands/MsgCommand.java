package net.badbird5907.simplemessages.commands;

import net.badbird5907.blib.command.BaseCommand;
import net.badbird5907.blib.command.Command;
import net.badbird5907.blib.command.CommandResult;
import net.badbird5907.blib.command.Sender;
import net.badbird5907.blib.util.CC;
import net.badbird5907.blib.util.Logger;
import net.badbird5907.blib.utils.StringUtils;
import net.badbird5907.simplemessages.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MsgCommand extends BaseCommand {
    @Command(name = "msg",aliases = {"w","tell","t","m"},usage = "&cUsage: /msg <player> [message]")
    public CommandResult execute(Sender sender, String[] args) {
        if (!(args.length > 0)){
            return CommandResult.INVALID_ARGS;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null && !args[0].equalsIgnoreCase("console")){
            return CommandResult.INVALID_PLAYER;
        }
        if (args.length == 1){
            return CommandResult.INVALID_ARGS;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            i++;
            if (i != 1){
                sb.append(" ").append(arg);
            }
        }
        if (sender.getCommandSender() instanceof Player){ //sender is player
            if (target != null) //target is not console
                PlayerManager.getData(sender.getPlayer().getUniqueId()).setLastMessaged(target.getUniqueId()); //set sender last msg to target
            else PlayerManager.getData(sender.getPlayer().getUniqueId()).setLastMessaged(new UUID(0,0)); //set sender last message to console
        }else{ //sender is console
            PlayerManager.getData(target.getUniqueId()).setLastMessaged(new UUID(0,0)); //set last message to console
        }
        String toFormat = CC.PINK + "From " + CC.AQUA + "%1:" + CC.WHITE + "%2";
        String fromFormat = CC.PINK + "To " + CC.AQUA + "%1:" + CC.WHITE + "%2";
        if (target == null){
            Logger.info(toFormat,sender.getName(),sb);
            sender.sendMessage(StringUtils.replacePlaceholders(fromFormat,"CONSOLE",sb.toString()));

        }else{
            target.sendMessage(StringUtils.replacePlaceholders(toFormat,sender.getName(),sb.toString()));
            target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1f,1f);

            sender.sendMessage(StringUtils.replacePlaceholders(fromFormat,target.getName(),sb.toString()));
        }
        return CommandResult.SUCCESS;
    }
}
