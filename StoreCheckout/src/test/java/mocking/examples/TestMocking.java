package mocking.examples;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Stack;


public class TestMocking {

	
	@Test
	public void testStack() {
		//create a mocked stack
		Stack stack = mock(Stack.class);
		
		//stub mockStack.pop with 3,2,1
		when(stack.pop()).thenReturn("3", "2", "1", null);
		
		//assert that the mockito stubbing function works correctly (ie write three pop asserts)
		assertEquals("3", stack.pop());
		verify(stack).pop();
		assertEquals("2", stack.pop());
		assertEquals("1", stack.pop());
		
		assertEquals(null, stack.pop());
	}
	
	@Test
	public void test() {
		List<String> mockList = mock(List.class);
		
		when(mockList.get(0)).thenReturn("one");
		
		mockList.add("one");
		mockList.get(0);
		
		verify(mockList).add("one");
		verify(mockList).get(0);
		
		assertEquals("one", mockList.get(0));
		
	}

}
