package point.of.sale;

import java.util.ArrayList;

public class Sale {
	
	HashStorage hashLookup;
	Display display;
	Interac interac;
	ArrayList<String> items = new ArrayList<>();
	
	public Sale(Display display, HashStorage hashStorage) {
		this.display = display;
		this.hashLookup = hashStorage;
		this.interac = new Interac(12);
	}
	
	public Sale() {
		//display
		display = new ArtR56Display();
		
		//Storage, add the items in the store
		hashLookup = new HashStorage();
		hashLookup.put("1A", "Milk, 3.99");
		hashLookup.put("2A", "Bread, 4.99");
		
		this.interac = new Interac(12);
	}
	
	public void scan(String barcode) {
		
		//lookup barcode in postgres and get item
		String item = hashLookup.barcode(barcode);
		
		//display the barcode
		display.showLine(barcode);
				
		
		//display the item
		display.showLine(item);
		
	}

}
