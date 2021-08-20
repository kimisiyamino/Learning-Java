import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class CalendarTest02{
	final static long MILLIS_IN_YEAR = 31_536_000_000L;
	final static long MILLIS_IN_DAY = 86_400_000L;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Calendar dateNow = Calendar.getInstance();
		Calendar dateBorn = Calendar.getInstance();
		
		System.out.print("Введите год рождения: ");
		int userYear = scanner.nextInt();
		System.out.print("Введите месяц рождения: ");
		int userMou =(scanner.nextInt()-1);
		System.out.print("Введите День рождения: ");
		int userDay = scanner.nextInt();
		System.out.print("Введите Час рождения: ");
		int userHour = scanner.nextInt();
		System.out.print("Введите Минуты рождения: ");
		int userMin = scanner.nextInt();
		
		System.out.printf("Ваша дата рождения: %d %d %d г., %02d:%02d%n", userDay, userMou, userYear, userHour, userMin);
		
		
		dateBorn.set(userYear, userMou, userDay, userHour, userMin);
		
		long millisLife = (dateNow.getTimeInMillis() - dateBorn.getTimeInMillis());
		
		long timeSec 	= millisLife / 1000 % 60;
		long timeMin 	= millisLife / (60*1000) % 60;
		long timeHour 	= millisLife / (60*60*1000) % 24;
		long timeDay	= millisLife / MILLIS_IN_DAY % 365;
		long timeYear 	= millisLife / MILLIS_IN_YEAR;
		
		long timeAllDay	= millisLife / MILLIS_IN_DAY;
		
		System.out.printf("Вы живёте: %d лет, %d дней, %d:%02d:%02d%n", timeYear, timeDay, timeHour, timeMin, timeSec);
		System.out.printf("Всего дней в вашей жизни: %d", timeAllDay);
	
	}
}