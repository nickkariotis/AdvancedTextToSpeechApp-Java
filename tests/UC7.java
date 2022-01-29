package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import commands.*;

class UC7 {

	
	private StartRecording sr = new StartRecording();
	private ReplayManagerController rmc = ReplayManagerController.getInstance();
	private ReplayManager rm = rmc.getReplayManager();
	private OpenDocument op = new OpenDocument("Default");

	
	@Test
	void test() {
		boolean expected = true;
		sr.forTest();
		op.setReplayManager(rm);
		boolean got = rm.isRecording();
		assertEquals(expected,got);
	}

}
