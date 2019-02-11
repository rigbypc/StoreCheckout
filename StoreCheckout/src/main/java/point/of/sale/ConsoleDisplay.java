package point.of.sale;

public class ConsoleDisplay implements Display {

	public ConsoleDisplay() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showLine(String line) {
		System.out.println(line);

	}

}
