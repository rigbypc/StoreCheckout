package test.point.of.sale;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import point.of.sale.*;

public class TestConsistency {

	@Test
	public void testSaleStorageConsistency() {
		ArrayStorage storage = new ArrayStorage();
		storage.put("1", "Milk, 3.99");
		storage.put("2", "Beer, 4.99");
		
		StoreConsistencyChecker checker = new StoreConsistencyChecker(storage);
		
		//get the consistency value
		checker.updateConsistencyCheck();
		//check that nothing has changed
		assertTrue(checker.checkConsistency());
		
		storage.put("3", "Wine, 19.99");
		assertFalse(checker.checkConsistency());
		
		storage.put("2", "Beer, 0.01");
		assertFalse(checker.checkConsistency());
		
		storage.put("2", "Beer, 1.99");
		
		
		checker.updateConsistencyCheck();
		//checker.updateConsistencyCheck();
		assertTrue(checker.checkConsistency());
		
		
	}
	
	//@Test
	public void test() {
		String password = "Hello World";
		String oldHash = "A591A6D40BF420404A011733CFB7B190D62C65BF0BCDA32B57B277D9AD9F146E";
		
		String hashed = DigestUtils.sha256Hex(password).toUpperCase();
		assertEquals(oldHash, hashed);
		
		
	}
	

}
