package test.point.of.sale;

import point.of.sale.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestSaleMockito {

	@Mock
	Display display;
	@Mock
	HashStorage storage;
	@Mock
	Interac interac;
	
	//Class under test
	Sale sale;
	
	@Before
	public void setUpSale() {
		
		when(storage.barcode("1B")).thenReturn("Chocolate, 4.99");
		
		sale = new Sale(display, storage, interac);
	}
	
	
	@Test
	public void testScan() {
		sale.scan("1B");
		verify(display).showLine("1B");
		
		verify(storage).barcode("1B");
		verify(display).showLine("Chocolate, 4.99");
		
		
	}

}
