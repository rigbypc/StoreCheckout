package mocking.fun;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TestMockingFun {

	@Test
	public void test() {
		List mockedList = mock(List.class);
		
		//call the add method
		mockedList.add("one");
		//verify it ws called with the parameter
		verify(mockedList).add("one");
		
		when(mockedList.get(0)).thenReturn("first");
		assertEquals(mockedList.get(0), "first");
	}
	
	@Test
	public void testSpy() {
		List<String> list = new LinkedList<String>();
		List<String> listSpy = spy(list);
		when(listSpy.size()).thenReturn(100);
		listSpy.add("one");
		
		assertEquals(listSpy.get(0), "one");
		assertEquals(listSpy.size(), 100);
	}

	@Test
	public void testStack() {
		Stack<String> stack = mock(Stack.class);
		when(stack.pop()).thenReturn("3", "2");
		
		assertEquals(stack.pop(), "3");
		assertEquals(stack.pop(), "2");
	}
}
