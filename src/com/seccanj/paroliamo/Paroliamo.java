package com.seccanj.paroliamo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paroliamo {
	
	static String vocali = "AAAEEEIIOOU";
	static String consonanti = "BCDFGHLMNPQRSTVZ";
	
	
	public static void main(String[] args) {
		
		Dizionario dizionario = new Dizionario();
		
		List<String> letters = new ArrayList<>();
		
		for (int i=0; i<4; i++) {
	
			int rand = (int)(Math.random()*11);
			
			String l = vocali.substring(rand, rand+1);
			letters.add(l);
			System.out.print(l + " ");
			
		}
		
		for (int i=0; i<8; i++) {
			
			int rand = (int)(Math.random()*16);

			String l = consonanti.substring(rand, rand+1);
			letters.add(l);
			System.out.print(l + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Premi Invio per vedere le parole più lunghe trovate...");
		
		new Scanner(System.in).nextLine();
		   
		dizionario.findLongestWord(letters);
		
	}
	
}
