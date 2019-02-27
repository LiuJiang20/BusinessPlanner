package business_plan.liu_tristan;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;

import org.junit.internal.Throwables;
import java.beans.*;


public class TemplateSection
{

	TemplateSection parent = null;
	ArrayList<TemplateSection> children;
	double childLimit;
	String category;
	String name;
	ArrayList<Content> contents;
	
	
	/**
	 * @param category
	 * @param name
	 */

	public TemplateSection()
	{
		// TODO Auto-generated constructor stub
	}
	public TemplateSection(String category, String name,double childLimit)
	{
		
		this.category = category;
		this.name = name;
		this.childLimit = childLimit;
		children = new ArrayList<TemplateSection>();
		contents = new ArrayList<Content>();
	}
	
	public TemplateSection(String category, String name)
	{
		this(category, name, 1);
	}
	


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		long temp;
		temp = Double.doubleToLongBits(childLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TemplateSection other = (TemplateSection) obj;
//		if (category == null)
//		{
//			if (other.category != null)
//				return false;
//		} else if (!category.equals(other.category))
//			return false;
//		if (Double.doubleToLongBits(childLimit) != Double.doubleToLongBits(other.childLimit))
//			return false;
//		if (children == null)
//		{
//			if (other.children != null)
//				return false;
//		} else if (!children.equals(other.children))
//			return false;
//		if (contents == null)
//		{
//			if (other.contents != null)
//				return false;
//		} else if (!contents.equals(other.contents))
//			return false;
//		if (name == null)
//		{
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (parent == null)
//		{
//			if (other.parent != null)
//				return false;
//		} else if (!parent.equals(other.parent))
//			return false;
//		return true;
//	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object)
	{
		TemplateSection t =(TemplateSection)object;
		if(t== null)
		{
			return false;
		}
		//Usually way to test parents are equal will end up in infinite loop
		//thus here we only test the name, and contegory
		if(parent ==null)
		{
			if(t.parent !=null)
				return false;
		}
		else
		{
			if(name ==null)
			{
				if (t.name != null)
					return false;
			}	
			else
			{
				if(!name.equals(t.name))
					return false;
			}
			
			if(category ==null)
			{
				if (t.category != null)
					return false;
			}	
			else
			{
				if(!category.equals(t.category))
					return false;
			}
		}
			
		if(category == null)
		{
			if(t.category != null)
			{
				return false;
			}
		}
		else
		{
			if(!category.equals(t.category))
			{
				return false;
			}
		}
		
		if(name == null)
		{
			if(t.name != null)
			{
				return false;
			}
		}
		else
		{
			if(!name.equals(t.name))
			{
				return false;
			}
		}
		
		if(childLimit != t.childLimit)
		{
			return false;
		}
		
		if(children.size() != t.children.size())
		{
			return false;
		}
		
		if(contents.size() != t.contents.size())
		{
			return false;
		}
		
		
		ArrayList<TemplateSection> temp1 = (ArrayList<TemplateSection>) children.clone();
		ArrayList<TemplateSection> temp2 = (ArrayList<TemplateSection>) t.children.clone();
		temp1.sort((TemplateSection a, TemplateSection b) -> a.name.compareTo(b.name));
		temp2.sort((TemplateSection a, TemplateSection b) -> a.name.compareTo(b.name));
		for(int i=0; i< this.children.size();i++)
		{
			
			TemplateSection t1 =temp1.get(i);
			
			TemplateSection t2 = temp2.get(i);
			if(!t1.equals(t2))
			{
				return false;
			}
		}
		
		ArrayList<Content> temp3 = (ArrayList<Content>) contents.clone();
		ArrayList<Content> temp4 = (ArrayList<Content>) t.contents.clone();
		temp3.sort((Content a, Content b) -> a.compareTo(b));
		temp4.sort((Content a, Content b) -> a.compareTo(b));
		for(int i=0; i<contents.size();i++)
		{
			
			Content c1 =temp3.get(i);
			Content c2 = temp4.get(i);
			if(!(c1 == null && c2 ==null || c1.equals(c2)))
			{
				return false;
			}
		}
		return true;
		
	}
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
			throw new ContentNotFoundException();
		}
		
	}
	
	@Transient
	public void addChild(TemplateSection child) throws ChildLIimitException, NullChildException
	{
		if(child == null)
		{
			throw new NullChildException();
		}
		
		if(childLimit > children.size())
		{
			child.setParent(this);
			children.add(child);
			
		}
		else
		{
			throw new ChildLIimitException();
		}
	}

	public void deleteChild(TemplateSection child) throws ChildNotFoundException
	{
		if(children.indexOf(child)!=-1)
		{
			child.setParent(null);
			children.remove(child);
		}
		else
		{
			throw new ChildNotFoundException();
		}
	}

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
