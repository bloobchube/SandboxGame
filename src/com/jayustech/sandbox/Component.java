package com.jayustech.sandbox;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.jayustech.sandbox.render.Renderer;

public class Component extends Canvas implements Runnable {

	public static final int width = 320, height = 240, scale = 3;
	public static final int fpsCap = 80;
	
	public static Component instance;
	
	private Graphics g;
		
	private Thread thread;
	private boolean running = false;
		
	public Game game;
		
	private Component(){
		init();
		start();
	}
	
	private void init(){
		Dimension size = new Dimension(width*scale, height*scale);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		
		game = new Game();
		this.addKeyListener(game.input);
		
		JFrame frame = new JFrame("Sandbox Game");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		this.createBufferStrategy(2);
		BufferStrategy bs = this.getBufferStrategy();
		this.g = bs.getDrawGraphics();
	}
	
	public synchronized void start(){
		if(running) return;
		running = true;
	
		if(thread == null) thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(running){
			prepare();
			tick();
			render();
			cleanUp();
		}
	}
	
	private void prepare(){
		prepareRenderer();
	}
	
	private void prepareRenderer(){
		BufferStrategy bs = this.getBufferStrategy();
		this.g = bs.getDrawGraphics();
		super.paint(g);
		
		Renderer.prepare(g);
	}
	
	private void tick(){
		game.tick();	
	}
	
	private void render(){	
		game.render();
	}
	
	private void cleanUp(){
		BufferStrategy bs = this.getBufferStrategy();
		
		bs.show();
		g.dispose();
	}
	
	public static VectorI getCenter(){
		int x = (width*scale)/2;
		int y = (height*scale)/2;
		
		VectorI pos = new VectorI(x, y);
		
		return pos;
	}
	
	public static void main(String[] args){
		instance = new Component();
	}
	
}
