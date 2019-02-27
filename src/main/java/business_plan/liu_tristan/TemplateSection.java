package business_plan.liu_tristan;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;

import org.junit.internal.Throwables;

public class TemplateSection
{

	TemplateSection parent = null; //If the section has a parent section, this becomes it.
	ArrayList<TemplateSection> children; //List of subsections for this section.
	double childLimit; //The maximum number of child sections this one can have.
	String category; //The category of this TemplateSection.
	String name; //What this particular object is actually called in the design.
	ArrayList<Content> contents; //The contents of this section.
	
	
	/**
	 * @param category
	 * @param name
	 */

	//This constructor takes Strings for the category and name of the section.
	//It also takes a value for the maximum possible children.
	public TemplateSection(String category, String name,double childLimit)
	{
		
		this.category = category;
		this.name = name;
		this.childLimit = childLimit;
		children = new ArrayList<TemplateSection>();
		contents = new ArrayList<Content>();
	}
	
	//This alternate constructor takes only a name and category.
	//The child limit is automatically set to 1.
	public TemplateSection(String category, String name)
	{
		this(category, name, 1);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	//This method compares two TemplateSection objects to see if they're identical.
	//It compares their names, categories, children, contents, and child limit.
	public boolean equals(Object object)
	{
		TemplateSection t =(TemplateSection)object;
		if(!this.category.equals(t.category)
			|| !this.name.equals(t.name)
			||  children.size() != t.children.size()
			|| contents.size() != t.contents.size()
			|| childLimit != t.childLimit)
		{
			return false;
		}
		
		for(int i=0; i< this.children.size();i++)
		{
			if(!children.get(i).equals(t.children.get(i)))
			{
				return false;
			}
		}
		
		for(int i=0; i<contents.size();i++)
		{
			if(contents.get(i).equals(t.contents.get(i)))
			{
				return false;
			}
		}
		return true;
		
	}
	//Below are the methods for adding and deleting Content objects.
	public void addContent(Content c)
	{
		contents.add(c);
	}
	
	public void deleteContent(Content content) throws ContentNotFoundException
	{
		if(contents.indexOf(content) != -1)
			contents.remove(content);
		else
		{
			throw new ContentNotFoundException(); //Throws exception if the desired Content isn't there.
		}
		
	}
	
	//These methods allow for adding and deleting child sections.
	public void addChild(TemplateSection child) throws ChildLIimitException
	{
		if(childLimit > children.size())
		{
			children.add(child);
		}
		else
		{
			throw new ChildLIimitException(); //Throws exception if no more children can be added.
		}
	}

	public void deleteChild(TemplateSection child) throws ChildNotFoundException
	{
		if(children.indexOf(child)!=-1)
		{
			children.remove(child);
		}
		else
		{
			throw new ChildNotFoundException(); //Throws exception if the child doesn't exist.
		}
	}

	//This method returns a deep copy of the TemplateSection object.
	//It copies everything the TemplateSection has.
	public TemplateSection deepCopy()
	{
		TemplateSection deepCopy = new TemplateSection(this.category, this.name);
		deepCopy.setParent(parent);
		deepCopy.setChildLimit(childLimit);
		for(int i=0; i<children.size(); i++)
		{
			deepCopy.children.add(children.get(i).deepCopy());
		}
		
		for(Content content : contents)
		{
			deepCopy.contents.add(content.deepCopy());
		}
		
		return deepCopy;
	}
	
	/**
	 * @return the parent
	 */
	public TemplateSection getParent()
	{
		return parent;
	}


	/**
	 * @param parent the parent to set
	 */
	public void setParent(TemplateSection parent)
	{
		this.parent = parent;
	}


	/**
	 * @return the children
	 */
	public ArrayList<TemplateSection> getChildren()
	{
		return children;
	}


	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<TemplateSection> children)
	{
		this.children = children;
	}


	/**
	 * @return the childLimit
	 */
	public double getChildLimit()
	{
		return childLimit;
	}


	/**
	 * @param childLimit the childLimit to set
	 */
	public void setChildLimit(double childLimit)
	{
		this.childLimit = childLimit;
	}


	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}


	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}


	/**
	 * @return the contents
	 */
	public ArrayList<Content> getContents()
	{
		return contents;
	}


	/**
	 * @param contents the contents to set
	 */
	public void setContents(ArrayList<Content> contents)
	{
		this.contents = contents;
	}
}
