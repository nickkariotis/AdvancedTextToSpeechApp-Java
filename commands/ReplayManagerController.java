package commands;

public class ReplayManagerController {

	protected ReplayManager rm;
	private static ReplayManagerController rmc;
	
	private ReplayManagerController()
	{
		rm = new ReplayManager();
	}
	
	public static ReplayManagerController getInstance()
	{
		if(rmc == null)
		{
			rmc = new ReplayManagerController();
		}
		return rmc;
	}
	
	public ReplayManager getReplayManager()
	{
		return rm;
	}
	
	
}
