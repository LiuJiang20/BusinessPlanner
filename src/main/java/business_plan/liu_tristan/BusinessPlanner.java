package business_plan.liu_tristan;

//Note:We have decided not to use this in our current implementation but it is here for reference.
public class BusinessPlanner
{
	Template developerTemplate;
	Template userTemplate;
	TemplateSection current;
	
	/**
	 * @param developerTemplate
	 * @param userTemplate
	 */
	public BusinessPlanner(Template developerTemplate, Template userTemplate)
	{
		super();
		this.developerTemplate = developerTemplate;
		this.userTemplate = userTemplate;
		current = userTemplate.root;
	}
	
	
	/**
	 * @return the developerTemplate
	 */
	public Template getDeveloperTemplate()
	{
		return developerTemplate;
	}

	/**
	 * @param developerTemplate the developerTemplate to set
	 */
	public void setDeveloperTemplate(Template developerTemplate)
	{
		this.developerTemplate = developerTemplate;
	}
	
	
	/**
	 * @return the userTemplate
	 */
	public Template getUserTemplate()
	{
		return userTemplate;
	}
	
	
	/**
	 * @param userTemplate the userTemplate to set
	 */
	public void setUserTemplate(Template userTemplate)
	{
		this.userTemplate = userTemplate;
	}
	
	
	/**
	 * @return the current
	 */
	public TemplateSection getCurrent()
	{
		return current;
	}
	
	
	/**
	 * @param current the current to set
	 */
	public void setCurrent(TemplateSection current)
	{
		this.current = current;
	}
}
