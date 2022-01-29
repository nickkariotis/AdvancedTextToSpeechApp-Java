package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;


class UC6 {

	private FakeTTSFacade fake = new FakeTTSFacade();
	private Document doc = new Document();
	private int volume = 100;
	private int rate = 200;
	private int pitch = 200;
	
	@Test
	void test() {
		fake.setVolume(volume);
		fake.setRate(rate);
		fake.setPitch(pitch);
		doc.setVolume(volume);
		doc.setRate(rate);
		doc.setPitch(pitch);
		assertEquals(doc.getVolume(), fake.getVolume(), 0);
	    assertEquals(doc.getRate(), fake.getRate(), 0);
	    assertEquals(doc.getPitch(), fake.getPitch(), 0);
	}

}
