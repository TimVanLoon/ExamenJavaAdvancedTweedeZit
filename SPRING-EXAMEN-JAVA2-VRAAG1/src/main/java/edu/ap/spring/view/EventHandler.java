package edu.ap.spring.view;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.model.TextReader;

@Service
public class EventHandler {
	
	private UI ui;
	private TextReader textReader;
	
	@Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }
    
    @Autowired
    public void setTextReader(TextReader textReader) {
    		this.textReader = textReader;
    }
    
    public void whenSaveButtonClicked(ActionEvent actionEvent) {
    	try {
    		textReader.saveQuotesToDb();
    		
    		ui.getSaveSuccessLabel().setText("Save to database succesful!");
    	} catch(Exception ex) {
    		ui.getSaveSuccessLabel().setText(ex.toString());
    	}
    }
    
}
