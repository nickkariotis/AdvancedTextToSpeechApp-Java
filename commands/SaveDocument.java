package commands;

import model.Document;
import view.TextToSpeechEditorView;
import view.ViewHandler;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;



public class SaveDocument implements ActionListener{
	
	private String encoding;
	
	public SaveDocument(String encoding)
	{
		this.encoding = encoding;
	}
	
	
	public void setReplayManager(ReplayManager rm)
	{
		boolean bool;
		bool = rm.isRecording();
		if(bool == true)
		{
			rm.addCommand(this);
		}
	}
	
	
	public void setDocument(Document d)
	{
		String path = "";
		JFileChooser fileChooser = new JFileChooser("C:");
		int i = fileChooser.showSaveDialog(null);    
		if(i==JFileChooser.APPROVE_OPTION)
		{    
			path = fileChooser.getSelectedFile().getAbsolutePath();
		}
		d.setPath(path);
		d.setEncoding(encoding);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		DocumentController dc = DocumentController.getInstance();
		Document myDoc = dc.getDocument();
		ViewHandler vh = ViewHandler.getHandler();
		TextToSpeechEditorView view = vh.getView();
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		setReplayManager(rm);
		setDocument(myDoc);
		String text = view.getText();
		String[] str = text.split("\n");
		ArrayList<String> toSave = new ArrayList<String>(Arrays.asList(str));
		myDoc.save(toSave);
		JTextArea editable = view.getTextArea();
		editable.setEditable(false);
	}
}
