package com.seccanj.paroliamo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Letters {

	private static final String LETTERS_CSV_FILE_PATH = "./italian-letters-frequency.csv";

	private List<Letter> letters = new ArrayList<>();
	
	public Letters() {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(LETTERS_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
            	Letter l = new Letter();
            	l.letter = nextRecord[0].toLowerCase();
            	l.frequency = Math.round(Float.valueOf(nextRecord[1])*100);

           		letters.add(l);
            }

        } catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String pickRandomLetter() {
		
		int n = (int)Math.round(Math.random()*10000);
		
		int cursor = 0;
		for (int i=0; i<letters.size(); i++) {
			Letter l = letters.get(i);
			
			if (cursor <= n && cursor + l.frequency > n) {
				return l.letter;
			}
			
			cursor += l.frequency;
		}

		// Should never get here
		return letters.get(0).letter;
	}
	
	
}
