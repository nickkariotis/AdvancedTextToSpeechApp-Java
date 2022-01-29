package commands;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class StartRecording implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.startRecording();
	}
	
	public void forTest()
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.startRecording();
	}
}
