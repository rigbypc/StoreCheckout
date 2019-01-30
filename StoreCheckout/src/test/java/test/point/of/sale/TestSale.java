package test.point.of.sale;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import point.of.sale.Display;
import point.of.sale.HashStorage;
import point.of.sale.Sale;

import static org.mockito.Mockito.*;

public class TestSale {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testScan() {
		
		Display display = mock(Display.class);
		HashStorage hashStorage = mock(HashStorage.class);
		when(hashStorage.barcode("1A")).thenReturn("Milk, 3.99");
		
		Sale sale = new Sale(display, hashStorage);
		sale.scan("1A");
		
		InOrder inOrder = inOrder(display, hashStorage);
		inOrder.verify(hashStorage).barcode("1A");
		inOrder.verify(display).showLine("1A");
		inOrder.verify(display).showLine("Milk, 3.99");
		
	}
	
	//@Test
	public void testMockStubFun() {
		
		//nothing is under test, all objects are mocked, this is just for fun!
		
		HashStorage hashStorage = mock(HashStorage.class);
		
		when(hashStorage.barcode("Select * from people")).thenReturn("Peter, Blah");
		when(hashStorage.barcode("1A")).thenReturn("Milk, 10.99");
		hashStorage.put("1A", "Milk, 3.99");
		
		System.out.println(hashStorage.barcode("Select * from people"));
		System.out.println(hashStorage.barcode("1A"));
		System.out.println(hashStorage.barcode("Hello World"));
		
		verify(hashStorage).put("1A", "Milk, 3.99");
	}

}
