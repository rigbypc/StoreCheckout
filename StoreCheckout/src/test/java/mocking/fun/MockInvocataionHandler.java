package mocking.fun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.Assert.*;

public class MockInvocataionHandler implements InvocationHandler {
	
	HashMap<String, String> verifyMap = new HashMap<String, String>();
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("Display methods call:");
		
		//name of method that was called
		System.out.println(method.getName());
		
		//the list of args
		for (Object object : args) {
			System.out.println(object.toString());
			verifyMap.put(method.getName(), object.toString());
		}
		return null;
	}

	public void verify(String method, String parameter) {
		assertEquals(verifyMap.get(method), parameter);
		
	}
	
	


}
