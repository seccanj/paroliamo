package com.seccanj.paroliamo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paroliamo {
		
	public static void main(String[] args) {
		
		Dictionary dictionary = new Dictionary();
		
		Letters letters = new Letters();
		
		List<String> game = new ArrayList<>();

		for (int i=0; i<12; i++) {
			String l = letters.pickRandomLetter();
			game.add(l);
			System.out.print(l.toUpperCase() + " ");
		}
		
		System.out.println("\n\nPremi Invio per vedere le parole più lunghe trovate...");
		
		new Scanner(System.in).nextLine();
		   
		dictionary.findLongestWords(game);
	}
	
}
