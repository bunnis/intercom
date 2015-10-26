import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customer.Customer;

public class CustomerTest {

	Customer c;

	@Before
	public void setUp() throws Exception {
		c = new Customer();
		c.setId(0);
		c.setLatitude(38.5);
		c.setLongitude(-10.90);
		c.setName("example");
	}

	@Test
	public void testCustomer() {
		assertNotNull(c);
	}

	@Test
	public void testGetLatitude() {
		
		assertEquals("latitude", 38.5, c.getLatitude(),0);
	}

	@Test
	public void testSetLatitude() {
		c.setLatitude(9.0032);
		assertEquals("latitude", 9.0032, c.getLatitude(),0);
	}

	@Test
	public void testGetLongitude() {
		assertEquals("longitude", -10.90, c.getLongitude(),0);
	}

	@Test
	public void testSetLongitude() {
		c.setLongitude(-9.234);
		assertEquals("longitude", -9.234, c.getLongitude(),0);
	}

	@Test
	public void testGetId() {
		assertEquals("id", 0, c.getId(),0);
	}

	@Test
	public void testSetId() {
		c.setId(10);
		assertEquals("id", 10, c.getId(),0);
	}

	@Test
	public void testGetName() {
		assertEquals("name", "example", c.getName());
	}

	@Test
	public void testSetName() {
		c.setName("fake");
		assertEquals("name", "fake", c.getName());
	}

	@Test
	public void testToString() {
		c.setId(10);
		c.setLatitude(9.0032);
		c.setLongitude(-8.46);
		c.setName("dublin");
		System.out.println(c.toString());
		String testToString = "Customer [latitude=9.0032, longitude=-8.46, id=10, name=dublin]";

		assertEquals("toString", testToString, c.toString());

	}

	@Test
	public void testCompareTo() {
		Customer c2 = new Customer();
		c2.setId(5);
		
		c.setId(50);
		assertEquals("compareTo", 1, c.compareTo(c2));
		
		c.setId(5);
		assertEquals("compareTo", 0, c.compareTo(c2));
		
		c.setId(2);
		assertEquals("compareTo", -1, c.compareTo(c2));
		
	}

}
