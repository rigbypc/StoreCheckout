package point.of.sale;

import com.google.inject.AbstractModule;

public class SaleInjectorModule extends AbstractModule {

	public SaleInjectorModule() {
	}

	@Override
    protected void configure() {
		bind(Display.class).to(ConsoleDisplay.class);
		
		bind(Interac.class).toInstance(new Interac(12));
		
		HashStorage hashStorage = new HashStorage();
		hashStorage.put("1B", "Chocolate");
		bind(HashStorage.class).toInstance(hashStorage);
		
		
	}
}
