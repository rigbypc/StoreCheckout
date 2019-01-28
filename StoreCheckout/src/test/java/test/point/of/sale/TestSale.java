package test.point.of.sale;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import point.of.sale.Display;
import point.of.sale.FakeDisplay;
import point.of.sale.Sale;

import static org.mockito.Mockito.*;

public class TestSale {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testScan() {
		
		Display display = mock(Display.class);
		
		Sale sale = new Sale(display);
		sale.scan("1A");
		InOrder inOrder = inOrder(display);
		inOrder.verify(display).showLine("1A");
		inOrder.verify(display).showLine("Milk, 3.99");
		
	}

}
