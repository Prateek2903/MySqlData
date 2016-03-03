package com.example.mysqldata;

public class GlobalVar {
	
	public static GlobalVar instance;
	
	private int myVar = 0;
	
	public int getMyVar(){
		return myVar;
	}
	
	public void setMyVar(int myVar){
		this.myVar = myVar;
	}
	
	static {
		instance = new GlobalVar();
	}
	
	private GlobalVar(){
		
	}
	
	public static GlobalVar getInstance(){
		return GlobalVar.instance;
	}
 
}