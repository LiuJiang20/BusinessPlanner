package business_plan.liu_tristan;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.jar.Attributes.Name;

import org.hamcrest.core.IsEqual;

public class Template
{

	String developerTemplateName;
	String userTemplateName;
	TemplateSection root;
	TemplateSection templateRoot;

	public Template()
	{
		
	}
	public Template(TemplateSection root, TemplateSection templateRoot)
	{
		this.root = root;
		this.templateRoot = templateRoot;
	}

	public Template deepCopy()
	{
		TemplateSection newRoot = root.deepCopy();
		TemplateSection newTemplateRoot =templateRoot.deepCopy();
		Template deepCopy = new Template(newRoot,newTemplateRoot);
		deepCopy.setDeveloperTemplateName(this.developerTemplateName);
		deepCopy.setUserTemplateName(userTemplateName);
		return deepCopy;
	}

	public void addBranch(TemplateSection node) throws ChildLIimitException, NoParentException, NullChildException
	{
		TemplateSection section = findBranch(node, templateRoot);
		if(node.parent != null)
		{
			node.parent.addChild(section.deepCopy());
		}
		else
		{
			throw new NoParentException();
		}
	}
	
	
	private TemplateSection findBranch(TemplateSection add, TemplateSection template)
	{
		if(add.category.equals(template.category))
		{
			return template;
		}
		else
		{
			return findBranch(add, template.children.get(0));
		}
	}
	
	public void deleteBranch(TemplateSection node) throws ChildNotFoundException, NoParentException
	{
		if(node.parent != null)
		{
			node.parent.deleteChild(node);
		}
		else
		{
			throw new NoParentException();
		}
	}
	
	public void save()
	{
		XMLEncoder encoder =null;
		String fileName = userTemplateName+".xml";
		
		try
		{
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
		} 
		catch (FileNotFoundException fileNotFound)
		{
			System.out.println("ERROR: While Creating or Opening the File" +fileName);
		}
		
		encoder.writeObject(this);
		encoder.close();

	}

	public static Template load(String filename)
	{
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File "+filename+" not found");
		}
		Template loadTemplate = (Template)decoder.readObject();
		decoder.close();
		return loadTemplate;
	}

	/**
	 * @return the developerTemplateName
	 */
	public String getDeveloperTemplateName()
	{
		return developerTemplateName;
	}

	/**
	 * @param developerTemplateName the developerTemplateName to set
	 */
	public void setDeveloperTemplateName(String developerTemplateName)
	{
		this.developerTemplateName = developerTemplateName;
	}

	/**
	 * @return the userTemplateName
	 */
	public String getUserTemplateName()
	{
		return userTemplateName;
	}

	/**
	 * @param userTemplateName the userTemplateName to set
	 */
	public void setUserTemplateName(String userTemplateName)
	{
		this.userTemplateName = userTemplateName;
	}

	/**
	 * @return the root
	 */
	public TemplateSection getRoot()
	{
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TemplateSection root)
	{
		this.root = root;
	}
	
	

	/**
	 * @return the templateRoot
	 */
	public TemplateSection getTemplateRoot()
	{
		return templateRoot;
	}

	/**
	 * @param templateRoot the templateRoot to set
	 */
	public void setTemplateRoot(TemplateSection templateRoot)
	{
		this.templateRoot = templateRoot;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((developerTemplateName == null) ? 0 : developerTemplateName.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		result = prime * result + ((templateRoot == null) ? 0 : templateRoot.hashCode());
		result = prime * result + ((userTemplateName == null) ? 0 : userTemplateName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Template other = (Template) obj;
		if (developerTemplateName == null)
		{
			if (other.developerTemplateName != null)
				return false;
		} else if (!developerTemplateName.equals(other.developerTemplateName))
			return false;
		if (root == null)
		{
			if (other.root != null)
				return false;
    	} else if (!root.equals(other.root))
			return false;
		if (templateRoot == null)
		{
			if (other.templateRoot != null)
				return false;
		} else if (!templateRoot.equals(other.templateRoot))
			return false;
		if (userTemplateName == null)
		{
			if (other.userTemplateName != null)
				return false;
		} else if (!userTemplateName.equals(other.userTemplateName))
			return false;
		return true;
	}

	
//	/* 
//	 * @see java.lang.Object#equals(java.lang.Object)
//	 */
//	@Override
//	public boolean equals(Object object)
//	{
//		// TODO Auto-generated method stub
//		Template template = (Template) object;
//	
//		
//		if(this.userTemplateName == null)
//		{
//			if(template.userTemplateName != null)
//			{return false;}
//		}
//		else
//		{
//			if(! userTemplateName.equals(template.userTemplateName))
//			{
//				return false;
//			}
//		}
//		
//		if(developerTemplateName == null)
//		{
//			if(template.developerTemplateName !=null)
//			{return false;}
//		}
//		else
//		{
//			if(!developerTemplateName.equals(template.developerTemplateName))
//			{
//				return false;
//			}
//		}
//		
//		if(root == null)
//		{
//			if(template.root != null)
//			{
//				return false;
//			}
//		}
//		else
//		{
//			if(!root.equals(template.root))
//			{
//				return false;
//			}
//		}
//		
//		
//		if(templateRoot == null)
//		{
//			if(template.templateRoot!= null)
//			{
//				return false;
//			}
//		}
//		else
//		{
//			if(!templateRoot.equals(template.templateRoot))
//			{
//				return false;
//			}
//		}
//		return true;
////		return this.developerTemplateName.equals(template.developerTemplateName)
////				&& this.userTemplateName.equals(template.userTemplateName)
////				&& this.root.equals(template.root)
////				&& this.templateRoot.equals(template.templateRoot);
//		
//	}

	
}
