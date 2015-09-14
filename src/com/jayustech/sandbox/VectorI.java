package com.jayustech.sandbox;

public class VectorI {
	
	private int x, y;
	
	public VectorI(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public VectorI add(VectorI v){
		x+=v.x;
		y+=v.y;
		
		return this;
	}
	
	public VectorI sub(VectorI v){
		x-=v.x;
		y-=v.y;
		
		return this;
	}
	
	public VectorI mult(VectorI v){
		x*=v.x;
		y*=v.y;
		
		return this;
	}
	
	public VectorI div(VectorI v){
		x/=v.x;
		y/=v.y;
		
		return this;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public VectorF toFloatVector(){
		float x = (float) this.x;
		float y = (float) this.y;
		
		VectorF vec = new VectorF(x, y);
		
		return vec;
	}

}
