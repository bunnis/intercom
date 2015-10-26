import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import array.utils.ArrayFlattener;

public class ArrayFlattenerTest {
	ArrayFlattener af;

	@Before
	public void setUp() throws Exception {
		af = new ArrayFlattener();
	}

	@Test
	public void testFlat() {
		// null array
		assertNull("null array",af.flat(null));

		// empty array
		assertArrayEquals("empty array",new Object[]{},
				af.flat(new Object[]{}).toArray());

		// flat array
		assertArrayEquals("flat Array",new Object[]{5,23,64,123,2},
				af.flat(new Object[]{5,23,64,123,2}).toArray());

		// two level array
		assertArrayEquals("flatten a two level array",
				new Object[]{5,23,64,123,2,0,8},
				af.flat(new Object[]{ 5, 23, new Object[]{ 64, 123, 2}, 0, 8}).toArray()
				);

		// three level array
		assertArrayEquals("flatten a three level array",
				new Object[]{5,23,64,123,2,0,8},
				af.flat(new Object[]{5,23,new Object[]{64,new Object[]{123,2}},0,8}).toArray()
				);
		
		// three level array same numbers
		assertArrayEquals("flatten a three level array",
				new Object[]{0,0,0,0,0,0,0},
				af.flat(new Object[]{0,0,new Object[]{0,new Object[]{0,0}},0,0}).toArray()
				);
	}

}
