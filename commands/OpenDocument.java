package commands;


import model.Document;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.TextToSpeechEditorView;//tha to allaksw
import view.ViewHandler;

public class OpenDocument implements ActionListener{
	
	private String encoding;
	private String path;
	
	public OpenDocument(String encoding)
	{
		this.encoding = encoding;
	}
	
	public String getPath()
	{
		return path;
	}
	
	
	public void setDocument(Document d)
	{
		JFileChooser fileChooser = new JFileChooser("C:");
		int i = fileChooser.showOpenDialog(null);    
		if(i==JFileChooser.APPROVE_OPTION)
		{    

			path = fileChooser.getSelectedFile().getAbsolutePath();
		}
		d.setPath(path);
		d.setEncoding(encoding);
	}
	
	public void setReplayManager(ReplayManager rm)
	{
	
		boolean bool = rm.getBoolean();
		if(bool == true)
		{
			rm.addCommand(this);
		}
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		DocumentController dc = DocumentController.getInstance(); //to ekana me instance
		Document myDoc = dc.getDocument();
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		setReplayManager(rm);
		setDocument(myDoc);
		myDoc.open();
		ViewHandler vh = ViewHandler.getHandler();
		TextToSpeechEditorView view = vh.getView();
		view.setTextArea(myDoc.getContents());
	}
	
	
}
