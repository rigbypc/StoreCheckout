package test.point.of.sale;

import static org.junit.Assert.*;
import point.of.sale.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import point.of.sale.Interac;

public class TestDataMigration {

	@Test
	public void test() {
		Display display = mock(Display.class);
		Interac interac = mock(Interac.class);
		
		HashStorage storage =  new HashStorage();
		storage.put("1", "Milk, 3.99");
		storage.put("2", "Beer, 10.99");
		
		Sale sale = new Sale(display, storage, interac);
		
		sale.scan("1");
		
		verify(display).showLine("Milk, 3.99");
	}

}
