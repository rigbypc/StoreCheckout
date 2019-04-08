package test.point.of.sale;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import point.of.sale.*;

public class FuzzTesting {

	@Test
	public void testSale() {
		
		int iterations = 10;
		
		for (int i = 0; i < iterations; i++) {
				
			Interac interac = mock(Interac.class); 
			Display display = mock(Display.class);
			
			int numItems = 3;
			ArrayStorage storage =  new ArrayStorage();
			storage.put("1", "Milk, 3.99");
			storage.put("2", "Beer, 9.99");
			storage.put("3", "Bread, 19.99");
					
			Sale sale = new Sale(display, storage, interac);
			
			//(null pointer) Tests the corner case and finds a bug that should be fixed
			//Integer rndBarcode = ThreadLocalRandom.current().nextInt(3, 1000+1);
			
			// Array index out of bounds
			//Integer rndBarcode = ThreadLocalRandom.current().nextInt(1000, 10000+1);
			
			//know the number of items in the test (within the normal range), multiple
			// Want to make sure that in the normal range I don't get exceptions
			Integer rndBarcode = ThreadLocalRandom.current().nextInt(1, numItems+1);
			
			sale.scan(rndBarcode.toString());
			verify(display, times(3)).showLine(any(String.class));
		}
			
	}
}