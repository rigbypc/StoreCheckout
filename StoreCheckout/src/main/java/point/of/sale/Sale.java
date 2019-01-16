package point.of.sale;


public class Sale {
	
	HashStorage hashLookup;
	ArtR56 artR56;
	
	public Sale (HashStorage hashLookup) {
		this.hashLookup = hashLookup;
		this.artR56 = artR56;
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
