package test.point.of.sale;

import static org.junit.Assert.*;
import point.of.sale.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestDataMigration {

	@Test
	public void test() {
		Display display = mock(Display.class);
		Interac interac = mock(Interac.class);
		
		ArrayStorage storage =  new ArrayStorage();
		storage.put("1", "Milk, 3.99");
		storage.put("2", "Beer, 10.99");
		
		//Forklift (mass migration)
		storage.forklift();
		assertEquals(0, storage.checkConsistency());
		
		//Consistency Checking (includes incremental replication)
		storage.put("3", "Eggs, 4.99");
		// 1 inconsistency, because we don't do shadow writing
		assertEquals(1, storage.checkConsistency());
		//0 inconsistent, because we incrementally update
		assertEquals(0, storage.checkConsistency());
		
		//Shadow writes (writes to old and new datastore)
		
		
		//Shadow reads (checks that old and new datastores return the same value
		
		//Read and write from new datastore (get rid of old datastore)
		
		
		Sale sale = new Sale(display, storage, interac);
		
		sale.scan("1");
					
		verify(display).showLine("Milk, 3.99");
	}

}
