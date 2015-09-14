package com.jayustech.sandbox.render;

import java.awt.Graphics;

import com.jayustech.sandbox.Component;
import com.jayustech.sandbox.VectorI;

public class Renderer {
	
	private static Graphics g;
	
	public static void prepare(Graphics g){
		Renderer.g = g;
	}
	
	public static void renderSprite(Sprite sprite, int width, int height){
		g.drawImage(sprite.texture.img, sprite.position.getX(), sprite.position.getY(), width*Component.scale, height*Component.scale, null);
	}
	
	public static void renderSprite(Texture texture, VectorI pos, int width, int height){
		g.drawImage(texture.img, pos.getX(), pos.getY(), width*Component.scale, height*Component.scale, null);
	}
	
}
