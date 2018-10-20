package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		DateTime dateTime = new DateTime(2018, 11, 07, 12, 12, 12);
		assertEquals(dateTime.toString(), "2018-11-07 12:12:12");
	}

	@Test
	public void testDateTimeString() {
		DateTime dateTime = new DateTime(2018, 11, 07, 12, 12, 12);
		DateTime compareDate = new DateTime("2018-11-07 12:12:12");
		assertEquals(dateTime.toString(), compareDate.toString());
	}

}
