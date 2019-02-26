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

	public void addBranch(TemplateSection node) throws ChildLIimitException, NoParentException
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
		String fileName;
		if(userTemplateName.equals(developerTemplateName))
		{
			fileName = "T"+developerTemplateName;
		}
		else
		{
			fileName = userTemplateName;
		}
		fileName+=".xml";
		
		try
		{
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
		} 
		catch (FileNotFoundException fileNotFound)
		{
			System.out.println("ERROR: While Creating or Opening the File" +fileName +".xml");
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
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object)
	{
		// TODO Auto-generated method stub
		Template template = (Template) object;
		return this.developerTemplateName.equals(template.developerTemplateName)
				&& this.userTemplateName.equals(template.userTemplateName)

				&& this.root.equals(template.root)
				&& this.templateRoot.equals(template.templateRoot);
		

	}
}
