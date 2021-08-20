package com.eleonoralion;

class Diller{
	private Hash myHash;

	public Diller(Hash h){
		myHash = h;
	}

	@Override
	public String toString(){
		return "Diller + " + myHash.toString();
	}
}