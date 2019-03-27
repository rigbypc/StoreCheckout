package test.point.of.sale;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.Test;

import point.of.sale.*;

public class TestSaleAnalytics {

	Display display;
	HashStorage storage;
	Interac interac;
	
	@Before
	public void setUp() throws Exception {
		
		display = mock(Display.class);
		
		storage = mock(HashStorage.class);
		when(storage.barcode("1")).thenReturn("Milk, 3.99");
		when(storage.barcode("2")).thenReturn("Beer, 9.99");
		when(storage.barcode("3")).thenReturn("Chocolate, 1.99");
		when(storage.barcode("4")).thenReturn("Chips, 0.99");
		
		interac = mock(Interac.class); 
		
		
	}
	
	@Test
	public void test() {
	
	}
	
	
	
}
