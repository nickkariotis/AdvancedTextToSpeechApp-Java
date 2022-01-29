package commands;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClearSequence implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent event)
	{
		ReplayManagerController rmc = ReplayManagerController.getInstance();
		ReplayManager rm = rmc.getReplayManager();
		rm.clear();
	}
}
