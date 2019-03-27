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
	public void testRollbackDiscount() {
		
		//new feature is off/dark
		StoreToggles.discountAllItems = false;
		Sale sale = new Sale(display, storage, interac);
		sale.scan("2");
		sale.completePurchase();
		verify(display).showLine("Beer, 9.99");
		verify(display, never()).showLine("Discount applied!");
		
		//turn on new feature, see the discount
		StoreToggles.discountAllItems = true;
		sale.completePurchase();
		verify(display).showLine("Discount applied!");
		
		
		//turn off the feature when there is a problem, no discount
		StoreToggles.discountAllItems = false;
		sale.completePurchase();
		verify(display, times(1)).showLine("Discount applied!");
	}
	
	@Test
	public void testRandom() {
		int iterations = 1000;
		
		AssignRandomDiscount rnd = new AssignRandomDiscount();
		
		for (int i = 0; i < iterations; i++) {
			
			//randomly assign x% of the sales to get discounts
			StoreToggles.discountAllItems = rnd.getDiscount(30);
			
			Sale sale = new Sale(display, storage, interac);
			
			if (StoreToggles.discountAllItems == true) {
				buyItems(sale, 10);
			}
			else {
				buyItems(sale, 3);
			}
			
			sale.completePurchase();
		}
	}
	
	private void buyItems(Sale sale, int numToBuy) {
		for (int i = 0; i < numToBuy; i++) {
			sale.scan("2");
		}
		
	}
	
}
