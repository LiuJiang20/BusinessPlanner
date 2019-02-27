package business_plan.liu_tristan;

import org.junit.jupiter.api.Test;

public class TextTest
{
	@Test
	//This tests the getting & setting for the String attribute of Text.
	//It also compares Text objects with identical or different text.
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
