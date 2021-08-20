import java.util.Calendar;
import java.util.Date;

public class CalendarTest01{
	public static void main(String[] args){
	//	Calendar calendar = new Calendar(); - ТАК НЕЛЬЗЯ
		//Date date 
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		calendar.set(1994, 8, 9, 17, 00);
		System.out.println(calendar.getTime());
		
		long day1 = calendar.getTimeInMillis();
		System.out.println(day1);
		System.out.println(calendar.get(calendar.DATE));
		
		Calendar born = Calendar.getInstance();
		born.set(1994, 8, 9, 17, 00);
		
		born.set(1994, 8, 9, 17, 00);
		
		Calendar now = Calendar.getInstance();
		
		final long millisInYear = 31536000000L;
		
		long now1 = now.getTimeInMillis();
		long born1 = born.getTimeInMillis();
		long ff = now1 - born1;
		System.out.printf("%d%n", ff);
		long timeSec = ff / 1000 % 60;
		long timeMin = ff / (60*1000) % 60;
		long timeHour = ff / (60*60*1000)		 % 24;	 //ff / (60*60*1000);
		long timeDay =  ff / (24*60*60*1000) % 30;
		//long timeMou =  ff / (30*24*60*60*1000) % 12;
		long timeYea =  (ff / (365*24*60*60*1000));
		 timeYea = ff / millisInYear;
		//System.out.printf("Вы живёте: %d лет, %d месяца, %d дней,  %d:%d:%d", timeYea, timeMou, timeDay, timeHour, timeMin, timeSec);
		System.out.printf("Вы живёте: %d лет,  %d:%d:%d", timeYea, timeHour, timeMin, timeSec);
		
		//now.setTimeInMillis(ff);
		
		//System.out.println(now.getTime());
		
		
		//calendar.set()
	}
}