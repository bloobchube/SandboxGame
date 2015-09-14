package com.jayustech.sandbox.world;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.jayustech.sandbox.Game;

public class World {
	
	public int width, height;
	
	private byte[][] ids;
	
	private World(byte[][] ids, int width, int height){
		this.ids = ids;
		
		this.width = width;
		this.height = height;
	}
	
	@SuppressWarnings("resource")
	public static World loadWorld(String name){
		Scanner scan;
		File file;
		
		try {
			file = new File("res/worlds/" + name + ".world");
			scan = new Scanner(file);
		} catch (Exception e) {
			throw new RuntimeException("Could not find world file!", e);
		}
		
		long lines = 0;
		try {
			lines = Game.getLineCount(file);
		} catch (Exception e) {
			try {
				throw new IOException("Could not find number of lines in world file!", e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println(lines);
				
		int width = 0, height = 0;
		
		ArrayList<IDMap> idMaps = new ArrayList<IDMap>();
		
		for(int lnNum = 0; lnNum < lines; lnNum++){
			String ln = scan.nextLine();
			height++;
			
			for(int c = 0; c < ln.length(); c++){				
				int id = Character.getNumericValue(ln.charAt(c));
				IDMap idMap = new IDMap(id, c, lnNum);
				idMaps.add(idMap);
			}
			
			width = ln.length();
		}
		
		byte[][] ids = new byte[width][height];
		
		System.out.println(width);
		
		for(int i = 0; i < idMaps.size(); i++){
			IDMap idMap = idMaps.get(i);
			
			int x = idMap.x;
			int y = idMap.y;
			byte id = idMap.id;
			
			ids[x][y] = id;
		}
		
		World world = new World(ids, width, height);
		return world;
	}

	public byte getBlockType(int x, int y){
		return ids[x][y];
	}
	
}
