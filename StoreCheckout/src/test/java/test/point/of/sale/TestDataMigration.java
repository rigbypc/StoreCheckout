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
		
		//Forklift (mass migration)
		
		//Consistency Checking (includes incremental replication)
		
		//Shadow writes (writes to old and new datastore)
		
		//Shadow reads (checks that old and new datastores return the same value
		
		//Read and write from new datastore (get rid of old datastore)
		
		
		Sale sale = new Sale(display, storage, interac);
		
		sale.scan("1");
					
		verify(display).showLine("Milk, 3.99");
	}

}
