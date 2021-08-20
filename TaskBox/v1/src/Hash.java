package com.eleonoralion;

class Hash{
	private double weight;

	public Hash(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	@Override
	public String toString(){
		return "Hash " + weight;
	}
}