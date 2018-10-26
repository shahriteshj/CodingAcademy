import java.lang.annotation.Repeatable;

@Repeatable(Authors.class)
@interface Author{
	String name();
}
@interface Authors {
	Author[] value();
}


public class TestAnnotations{
	@Author(name="Mahendra")
	@Author(name="Shinde")
	private String someVariable;


}
