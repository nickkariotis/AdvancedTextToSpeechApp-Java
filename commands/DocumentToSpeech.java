package commands;

import model.Document;
import view.TextToSpeechEditorView;
import view.ViewHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DocumentToSpeech implements ActionListener{
	
	private String choice;
	
	public DocumentToSpeech(String library,String choice)
	{
		this.choice = choice;
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
	
	public void actionPerformed(ActionEvent event)
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		if(choice.equals("Convert to Speech"))
		{
			DocumentController dc = DocumentController.getInstance();
			Document myDoc = dc.getDocument();
			ViewHandler vh = ViewHandler.getHandler();
			TextToSpeechEditorView view = vh.getView();
			int volume = view.getVolume();
			myDoc.setVolume(volume);
			int rate = view.getRate();
			myDoc.setRate(rate);
			int pitch = view.getPitch();
			myDoc.setPitch(pitch);
			myDoc.playContents();
			setReplayManager(rm);
		}
		else if(choice.equals("Play Lines"))
		{
			DocumentController dc = DocumentController.getInstance();
			Document myDoc = dc.getDocument();
			ViewHandler vh = ViewHandler.getHandler();
			TextToSpeechEditorView view = vh.getView();
			int text1 = view.getLineX();
			int text2 = view.getLineY();
			int volume = view.getVolume();
			myDoc.setVolume(volume);
			int rate = view.getRate();
			myDoc.setRate(rate);
			int pitch = view.getPitch();
			myDoc.setPitch(pitch);
			myDoc.playLines(text1,text2);
			setReplayManager(rm);
		}
		else if(choice.equals("Tune Audio")) {
			DocumentController dc = DocumentController.getInstance();
			Document myDoc = dc.getDocument();
			ViewHandler vh = ViewHandler.getHandler();
			TextToSpeechEditorView view = vh.getView();
	
			switch (event.getActionCommand()) {
				case("volume"): 
					int volume = view.getVolume();
					myDoc.setVolume(volume);
					break;
				case("rate"):
					int rate = view.getRate();
					myDoc.setRate(rate);
					break;
				case("pitch"):
					int pitch = view.getPitch();
					myDoc.setPitch(pitch);
					break;
			}
		}
		else 
		{
			System.out.println("not valid input");
		}
	}
}
