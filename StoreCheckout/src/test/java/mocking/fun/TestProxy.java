package mocking.fun;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import point.of.sale.*;

import static org.mockito.Mockito.*;

public class TestProxy {

	//@Test
	public void test() {
		Method[] methods = HashStorage.class.getMethods();
		
		for (Method method : methods) {
			System.out.println(method);
		}
	}

	@Test
	public void testDisplayProxy() {
			
			//mockito storage
			HashStorage hashStorage = mock(HashStorage.class);
			when(hashStorage.barcode("1A")).thenReturn("Milk, 3.99");
			//mockito interac
			Interac interac = mock(Interac.class);
					
			//display is being mocked by my new proxy handler
			MockInvocataionHandler mockHandler = new MockInvocataionHandler();
			Display displayProxy = (Display) Proxy.newProxyInstance(
					//the class
					Display.class.getClassLoader(),
			        //list of interfaces
					new Class[] { Display.class },
			            //the handler to call when the proxy is invoked                
						mockHandler);
				
			//real object under test
			Sale sale = new Sale(displayProxy, hashStorage, interac);
			sale.scan("1A");
			
			mockHandler.verify("showLine", "Milk, 3.99");
			
			//mockito
			verify(hashStorage).barcode("1A");
		}

}
