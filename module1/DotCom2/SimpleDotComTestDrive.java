import java.util.Scanner;

public class SimpleDotComTestDrive {
	public static void main(String[] args){
		Scanner UserGuessObj = new Scanner(System.in);
		SimpleDotCom dot = new SimpleDotCom();				// Создаем ОБЪЕКТ игры
		int numOfGuesses = 0;							// Ходы пользователя
		
		int X = (int)(Math.random()*5);					// Создаем рандомное местоположение противника
		int[] locations = {X,X+1,X+2};					// Создаем МАССИВ местоположение противника
		String result = "Мимо";
		
		dot.setLocationCells(locations);					// Устанавливаем противника в объект SimpleDotCOm
		
		while(result != "Потопил"){
			
			String userGuess = UserGuessObj.nextLine();
			 						// Пользовательский ход
			result = dot.checkYourself(userGuess);				// Проверяем ход через объект SimpleDotCOm
			numOfGuesses++;
		}
		System.out.println("Попытки: " + numOfGuesses);
	}
	
}