package point.of.sale;

public class FakeDisplay implements Display {

	public FakeDisplay() {

	}

	@Override
	public void showLine(String line) {
		System.out.println(line);

	}

}
