package mocking.examples;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.List;


public class TestMocking {

	@Test
	public void test() {
		List<String> mockList = mock(List.class);
		
		mockList.add("one");
		mockList.get(0);
		
		verify(mockList).add("one");
		verify(mockList).get(0);
		
	}

}
