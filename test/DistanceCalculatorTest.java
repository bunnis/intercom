import static org.junit.Assert.*;
import customer.finding.DistanceCalculator;
import org.junit.Before;
import org.junit.Test;

public class DistanceCalculatorTest {
	DistanceCalculator dc;
	//Dublin office (GPS coordinates 53.3381985, -6.2592576)
	
	@Before
	public void setUp() throws Exception {
		dc = new DistanceCalculator();
	}

	@Test
	public void testGetLatitude() {
		assertEquals("latitude", 53.3381985, dc.getLatitude(),0);
	}

	@Test
	public void testGetLongitude() {
		assertEquals("longitude", -6.2592576, dc.getLongitude(),0);
	}

	@Test
	public void testDistanceCalculator() {
		assertEquals("longitude", dc.distance(dc.getLatitude(), dc.getLongitude(), 38.9, -9.078, "M"), 1006.4223954754251,0);
		assertEquals("longitude", dc.distance(dc.getLatitude(), dc.getLongitude(), 38.9, -9.078, "N"), 873.9772082308591,0);
		assertEquals("longitude", dc.distance(dc.getLatitude(), dc.getLongitude(), 38.9, -9.078, "K"), 1619.6798436240026,0);
	}

	@Test
	public void testDistance() {
		assertNotNull(dc);
	}

}
