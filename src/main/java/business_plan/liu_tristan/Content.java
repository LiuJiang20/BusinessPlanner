package business_plan.liu_tristan;

public interface Content
{
	public Content deepCopy();

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	boolean equals(Object obj);
	
	void edit();
	void display();
}