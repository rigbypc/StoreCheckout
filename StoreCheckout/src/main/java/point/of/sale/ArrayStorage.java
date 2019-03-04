package point.of.sale;

public class ArrayStorage extends HashStorage {

	int size = 999;
	String[] array;
	
	@Override
	public void put(String barcode, String item) {
		// TODO Auto-generated method stub
		super.put(barcode, item);
	}

	@Override
	public String barcode(String barcode) {
		// TODO Auto-generated method stub
		return super.barcode(barcode);
	}

	public ArrayStorage() {
		array = new String[size];
	}
	
	public void forklift() {
		//copy over all the data that is in the hash
		for (String barcode : hashMap.keySet()) {
			array[Integer.parseInt(barcode)] = hashMap.get(barcode);
			
		}
	}

}
