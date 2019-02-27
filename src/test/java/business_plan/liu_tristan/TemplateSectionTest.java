package business_plan.liu_tristan;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemplateSectionTest
{
	static void testConstruct()
	{
		TemplateSection section1 = new TemplateSection("Mission", "Mission 1");
		assert section1.category == "Mission";
		assert section1.name == "Mission 1";
		assert section1.childLimit == 1;
		
		TemplateSection section2 = new TemplateSection("Objective", "Objective 1", 5);
		assert section2.category == "Objective";
		assert section2.name == "Objective 1";
		assert section2.childLimit == 5;
	}
	
	static void testEquals()
	{
		TemplateSection section1 = new TemplateSection("Vision", "Vision", 1);
		TemplateSection section2 = new TemplateSection("Mission", "Mission 1", 1);
		TemplateSection section3 = new TemplateSection("Mission", "Mission 2", 3);
		TemplateSection section4 = new TemplateSection("Objective", "Objective 1", 5);
		TemplateSection section5 = new TemplateSection("Objective", "Objective 1", 5);
		TemplateSection section6 = new TemplateSection("Objective", "Objective 3", 7);
		
		assert section1.equals(section2) == false;
		assert section2.equals(section3) == false;
		assert section4.equals(section5) == true;
		assert section5.equals(section6) == false;
		
		section6.setName("Objective 1");
		section6.setChildLimit(5);
		assert section6.equals(section5) == true;
		assert section4.equals(section6) == true;
	}
	
	static void testDeepCopy()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		TemplateSection section2 = section1.deepCopy();
		assert section1.equals(section2) == true;
	}
	
	static void testContent()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		assert section1.contents.size() == 0;
		Text c = new Text("hello");
		section1.addContent(c);
		assert section1.contents.size() == 1;
		try {
			section1.deleteContent(c);
		} catch (ContentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert section1.contents.size() == 0;
	}
	
	static void testChild()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		assert section1.children.size() == 0;
		TemplateSection c = new TemplateSection("Action Plan", "Action Plan 1");
		try {
			section1.addChild(c);
		} catch (ChildLIimitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert section1.children.size() == 1;
		try {
			section1.deleteChild(c);
		} catch (ChildNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert section1.children.size() == 0;
	}
	
	static void testCategoryName()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		assert section1.getCategory() == "Objective";
		section1.setCategory("Mission");
		assert section1.getCategory() == "Mission";
		assert section1.getName() == "Objective 1";
		section1.setName("Mission");
		assert section1.getName() == "Mission";
	}
	
	static void testParent()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		assert section1.getParent() == null;
		TemplateSection section2 = new TemplateSection("Objective", "Objective 1");
		section1.setParent(section2);
		assert section1.getParent() == section2;
	}
	
	static void testChildLimit()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		assert section1.getChildLimit() == 1;
		section1.setChildLimit(2);
		assert section1.getChildLimit() == 2;
	}
	
	static void testGetContents()
	{
		TemplateSection section1 = new TemplateSection("Objective", "Objective 1");
		assert section1.getContents().size() == 0;
		Text c = new Text("hello");
		section1.addContent(c);
		assert section1.getContents().size() == 1;
	}
	
	public static void main(String[] args)
	{
		testConstruct();
		testEquals();
		testDeepCopy();
		testContent();
		testChild();
		testCategoryName();
		testParent();
		testChildLimit();
		testGetContents();
	}
}
