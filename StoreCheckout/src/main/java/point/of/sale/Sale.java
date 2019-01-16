package point.of.sale;


public class Sale {
	
	HashStorage hashLookup;
	ArtR56Display artR56;
	
	public Sale () {
		
		//the display terminal is called ArtR56
		artR56 = new ArtR56Display();
		
		//Storage, add the items in the store
		HashStorage hashLookup = new HashStorage();
		hashLookup.put("1A", "Milk, 3.99");
		hashLookup.put("2A", "Bread, 4.99");
		
	}
	
	public void scan(String barcode) {
		//display the barcode
		artR56.showLine(barcode);
		
		//lookup barcode in postgres and get item
		String item = hashLookup.barcode(barcode);
		
		//display the item
		artR56.showLine(item);
		
	}

}
