package point.of.sale;


public class Sale {
	
	HashStorage hashLookup;
	Display display;
	
	public Sale () {
		
		//the display terminal is called ArtR56
		display = new FakeDisplay();
		
		//Storage, add the items in the store
		HashStorage hashLookup = new HashStorage();
		hashLookup.put("1A", "Milk, 3.99");
		hashLookup.put("2A", "Bread, 4.99");
		
	}
	
	public void scan(String barcode) {
		//display the barcode
		display.showLine(barcode);
		
		//lookup barcode in postgres and get item
		String item = hashLookup.barcode(barcode);
		
		//display the item
		display.showLine(item);
		
	}

}
