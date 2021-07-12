package me.mjnt.colormod.commands;

import net.minecraft.client.Minecraft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import net.minecraftforge.common.config.Configuration;
import me.mjnt.colormod.ConfigHandler;

/*
credit mjnt B)
*/

public class SetColorCommand extends CommandBase {

    public static Configuration config;
    private final static String file = "config/colormod.cfg";

    @Override
    public String getCommandName() {
        return "setcolor";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "setcolor <colorcode>";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    public static String color;

    @Override
    public void processCommand(ICommandSender sender, String[] params) throws CommandException {
        String userColor = params[0].trim();
        try {
            ConfigHandler.writeStringConfig("commands", "color", userColor);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+"Your color code has been set to " + userColor + "!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
