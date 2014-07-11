package me.DJBiokinetix;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezeListener implements Listener{
	
	public static Freeze plugin;
	
	public FreezeListener (Freeze instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		if(plugin.freeze){
			Player player = e.getPlayer();
			player.teleport(player);
		}
	}
}
