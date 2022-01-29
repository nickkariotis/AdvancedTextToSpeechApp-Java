package commands;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.TextToSpeechEditorView;
import view.ViewHandler;

public class EditDocument implements ActionListener{
	
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
		ViewHandler vh = ViewHandler.getHandler();
		TextToSpeechEditorView view = vh.getView();
		JTextArea editable = view.getTextArea();
		editable.setEditable(true);
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		setReplayManager(rm);
	}
}
