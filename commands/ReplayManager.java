package commands;

import java.util.*;
import java.awt.event.*;

public class ReplayManager {

	private ArrayList<ActionListener> sequence;
	private boolean recordingEnable = false; 
	
	public ReplayManager()
	{
		this.sequence = new ArrayList<ActionListener>();
	}
	
	public boolean getBoolean()
	{
		return this.recordingEnable;
	}
	
	public ArrayList<ActionListener> getAl()
	{
		return this.sequence;
	}
	
	public void addCommand(ActionListener newCommand)
	{
		sequence.add(newCommand);
	}
	
	public void replay(ActionEvent event)
	{
		for(ActionListener al:sequence)
		{
			al.actionPerformed(event);
		}
	}
	
	public void clear()
	{
		sequence.clear();
	}
	
	public void startRecording()
	{
		
		this.recordingEnable = true;
	}
	
	public void endRecording()
	{
		this.recordingEnable = false;
	}
	
	public boolean isRecording()
	{
		return recordingEnable;
	}
	
	public void printSequence() {
		int j =0;
		for (int i = 0; i < sequence.size(); i++) {
			j++;
			System.out.println(sequence.get(i).getClass().toString());
		}
		System.out.println(j);
	}
}
