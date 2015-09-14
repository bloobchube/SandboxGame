package com.jayustech.sandbox.entity;

import com.jayustech.sandbox.Game;
import com.jayustech.sandbox.VectorF;
import com.jayustech.sandbox.render.Renderer;
import com.jayustech.sandbox.render.Sprite;
import com.jayustech.sandbox.render.Texture;

public abstract class Entity {
	
	public Sprite sprite;
	public VectorF pos;
	
	private int width, height;
	
	public Entity(VectorF pos, Texture texture, int width, int height){
		this.pos = pos;
		sprite = new Sprite(pos.toIntegerVector(), texture);
		
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick(Game game);
	
	public void updateSprite(){
		sprite.position = pos.toIntegerVector();
	}
	
	public void render(){
		Renderer.renderSprite(sprite, width, height);
	}

}
