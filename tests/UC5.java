package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;
import java.util.*;


class UC5 {

	private FakeTTSFacade fake = new FakeTTSFacade();
	private Document doc = new Document();
	
	@Test
	void test() {
		ArrayList<String> content = new ArrayList<String>();
		content.add("This is a test");
		doc.setContents(content);
		String content1 = String.join("",doc.getContents());
		fake.playFTTS(content1, 100, 200, 200);
		String playedContents = fake.getPlayedContents();
		String expected = String.join("", content1);
		assertEquals(expected,playedContents);
	}

}
