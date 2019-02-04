package test.point.of.sale;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import point.of.sale.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class TestSale {

	Display display;
	HashStorage hashStorage;
	Interac interac;
	
	
	@Before
	public void setUp() throws Exception {
		display = mock(Display.class);
		
		hashStorage = mock(HashStorage.class);
		when(hashStorage.barcode("1A")).thenReturn("Milk, 3.99");
		
		interac = mock(Interac.class); 
		
	}

	@Test
	public void testScan() {
		
		
		Sale sale = new Sale(display, hashStorage, interac);
		sale.scan("1A");
		sale.completePurchase();
		
		verify(hashStorage).barcode("1A");
		verify(display).showLine("1A");
		verify(display).showLine("Milk, 3.99");
		
		//check that the a list is passed to the pay function
		verify(interac).pay(any(ArrayList.class));
		
		//verifying the contents
		ArrayList<String> payItems = new ArrayList<String>();
		payItems.add("Milk, 3.99");
		verify(interac).pay(payItems);
		
		
	}
	
	@Test
	public void testScanArgCaptor() {
		
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		
		
		Sale sale = new Sale(display, hashStorage, interac);
		sale.scan("1A");
		
		InOrder inOrder = inOrder(display, hashStorage);
		
		//whatever value is being requested from the data store is ...
		inOrder.verify(hashStorage).barcode(argCaptor.capture());
		// also being displayed
		inOrder.verify(display).showLine(argCaptor.getValue());
		
		inOrder.verify(display).showLine("Milk, 3.99");
		
	}
	
}
