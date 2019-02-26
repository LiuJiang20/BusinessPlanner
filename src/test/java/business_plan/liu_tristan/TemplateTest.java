package business_plan.liu_tristan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemplateTest
{

	

	/*
	 * Test if the equals() function works fine
	 */
	@Test
	void testEquals()
	{
		//Case two template should be equal
		TemplateSection root1 = new TemplateSection("Vision", "Vision",2);
		TemplateSection root2 = new TemplateSection("Mission", "Mission",2);
		
		Template t1 = new Template(root1, root1);
		Template t2 = new Template(root1, root1);
		
		String name1 = "VMOSA";
		String name2 = "Centre";
		
		t1.setDeveloperTemplateName(name1);
		t1.setUserTemplateName(name1);
		t2.setDeveloperTemplateName(name1);
		t2.setUserTemplateName(name1);
		
		assertEquals(t1, t2);
		
		//Case when their DeveloperTemplateName is not equal
		t2.setDeveloperTemplateName(name2);
		assertNotEquals(t1, t2);
		
		//Case when their UserTemplateName is not equal
		t2.setDeveloperTemplateName(name1);
		t2.setUserTemplateName(name2);
		
		assertNotEquals(t1, t2);
		
		// Case when both UserTemplateName and DeveloperTemplateName are not equal
		t2.setDeveloperTemplateName(name2);
		assertNotEquals(t1, t2);
		
		//Case when their user root is not equal
		t2.setDeveloperTemplateName(name1);
		t2.setUserTemplateName(name1);

		t2.setRoot(root2);
		assertNotEquals(t1, t2);
		
		//Case when their template root is not equal
		t2.setRoot(root1);
		t2.setTemplateRoot(root2);
		assertNotEquals(t1, t2);
		
		//Case when their both roots are not equal
		t2.setRoot(root2);
		assertNotEquals(t1, t2);
		
		// Case when the user root is slightly different
		TemplateSection root3 = new TemplateSection("Mission", "Mission",1);
		t2.setTemplateRoot(root1);
		t2.setRoot(root3);
		assertNotEquals(t1, t2);
		
		//Check if null root works
		t1.setRoot(null);
		t1.setTemplateRoot(null);
		t2.setRoot(null);
		t2.setTemplateRoot(null);
		assertEquals(t1, t2);
		
		
		
	}
	
	@Test
	void testDeepCopy() throws ChildLIimitException
	{
		
		TemplateSection root = new TemplateSection("Vision", "Vision");
		TemplateSection node1 = new TemplateSection("Mission", "Mission");
		TemplateSection node2 = new TemplateSection("Objective", "Objective");
		TemplateSection node3 = new TemplateSection("Strategy", "Strategy");
		TemplateSection node4 = new TemplateSection("Action", "Action");
		
		root.addChild(node1);
		node1.addChild(node2);
		node2.addChild(node3);
		node3.addChild(node4);
		
		Template vmosa = new Template(root, root.deepCopy());
		Template template = vmosa.deepCopy();
		assertEquals(vmosa, template);
		
		
	}
	
}
