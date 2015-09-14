package com.jayustech.sandbox.world.block;

import java.awt.Rectangle;

import com.jayustech.sandbox.Component;
import com.jayustech.sandbox.Game;
import com.jayustech.sandbox.VectorF;
import com.jayustech.sandbox.VectorI;
import com.jayustech.sandbox.render.Renderer;
import com.jayustech.sandbox.render.Texture;

public class Block {
	
public static Block[] blocks = new Block[2];
	
	public static Block dirt = new DirtBlock(0);
	public static Block grass = new GrassBlock(1);
	
	public final byte id;
	
	public Texture texture;
		
	public Block(Texture texture, int id) {
		this.texture = texture;
		
		this.id = (byte) id;
		if (blocks[id] != null) throw new RuntimeException("Block already instantiated!");
		blocks[id] = this;		
	}
	
	public void render(VectorF position){
		VectorI pos = position.toIntegerVector();
		
		Renderer.renderSprite(texture, pos, 8, 8);
	}
	
	public void render(VectorI position){		
		Renderer.renderSprite(texture, position, 8, 8);
	}
	
	public void tick(Game game, VectorF position) {
		
	}
	
	public Rectangle getCollider(int x, int y){
		return new Rectangle(x, y, 8*Component.scale, 8*Component.scale);
	}

}
