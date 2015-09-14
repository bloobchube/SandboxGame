package com.jayustech.sandbox;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.jayustech.sandbox.world.World;
import com.jayustech.sandbox.world.block.Block;

public class Game {
	
	public int time = 0;
	
	public InputHandler input;
	
	private World testWorld;
		
	public Game(){
		input = new InputHandler();
		testWorld = World.loadWorld("testWorld");
	}
	
	public void tick(){
		time++;		
	}
	
	public void render(){
		for(int y = 0; y < testWorld.height; y++){
			for(int x = 0; x < testWorld.width; x++){
				byte id = testWorld.getBlockType(x, y);
				
				Block block = Block.blocks[id];
				
				VectorI position = new VectorI(x*8*Component.scale, y*8*Component.scale);
				
				block.render(position);
			}
		}
	}
	
	public static long getLineCount(File file) throws IOException {
	    try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file), 1024)) {
	        byte[] c = new byte[1024];
	        boolean empty = true,
	                lastEmpty = false;
	        long count = 0;
	        int read;
	        while ((read = is.read(c)) != -1) {
	            for (int i = 0; i < read; i++) {
	                if (c[i] == '\n') {
	                    count++;
	                    lastEmpty = true;
	                } else if (lastEmpty) {
	                    lastEmpty = false;
	                }
	            }
	            empty = false;
	        }

	        if (!empty) {
	            if (count == 0) {
	                count = 1;
	            } else if (!lastEmpty) {
	                count++;
	            }
	        }

	        return count;
	    }
	}

}
