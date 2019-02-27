package business_plan.liu_tristan;

public class Image implements Content
{

	String URL;

	/**
	 * @param uRL
	 */
	public Image()
	{
		// TODO Auto-generated constructor stub
	}
	public Image(String uRL)
	{
		super();
		URL = uRL;
	}

	/**
	 * @return the uRL
	 */
	public String getURL()
	{
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL)
	{
		URL = uRL;
	}

	/* (non-Javadoc)
	 * @see business_plan.liu_tristan.Content#deepCopy()
	 */
	public Content deepCopy()
	{
		// TODO Auto-generated method stub
		return new Image(URL);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		Image i = (Image)obj;
		return URL.equals(i.URL);
	}
	
}
