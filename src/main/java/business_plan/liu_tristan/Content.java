package business_plan.liu_tristan;

public interface Content extends Comparable<Content>
{
	public Content deepCopy();

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	boolean equals(Object obj);

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	default int compareTo(Content o)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	

}

