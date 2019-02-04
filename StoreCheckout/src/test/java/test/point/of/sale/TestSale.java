package test.point.of.sale;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import point.of.sale.*;

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
		
		verify(hashStorage).barcode("1A");
		verify(display).showLine("1A");
		verify(display).showLine("Milk, 3.99");
		
	}
	
	@Test
	public void testScanArgCaptor() {
		
		Display display = mock(Display.class);
		
		HashStorage hashStorage = mock(HashStorage.class);
		when(hashStorage.barcode("1A")).thenReturn("Milk, 3.99");
		
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		
		
		Sale sale = new Sale(display, hashStorage);
		sale.scan("1A");
		
		InOrder inOrder = inOrder(display, hashStorage);
		
		//whatever value is being requested from the data store is ...
		inOrder.verify(hashStorage).barcode(argCaptor.capture());
		// also being displayed
		inOrder.verify(display).showLine(argCaptor.getValue());
		
		inOrder.verify(display).showLine("Milk, 3.99");
		
	}
	
}
