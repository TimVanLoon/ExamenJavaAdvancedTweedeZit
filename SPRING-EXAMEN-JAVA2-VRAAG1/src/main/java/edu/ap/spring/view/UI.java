package edu.ap.spring.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;
	
	private JFrame jFrame;
	private JPanel savePanel, listPanel; 
	private JLabel saveLabel, saveSuccessLabel;
	private JButton btnSave;
	private JTabbedPane tabbedPane;
	private JList jList;
	
	public UI() {}
	
	public void setupUI() {
		jFrame = new JFrame("Quotes");
		jFrame.setLayout(new FlowLayout());
		
		tabbedPane = new JTabbedPane();
		
		savePanel = new JPanel();
		savePanel.setLayout(new GridLayout(0, 2));
	    
	    saveLabel = new JLabel("Save quotes to database: ");
	    
	    btnSave = new JButton();
	    btnSave.setText("Save");
	    btnSave.addActionListener(eventHandler::whenSaveButtonClicked);
	    
	    saveSuccessLabel = new JLabel("");
	    
	    savePanel.add(saveLabel);
	    savePanel.add(btnSave);
	    savePanel.add(saveSuccessLabel);
	    savePanel.setPreferredSize(new Dimension(410, 50));
		
		tabbedPane.addTab("Save", savePanel);
		
		jFrame.add(tabbedPane);
		
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0, 1));
        
		jFrame.setSize(600, 600);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public JLabel getSaveLabel() {
		return saveLabel;
	}

	public void setSaveLabel(JLabel saveLabel) {
		this.saveLabel = saveLabel;
	}

	public JLabel getSaveSuccessLabel() {
		return saveSuccessLabel;
	}

	public void setSaveSuccessLabel(JLabel saveSuccessLabel) {
		this.saveSuccessLabel = saveSuccessLabel;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
