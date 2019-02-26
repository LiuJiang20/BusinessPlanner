package business_plan.liu_tristan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemplateSectionTest
{
	void testConstruct()
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
	
	void testEquals()
	{
		TemplateSection section1 = new TemplateSection("Vision", "Vision", 1);
		TemplateSection section2 = new TemplateSection("Mission", "Mission 1", 1);
		TemplateSection section3 = new TemplateSection("Mission", "Mission 2", 3);
		TemplateSection section4 = new TemplateSection("Objective", "Objective 1", 5);
		TemplateSection section5 = new TemplateSection("Objective", "Objective 1", 5);
		TemplateSection section6 = new TemplateSection("Objective", "Objective 3", 7);
		
		assert section1.equals(section2) == false;
		assert section2.equals(section3) == False;
		assert section4.equals(section5) == True;
		assert section5.equals(section6) == False;
		
		section6.setName("Objective 1");
		section6.setChildLimit(5);
		assert section6.equals(section5) == True;
		assert section4.equals(section6) == True;
	}

//	@Test
//	void test()
//	{
//		fail("Not yet implemented");
//	}
//	
//	void testEquals()
//	{
//		//Initialize a series of sections
//		TemplateSection section1 = new TemplateSection("Vision", "Vision");
//		TemplateSection section2 = new TemplateSection("Mission", "Mission");
//		TemplateSection child = new TemplateSection("Child", "Child");
//		
//		section1.setChildLimit(1);
//		section2.setChildLimit(1);
//		
//		section1.addChild(child);
//		section2.addChild(child);
//		
//		assertEquals(section1, section1);
//		assertNotEquals(section1, section2);
//		
//		section2.setCategory("Vision");
//		assertNotEquals(section1, section2);
//		
//		section2.setName("Vision");
//		assertNotEquals(section1, section2);
//		
//		section2.setChildLimit(1);
//		assertEquals(section1, section2);
//		
//		TemplateSection child2 = new TemplateSection("Child2", "Child2");
//		section2.deleteChild("Child");
//		section2.addChild(child2);
//		assertNotEquals(section1, section2);
//		
//		// more test needed for content
//		
//	}
//	@Test
//	void testDeepCopy()
//	{
//		TemplateSection section1 = new TemplateSection("Vision", "Vision");
//		TemplateSection section2 = new TemplateSection("Mission", "Mission");
//		TemplateSection section3 = new TemplateSection("Objective", "Objective");
//		TemplateSection section4 = new TemplateSection("Strategy", "Strategy");
//		
//		section1.setChildLimit(1);
//		section2.setChildLimit(1);
//		section3.setChildLimit(5);
//		section4.setChildLimit(1);
//		
//		section1.addChild(section2);
//		section2.addChild(section3);
//		section3.addChild(section4);
//		
//		TemplateSection sections[] = {section1,section2,section3,section4};
//		for(TemplateSection section : sections)
//		{
//			TemplateSection deepCopy = section.deepCopy();
//			assertEquals(section, deepCopy);
//			assert section != deepCopy;
//		}
//		
//		
//		
//	}
}
