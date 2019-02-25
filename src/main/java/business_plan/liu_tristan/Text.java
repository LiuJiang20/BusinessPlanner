package business_plan.liu_tristan;

public class Text implements Content
{
	String text;
	
	public Text(String text)
	{
		this.text = text;
	}
	
	public display()
	{
	}
	
	public deepCopy()
	{
		deepCopy Text = new Text(text);
		return deepCopy;
	}
	
	public equals(Text comparison)
	{
		if(text == comparison.text)
		{
			return True;
		}
		return False;
	}
}
