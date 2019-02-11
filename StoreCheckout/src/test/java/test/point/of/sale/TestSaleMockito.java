package test.point.of.sale;

import point.of.sale.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestSaleMockito {

	@Mock
	Display display;
	@Mock
	HashStorage storage;
	@Mock
	Interac interac;
	
	//Class under test
	Sale sale;
	
	@Before
	public void setUpSale() {
		sale = new Sale(display, storage, interac);
	}
	
	
	@Test
	public void testScan() {
		sale.scan("1A");
		verify(display).showLine("1A");
	}

}
