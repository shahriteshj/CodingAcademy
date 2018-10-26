import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.format.*;
public class TestDates{
	public static void main(String arg[]){
		
		
		LocalDate today = LocalDate.now();
		System.out.println("Today is "+today);
		LocalDate dob = LocalDate.of(1984,Month.MARCH,15);
		System.out.println("My Birthdate : "+dob);
		
		YearMonth today2 = YearMonth.now();
		System.out.println("Current Month: "+today2);
		
		MonthDay day = MonthDay.now();
		System.out.println("Current day: "+day);		
		
		System.out.print("Is it Leap year?");
		System.out.println(Year.of(2004).isLeap());
		
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Now its "+time);
		
		DateTimeFormatter format = 
			DateTimeFormatter.ofPattern("MMM d yyyy");
		String d = format.format(today);
		System.out.println(d);
	}
}