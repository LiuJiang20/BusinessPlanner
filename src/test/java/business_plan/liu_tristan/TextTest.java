package business_plan.liu_tristan;

import org.junit.jupiter.api.Test;

public class TextTest
{
	@Test
	public static void main(String[] args)
	{
		Text t = new Text("hello");
		assert t.getText() == "hello";
		t.setText("goodbye");
		assert t.getText() == "goodbye";
		Text t2 = new Text("hello");
		assert t.equals(t2) == false;
		t2.setText("goodbye");
		assert t.equals(t2) == true;
		Content t3 = t.deepCopy();
		assert t.equals(t3) == true;
	}
}
