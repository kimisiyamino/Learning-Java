package com.eleonoralion;

import java.util.Scanner;
import com.eleonoralion.Hash;
import com.eleonoralion.Diller;

public class TestDrive{
	public static void main(String[] args){
		System.out.println("^^^ === Start program: ");

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter weight of hash by Diller: ");
		double weight = scanner.nextDouble();

		Hash hash = new Hash(weight);
		Diller dilaRaionnii = new Diller(hash);

		System.out.println(dilaRaionnii.toString());
	}
}