package commands;

import java.awt.event.*;

public class StopRecording implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.endRecording();
	}
	
	public void forTest()
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.endRecording();
	}
}
