package test.point.of.sale;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestConsistency {

	@Test
	public void test() {
		String password = "Hello World";
		String oldHash = "A591A6D40BF420404A011733CFB7B190D62C65BF0BCDA32B57B277D9AD9F146E";
		
		String hashed = DigestUtils.sha256Hex(password).toUpperCase();
		assertEquals(oldHash, hashed);
		
		
	}

}
