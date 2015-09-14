package com.jayustech.sandbox.render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	public int width, height;
	
	protected BufferedImage img;
	
	public Texture(String path){
		try {
			this.img = ImageIO.read(new File("res/" + path + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Texture could not be loaded!", e);
		}
		
		this.width = img.getWidth();
		this.height = img.getHeight();
	}

}
