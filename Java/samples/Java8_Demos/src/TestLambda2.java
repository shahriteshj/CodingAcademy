import java.util.*;
import java.util.function.*;
class Person{
	private String firstName, lastName;
	
	public Person(){}
	public Person(String fn,String ln){
		firstName = fn;
		lastName = ln;
	}
	
	public String toString(){
		return firstName + " "+lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
}
@FunctionalInterface
interface CompareIt {
		public boolean compare(Person p1, Person p2);
}


public class TestLambda2{
	public static void main(String arg[]){
		List<Person> people  = new ArrayList<Person>();
		people.add(new Person("Pareeniti","Chopra"));
		people.add(new Person("Priyanka","Chopra"));
		people.add(new Person("Alia","Bhatt"));
		people.add(new Person("Katrina","Kaif"));
		people.add(new Person("Sai","Tamhankar"));
		people.add(new Person("Sonakshi","Sinha"));		
		CompareIt c = (p1,p2)->(p1.getFirstName().compareTo(p2.getFirstName())>=1?true:false);
		if(c.compare(people.get(0),people.get(1)))
			System.out.println("First is better");
			
		people.forEach(System.out::println);
		//make name uppercase
		people.stream().map(p -> p.getFirstName().toUpperCase()).forEach(System.out::println);


		System.out.println("Filtering ");
		people.stream().filter(p->p.getFirstName().startsWith("A")).forEach(System.out::println);
		final Predicate<Person> prd = p -> p.getLastName().equalsIgnoreCase("chopra");
		
		long n=	people.stream().filter(prd).count();
		System.out.println(n);
	}

}
