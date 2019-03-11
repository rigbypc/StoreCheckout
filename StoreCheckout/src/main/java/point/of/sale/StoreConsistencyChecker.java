package point.of.sale;

import org.apache.commons.codec.digest.DigestUtils;

public class StoreConsistencyChecker {

	ArrayStorage storage;
	String itemCheck = "";
	
	public StoreConsistencyChecker(ArrayStorage storage) {
		this.storage = storage;
	}
	
	public void updateConsistencyCheck() {
		itemCheck = calculateConsistency();
	}
	
	private String calculateConsistency() {

		String items = "";
		String[] array = storage.getCopyArrayStorage();
		
		//check the consistency of the items for sale
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				//use raw values
				items += Integer.toString(i) + " " + array[i] + "; ";	
				
			}
		}
		
		return items;
		
	}
	
	public boolean checkConsistency() {
		String actual = calculateConsistency();
		
		System.out.println("expect = " + itemCheck + "\n" + "actual = " + actual + "\n");
		
		return itemCheck.equals(actual);
	}
	
	private String hashValue(String value) {
		return DigestUtils.shaHex(value).toUpperCase();
	}


}
