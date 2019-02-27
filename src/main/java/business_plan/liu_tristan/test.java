package business_plan.liu_tristan;

public class test
{

	public static void main(String[] args) throws ChildLIimitException, NullChildException, NoParentException
	{
		TemplateSection tSection = new TemplateSection("", "");
		TemplateSection node = new TemplateSection("","");
		tSection.addChild(node);
		Template seciton = new Template(tSection, tSection.deepCopy());
		seciton.addBranch(tSection);
	}
	
}
