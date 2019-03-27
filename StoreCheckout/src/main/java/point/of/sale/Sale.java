package point.of.sale;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;



public class Sale {
	
	@Inject
	HashStorage hashLookup;
	@Inject
	Display display;
	@Inject
	Interac interac;
	
	private static Logger analytics = LogManager.getLogger("Analytics");
	
	ArrayList<String> items = new ArrayList<>();
	
	//for testing purposes
	@Inject
	public Sale(Display display, HashStorage hashStorage, Interac interac) {
		this.display = display;
		this.hashLookup = hashStorage;
		this.interac = interac;
		
		display.showLine(StoreInfo.getInstance().getName());
		
	}
	
	//original legacy
	public Sale() {
		
		this(new ArtR56Display(), new HashStorage(), new Interac(12));
		
		//Storage, add the items in the store
		hashLookup = new HashStorage();
		hashLookup.put("1A", "Milk, 3.99");
		hashLookup.put("2A", "Bread, 4.99");
		
	}
	
	public void completePurchase() {
		
		if (StoreToggles.discountAllItems == true) {
			//apply the discount
			analytics.info("Discount Applied, " + items.size());
			display.showLine("Discount applied!");
		}
		else {
			analytics.info("No Discount, " + items.size());
		}
		
		interac.pay(items);
	}
	
	public void scan(String barcode) {
				
		//lookup barcode in storage and get item
		String item = hashLookup.barcode(barcode);
		
		//display the barcode
		display.showLine(barcode);
		
		//display the item
		display.showLine(item);
		
		//Store it for payment 
		items.add(item);
		
	}

	public void testingOnlySupercedeInterac(Interac interac) {
		this.interac = interac;
		
	}

}
