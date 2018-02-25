package com.seccanj.paroliamo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Dizionario {
	
	private static final String SAMPLE_CSV_FILE_PATH = "./dizionario.csv";

	private List<Parola> parole = new ArrayList<>();
	
	public Dizionario() {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
            	Parola p = new Parola();
            	p.parola = nextRecord[0];
            	p.frequenza = Integer.parseInt(nextRecord[1]);
            	p.lunghezza = Integer.parseInt(nextRecord[2]);
            	
                //System.out.println(p.parola + "   ");
                
                parole.add(p);
            }

    		Collections.sort(parole, new Comparator<Parola>() {

    			@Override
    			public int compare(Parola p1, Parola p2) {
    				return p2.lunghezza - p1.lunghezza;
    			}
    			
    		});
            
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void findLongestWord(List<String> letters) {
		int maxLen = 0;

		System.out.println("Parole più lunghe:");
		
		for (int i=0; i<parole.size(); i++) {
			Parola p = parole.get(i);
			
			if (p.lunghezza < maxLen - 2) {
				break;
			}
			
			if (possible(letters, p)) {
				if (p.lunghezza > maxLen) {
					maxLen = p.lunghezza;
				}
				
				System.out.println(p.parola);
			}
		}
	}

	private boolean possible(List<String> letters, Parola parola) {
		String p = parola.parola;
		List<String> l = new ArrayList<String>(letters);
		
		for (int i=0; i<p.length(); i++) {
			if (l.contains(""+p.charAt(i))) {
				l.remove(""+p.charAt(i));
			} else {
				return false;
			}
		}
		
		return true;
	}
}
