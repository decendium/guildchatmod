package me.mjnt.colormod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import me.mjnt.colormod.ConfigHandler;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ToggleColorCommand extends CommandBase {

    public static Configuration config;
    private final static String file = "config/colormod.cfg";

    public static Boolean chatToggled;
    // this might be useless but i am too scared to remove it

    @Override
    public String getCommandName() {
        return "tc";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "tc";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Boolean toggled = ConfigHandler.getBoolean("toggles", "prefix");
        if (toggled == true) {
            ConfigHandler.writeBooleanConfig("toggles", "prefix", false);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+ "Your color code prefix is now " +EnumChatFormatting.BOLD + EnumChatFormatting.AQUA + "OFF."));
            System.out.println("off");
        } else {
            ConfigHandler.writeBooleanConfig("toggles", "prefix", true);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+ "Your color code prefix is now " +EnumChatFormatting.BOLD + EnumChatFormatting.AQUA + "ON."));
            System.out.println("on");
        }
    }
}
