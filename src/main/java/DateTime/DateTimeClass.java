package DateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * Demonstrates Java DateTime API usage.
 */
public class DateTimeClass {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate customDate = LocalDate.of(2018, 1, 1);
		
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getMonthValue());
		System.out.println(now.getYear());
		
		System.out.println("Current time in India " + ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
		
		Set<String> zones = ZoneId.getAvailableZoneIds();
		zones.forEach(System.out::println);
		
		// Period between dates
		LocalDate now3 = LocalDate.now();
		LocalDate now2 = LocalDate.of(2023, 6, 12);
		
		Period period = Period.between(now2, now3);
		System.out.println(period);
		System.out.println(period.getYears() + " and " + period.getMonths() + " and " + period.getDays() + ".");
		
		// Parse date
		String date = "12/06/2023";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateTime = LocalDate.parse(date, formatter);
		System.out.println(dateTime);
		
	}
}
