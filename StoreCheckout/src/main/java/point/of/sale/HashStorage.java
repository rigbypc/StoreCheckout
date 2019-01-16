package point.of.sale;

import java.util.HashMap;

public class HashStorage {

	HashMap<String, String> hashMap = new HashMap<>();
	
	public void put(String barcode, String item) {
		hashMap.put(barcode, item);
	}
		
	public String barcode(String barcode) {
		return hashMap.get(barcode);
	}

}
