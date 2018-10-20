package se.ju.csi.oom.lab4;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime _dateTime = new DateTime(2018,10,8,16,0,0);
		_dateTime = TimeZoneTranslator.shiftTimeZone(_dateTime, TimeZone.GREENWICH_UTC.getOffset(), TimeZone.PAKISTAN.getOffset());
		assertEquals("2018-10-08 21:00:00", _dateTime.toString());
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0, 0);
		DateTime LectureEnd = new DateTime(2018, 8, 27, 9, 45, 0);
		Person kevin = new Person("Kevin King");
		Person daniel = new Person("Daniel Coconut");
		Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		
		
		
		Event firstOomLecture = new Event("OOM 2018 Lecture 1",
				LectureStart,
				LectureEnd,
				new HashSet<>(Arrays.asList(kevin, daniel)),
				HC218);
		firstOomLecture = TimeZoneTranslator.shiftEventTimeZone(firstOomLecture, TimeZone.GREENWICH_UTC, TimeZone.PAKISTAN);
		assertEquals("2018-08-27 13:00:00", firstOomLecture.getStartDate().toString());
		assertEquals("2018-08-27 14:45:00", firstOomLecture.getEndDate().toString());

	}
	
	
	@Test
	public void testShiftTimeZone2() {
		DateTime _dateTime = new DateTime(2016,1,1,6,0,0);
		_dateTime = TimeZoneTranslator.shiftTimeZone(_dateTime, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		assertEquals("2015-12-31 21:00:00", _dateTime.toString());
	}
	

}
