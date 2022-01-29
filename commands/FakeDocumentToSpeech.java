package commands;

import java.awt.event.ActionListener;

import model.Document;
import java.awt.event.ActionEvent;

public class FakeDocumentToSpeech implements ActionListener{

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
		DocumentController dc = DocumentController.getInstance();
		Document myDoc = dc.getDocument();
		myDoc.playFake();
		setReplayManager(rm);
	}
}
