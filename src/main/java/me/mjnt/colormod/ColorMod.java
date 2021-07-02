package me.mjnt.colormod;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.client.ClientCommandHandler;

import java.awt.*;

@Mod(modid = ColorMod.MODID, name = ColorMod.NAME, version = ColorMod.VERSION)
public class ColorMod {

    public static final String MODID = "ColorMod";
    public static final String NAME = "Color Mod";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ClientCommandHandler.instance.registerCommand(new ColorCommand());
    }

    @EventHandler
    public void init(FMLServerStartingEvent event)
    {
        logger.info("initalise FMLServerStartingEvent :" + NAME);
    }
}