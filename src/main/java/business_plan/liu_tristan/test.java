package business_plan.liu_tristan;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class test
{

	public static void main(String[] args) throws ChildLIimitException, NullChildException, NoParentException
	{
		TemplateSection root = new TemplateSection("Vision", "Vision");
		TemplateSection node1 = new TemplateSection("Mission", "Mission",3);
		TemplateSection node2 = new TemplateSection("Objective", "Objective",3);
		TemplateSection node3 = new TemplateSection("Strategy", "Strategy",3);
		TemplateSection node4 = new TemplateSection("Action", "Action");
		
		root.addChild(node1);
		node1.addChild(node2);
		node2.addChild(node3);
		node3.addChild(node4);
	
		Template vmosa = new Template(root, root.deepCopy());
		vmosa.setUserTemplateName("VMOSA");
		vmosa.setDeveloperTemplateName("VMOSA");
		vmosa.save();
		Template template = Template.load("VMOSA.xml");
		assertEquals(vmosa, template);
		
		vmosa.addBranch(node2);
		vmosa.addBranch(node4);
		template = Template.load("VMOSA.xml");
		System.out.println(vmosa.equals(template));
	}
}
