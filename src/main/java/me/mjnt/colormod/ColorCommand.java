package me.mjnt.colormod;

import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

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

    @Override
    public void processCommand(ICommandSender sender, String[] params) throws CommandException {
        // code here
        if (params != null && params.length > 0) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/gc §1"+ String.join(" ", params));
        }
    }
}
