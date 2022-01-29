package commands;

import java.awt.event.*;

public class PlaySequence implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent event)
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.replay(event);
	}
	
	public void forTest()
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.replay(new ActionEvent(new Object(), 0, "Play Sequence"));
	}
}
