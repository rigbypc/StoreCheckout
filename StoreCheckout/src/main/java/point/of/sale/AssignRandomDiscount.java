package point.of.sale;

import java.util.concurrent.ThreadLocalRandom;

public class AssignRandomDiscount {

	public AssignRandomDiscount() {
		
	}
	
	public boolean getDiscount(int proportionWithDiscount) {
		
		int rnd = ThreadLocalRandom.current().nextInt(1, 101);
		
		if(proportionWithDiscount >= rnd) {
			return true;
		}
		
		return false;
		
	}

}
