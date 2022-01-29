package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.*;
import model.Document;
import java.util.*;
import java.awt.event.ActionEvent;

class UC8 {

	private StartRecording sr = new StartRecording();
	private ReplayManagerController rmc = ReplayManagerController.getInstance();
	private ReplayManager rm = rmc.getReplayManager();
	private DocumentController dc = DocumentController.getInstance();
	private Document doc = dc.getDocument();
	private PlaySequence ps = new PlaySequence();
	private FakeDocumentToSpeech fakeDTS = new FakeDocumentToSpeech();
	private StopRecording str = new StopRecording();
	@Test
	void test() {
		ArrayList<String> content = new ArrayList<String>();
		sr.forTest();
		content.add("This is a test");
		doc.setContents(content);
		String expected = String.join(" ",content);
		fakeDTS.actionPerformed(new ActionEvent(new Object(), 0, "Play Contents"));
		String got = doc.getFake().getPlayedContents();
		str.forTest();
		rm.printSequence();
		ps.forTest();
		assertEquals(expected,got);
	}

}
