package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.*;

class UC9 {
	
	private StartRecording sr = new StartRecording();
	private StopRecording er = new StopRecording();
	private ReplayManagerController rmc = ReplayManagerController.getInstance();
	private ReplayManager rm = rmc.getReplayManager();
	private OpenDocument op = new OpenDocument("Default");
	
	@Test
	void test() {
		boolean expected = false;
		sr.forTest();
		op.setReplayManager(rm);
		er.forTest();
		boolean got = rm.isRecording();
		assertEquals(expected,got);
	}

}
