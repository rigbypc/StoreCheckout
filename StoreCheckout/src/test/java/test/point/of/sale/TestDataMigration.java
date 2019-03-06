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
		storage.testingOnlyHashPut("1", "Milk, 3.99");
		storage.testingOnlyHashPut("2", "Beer, 10.99");
		
		//Forklift (mass migration)
		storage.forklift();
		assertEquals(0, storage.checkConsistency());
		
		//Consistency Checking (includes incremental replication)
		storage.testingOnlyHashPut("3", "Eggs, 4.99");
		// 1 inconsistency, because we don't do shadow writing
		assertEquals(1, storage.checkConsistency());
		//0 inconsistent, because we incrementally update
		assertEquals(0, storage.checkConsistency());
		
		//Shadow writes (writes to old and new datastore)
		storage.put("4", "Bread, 5.99");
		//no inconsistency, because we shadow write to the new datastore
		assertEquals(0, storage.checkConsistency());
		
		
		//Shadow reads (checks that old and new datastores return the same value
		storage.testingOnlyHashPut("5", "Wine, 19.99");
		storage.barcode("5");
		assertEquals(1, storage.getReadInconsistencies());
		
		//should still only have one read inconsistency as new datastore should be consistent now
		storage.barcode("5");
		assertEquals(1, storage.getReadInconsistencies());
		
		
		//Read and write from new datastore (get rid of old datastore)
		storage.put("6", "Cookies, 1.99");
		assertEquals("Cookies, 1.99", storage.barcode("6"));
		
		Sale sale = new Sale(display, storage, interac);
		
		sale.scan("1");
					
		verify(display).showLine("Milk, 3.99");
	}

}
