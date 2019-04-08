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
		
		Interac interac = mock(Interac.class); 
		Display display = mock(Display.class);
		
		ArrayStorage storage =  new ArrayStorage();
		storage.put("1", "Milk, 3.99");
		storage.put("2", "Beer, 9.99");
				
		Sale sale = new Sale(display, storage, interac);
		
		Integer rndBarcode = ThreadLocalRandom.current().nextInt(3, 1000+1);
		
		sale.scan(rndBarcode.toString());
		verify(display).showLine("Milk, 3.99");
		
	}
}