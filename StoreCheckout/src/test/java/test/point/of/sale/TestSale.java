package test.point.of.sale;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import point.of.sale.*;

public class TestSale {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testScan() {
		Sale sale = new Sale();
		sale.scan("1A");
		//fail("Not yet implemented");
	}

}
