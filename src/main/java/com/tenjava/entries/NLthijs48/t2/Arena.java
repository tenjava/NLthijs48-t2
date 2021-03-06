package com.tenjava.entries.NLthijs48.t2;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class Arena {

	private ArrayList<Level> levels = null;
	private boolean editMode = false;
	private GravityReversal plugin;
	
	public Arena(GravityReversal plugin) {
		levels = new ArrayList<Level>();
		this.plugin = plugin;
	}
	
	public Arena(GravityReversal plugin, ConfigurationSection settings) {
		levels = new ArrayList<Level>();
		this.plugin = plugin;
		if(settings.isSet("levels")) {
			ConfigurationSection levels = settings.getConfigurationSection("levels");
			for(String level : levels.getKeys(false)) {
				this.levels.add(new Level(levels.getConfigurationSection(level)));
			}
		}		
		// TODO save all settings
	}

	public void addLevel(Level level) {
		levels.add(level);
	}
	
	public List<Level> getLevels() {
		return levels;
	}
	
	public Level getLevel(String name) {
		for(Level level : getLevels()) {
			if(level.getName().equalsIgnoreCase(name)) {
				return level;
			}
		}
		return null;
	}
	
	public boolean isReady() {
		boolean result = true;
		// TODO check if a level exists
		return result;
	}
	
	
	
	
	
	
	public ConfigurationSection toConfigSection() {
		ConfigurationSection result = new YamlConfiguration();
		for(Level level : levels) {
			result.set("levels." + level.getName().toLowerCase(), level.toConfigSection());
		}		
		return result;
	}

}























