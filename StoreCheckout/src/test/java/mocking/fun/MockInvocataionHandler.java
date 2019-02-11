package mocking.fun;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.junit.Assert.*;

public class MockInvocataionHandler implements InvocationHandler {
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass());
		
		System.out.println(method.getName());
		
		for (Object object : args) {
			System.out.println(object.toString());
		}
		return null;
	}

	public void verify(String method, String parameter) {
		// TODO Auto-generated method stub
		
	}
	
	


}
