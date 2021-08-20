package me.mjnt.colormod.commands;

import me.mjnt.colormod.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import me.mjnt.colormod.commands.*;

public class ColorCommand extends CommandBase {

    public String getCommandName() {
        return "gc";
    }

    public String getCommandUsage(ICommandSender sender) {
        return "gc <message>";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] params) throws CommandException {
        // gets config from file
        String color = ConfigHandler.getString("commands", "color");
        Boolean toggle = ConfigHandler.getBoolean("toggles", "prefix");
        try {
            // if no params, do not send
            if (params != null && params.length > 0) {
                // if toggle on, send message with color code
                if (toggle == true) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/gc " + color + String.join(" ", params));
                } else {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/gc " + String.join(" ", params));
                }
            }
        } catch (Exception e) {
            // print errors 
            e.printStackTrace();
        }
    }
}
