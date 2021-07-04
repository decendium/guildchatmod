package me.mjnt.colormod.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.config.Configuration;

import me.mjnt.colormod.ConfigHandler;

import java.io.File;
import java.util.Arrays;

public class SetColorCommand extends CommandBase {

    public static Configuration config;
    private final static String file = "config/colormod.cfg";

    public static void init() {
        config = new Configuration(new File(file));
        try {
            config.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static String getString(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if (config.getCategory(category).containsKey(key)) {
                return config.get(category, key, "").getString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            config.save();
        }
        return "";
    }

    public static boolean hasKey(String category, String key) {
        config = new Configuration(new File(file));
        try {
            config.load();
            if (!config.hasCategory(category)) return false;
            return config.getCategory(category).containsKey(key);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            config.save();
        }
        return false;
    }

    public static void writeStringConfig(String category, String key, String value) {
        config = new Configuration(new File(file));
        try {
            config.load();
            String set = config.get(category, key, value).getString();
            config.getCategory(category).get(key).set(value);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            config.save();
        }
    }

    public static String initString(String category, String key, String defaultValue) {
        if (!hasKey(category, key)) {
            writeStringConfig(category, key, defaultValue);
            return defaultValue;
        } else {
            return getString(category, key);
        }
    }

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
        String userColor = Arrays.toString(params).replace(",", "").replace("[", "").replace("]", "").trim();
        try {
            ConfigHandler.writeStringConfig("commands", "color", userColor);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA+"Your color code has been set to " + userColor + "!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
