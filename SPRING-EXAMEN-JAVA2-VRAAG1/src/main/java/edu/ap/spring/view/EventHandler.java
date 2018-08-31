package edu.ap.spring.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Quote;
import edu.ap.spring.jpa.QuoteRepository;
import edu.ap.spring.model.TextReader;

@Service
public class EventHandler {
	
	private UI ui;
	private TextReader textReader;
	private QuoteRepository repository;
	
	@Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }
    
    @Autowired
    public void setTextReader(TextReader textReader) {
    		this.textReader = textReader;
    }
    
    @Autowired
    public void setQuoteRepository(QuoteRepository repository) {
    	this.repository = repository;
    }
    
    public void whenSaveButtonClicked(ActionEvent actionEvent) {
    	try {
    		textReader.saveQuotesToDb();
    		
    		ui.getSaveSuccessLabel().setText("Save to database succesful!");
    	} catch(Exception ex) {
    		ui.getSaveSuccessLabel().setText(ex.toString());
    	}
    }
    
    public void whenListButtonClicked(ActionEvent actionEvent) {
    	DefaultListModel listModel = new DefaultListModel();
    	List<Quote> allQuotes = repository.findAll();
    	
    	for(Quote quote: allQuotes) {
    		listModel.addElement(quote.getQuote());
    	}
    	
    	JList newList = new JList(listModel);
    	newList.setLayoutOrientation(JList.VERTICAL);
    	newList.setVisibleRowCount(-1);
	   
	    JScrollPane listScroller = new JScrollPane(newList);
	    listScroller.setPreferredSize(new Dimension(250, 80));
    	ui.getListPanel().add(listScroller);
    }
    
    public void whenSearchButtonClicked(ActionEvent actionEvent) {
    	DefaultListModel listModel = new DefaultListModel();
    	List<Quote> allQuotes = repository.findAll();
    	String searchWord = ui.getSearchField().getText();
    	
    	if(searchWord != "") {
    		for(Quote quote: allQuotes) {
        		if(quote.getQuote().contains(searchWord)){
        			listModel.addElement(quote.getQuote());
        		}
        	}
    		
    		JList newList = new JList(listModel);
        	newList.setLayoutOrientation(JList.VERTICAL);
        	newList.setVisibleRowCount(-1);
    	   
    	    JScrollPane listScroller = new JScrollPane(newList);
    	    listScroller.setPreferredSize(new Dimension(250, 80));
        	ui.getSearchPanel().add(listScroller);
    		
    	} else {
    		
    	}
 	
    }
    
}
