package edu.ap.spring.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;

@Component
public class TextReader {
	
	private QuoteRepository repository;
	
	@Autowired
	public void setQuoteRepository(QuoteRepository repository) {
		this.repository = repository;
	}
	
	public void saveQuotesToDb() {
		try {
			File file = new File("oscar_wilde.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			try {
				while ((line = bufferedReader.readLine()) != null)
				{
					if(line.length() != 0) {
						 System.out.println(line + " x");
						 Quote quote = new Quote(line);
						 repository.save(quote);
					}
				}	
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
