package me.mjnt.colormod.commands;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import me.mjnt.colormod.commands.*;

import java.io.BufferedReader;
import java.io.FileReader;

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


    //public String color = "&a";

    @Override
    public void processCommand(ICommandSender sender, String[] params) throws CommandException {
        // BufferedReader br = new BufferedReader(new FileReader("settings.json"));
        String color = SetColorCommand.getString("commands", "color");
        try {
            if (params != null && params.length > 0) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage("/gc " + color + String.join(" ", params));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
