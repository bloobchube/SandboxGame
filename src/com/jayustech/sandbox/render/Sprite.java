package com.jayustech.sandbox.render;

import com.jayustech.sandbox.VectorI;

public class Sprite {
	
	public VectorI position;
	public Texture texture;
	
	public Sprite(VectorI position, Texture texture){
		this.position = position;
		this.texture = texture;
	}

}
