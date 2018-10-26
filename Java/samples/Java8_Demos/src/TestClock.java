import java.text.DateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

public class TestClock {

	public static void main(String[] args) {
		final Clock clock = Clock.systemUTC();
		System.out.println(clock.instant() +" Zone : "+clock.getZone());		
		System.out.println(clock.instant() +"Zone :"+ clock.getZone());
		
		
		Random rand = new Random();
		for(int i =0;i<3;i++){
			System.out.println(rand.ints(1,5,11).findFirst().getAsInt());
		}
		
		Optional<String> name = Optional.of("Mahendra");
		name = Optional.ofNullable("no name!");
		System.out.println(name.isPresent());
		System.out.println(name.get());
		//name = "Mahendra";
		
		LocalDate date = LocalDate.of(2016,2,24);
		System.out.println(date.minusYears(32));
	}

}
