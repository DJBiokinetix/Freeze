package me.DJBiokinetix;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Freeze plugin;
	public boolean freeze = false;
	public final FreezeListener fl = new FreezeListener(this);
	
	@Override
	public void onEnable(){
		this.logger.info("[Congelado] Activado!");
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(fl, this);
	}
	
	@Override
	public void onDisable(){
		this.logger.info("[Congelado] Desactivado!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("Congelar")){
			if(sender.hasPermission("Congelado.congelar"));
			if(args.length == 0){
				if(!freeze){
					freeze = true;
					sender.getServer().broadcastMessage(ChatColor.GREEN + "Estas congelado, no te puedes mover!");
				} else { 
					freeze = false;
					sender.getServer().broadcastMessage(ChatColor.RED + "Ya no estas congelado, puedes moverte ahora!");
				}
			}
		}
		return false;
	}
}
