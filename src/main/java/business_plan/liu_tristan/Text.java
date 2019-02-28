package business_plan.liu_tristan;

public class Text implements Content
{

	
	String text;
	
	
	
	
	/**
	 * @param text
	 */
	public Text()
	{
		// TODO Auto-generated constructor stub
	}
	public Text(String text)
	{
		this.text = text;
	}
	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text)
	{
		this.text = text;
	}
	public Content deepCopy()
	{
		// TODO Auto-generated method stub
		return new Text(text);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		Text t = (Text) obj;
		return text.equals(t.text);
	}


	/* (non-Javadoc)
	 * @see business_plan.liu_tristan.Content#compareTo(business_plan.liu_tristan.Content)
	 */
	@Override
	public int compareTo(Content o)
	{
		// TODO Auto-generated method stub
		Text other = (Text) o;
		return this.text.compareTo(other.text);
	}

}
