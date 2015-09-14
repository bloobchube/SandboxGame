package com.jayustech.sandbox;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputHandler implements KeyListener {
	
	private ArrayList<Integer> keyCodes = new ArrayList<Integer>();
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyCodes.add((Integer) e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyCodes.remove((Integer) e.getKeyCode());
	}
	
	public boolean isKeyDown(int keyCode){
		return keyCodes.contains(keyCode);
	}
	
	public boolean isKeyUp(int keyCode){
		return !keyCodes.contains(keyCode);
	}

}
