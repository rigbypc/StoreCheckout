package point.of.sale;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainSale {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new SaleInjectorModule());
		Sale sale = injector.getInstance(Sale.class);

		sale.scan("1B");
	}

}
