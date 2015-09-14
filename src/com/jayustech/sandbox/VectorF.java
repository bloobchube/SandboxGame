package com.jayustech.sandbox;

public class VectorF {
	
	private float x, y;
	
	public VectorF(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public VectorF add(VectorF v){
		x+=v.x;
		y+=v.y;
		
		return this;
	}
	
	public VectorF sub(VectorF v){
		x-=v.x;
		y-=v.y;
		
		return this;
	}
	
	public VectorF mult(VectorF v){
		x*=v.x;
		y*=v.y;
		
		return this;
	}
	
	public VectorF div(VectorF v){
		x/=v.x;
		y/=v.y;
		
		return this;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public VectorI toIntegerVector(){
		int x = (int) this.x;
		int y = (int) this.y;
		
		VectorI vec = new VectorI(x, y);
		
		return vec;
	}

}
