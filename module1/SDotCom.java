import java.util.Scanner;
import java.util.ArrayList;

public class SDotCom {
	public static void main (String[] args){
		SimpleMainMenu MainMenu = new SimpleMainMenu();
		MainMenu.setMainMenu(true);
		ArrayList<String> locs = new ArrayList<String>();
		String l1 = new String();
		String l2 = new String();
		String l3 = new String();
		
		while(MainMenu.getMainMenu() == true){
			MainMenu.setGame(true);
			MainMenu.setExit(true);
			
			// Создание объекта игры
			DotCom dot = new DotCom();
			// Создание объекта пользовательского ввода
			Scanner UserGuessObj = new Scanner(System.in);
			
			// Количество ходов (всего)
			int numOfGuesses = 0;
			
			// Создание корабля противника
			String firstLocation = (int)(Math.random()*5);
			l1.add(firstLocation);
			l2.add(firstLocation+1);
			l3.add(firstLocation+2);
			
			// Устанавливаем корабль на поле
			dot.setLocationCells(locs);
			
			while(MainMenu.getGame() == true){
				// Пользовательский ввод, Ход пользователя
				System.out.print("Ваш ход: ");
				
				String userGuess = UserGuessObj.nextLine();
				// Проверяем ход, куда попал пользователь
				String result = dot.checkYourself(userGuess);
				if(result != "Ошибка ввода"){
					numOfGuesses++;
				}
				if(result == "потопил"){
					System.out.println("Вы выйграли! Количество ходов: " + numOfGuesses);
					MainMenu.setGame(false);
				}
			}
			
			while(MainMenu.getExit() == true){			
				System.out.println("Начать сначала? 1 - Да, 2 - Нет");
				// Принимаем пользовательский ввод
				String userGuess2 = UserGuessObj.nextLine();
				// Проверяем пользовательский ввод Сравниваем : НЕТ
				if(MainMenu.checkMenu(userGuess2) == 2){
					System.out.println("До новых встреч!");
					MainMenu.setMainMenu(false);
					break;
					}
				// Сравниваем : ДА
				else if(MainMenu.checkMenu(userGuess2) == 1){
					MainMenu.setExit(false);
				}
				if(MainMenu.checkMenu(userGuess2) == 0){
					System.out.println("Ошибка ввода, повторите попытку");
				}
			}
		}
	}
}
class DotCom{
	//  Корабль противника (Массив из 3-х значений)
	ArrayList<String> locationCells;			
	// Количество попаданий по кораблю (Переменная)
	//int numOfHits = 0;
	
	// Установление корбаля противника на поле (Метод-сеттер)
	public void setLocationCells(ArrayList<String> locs){
		locationCells = locs;
	}
	// Проверяем пользовательский ввод (Метод)
	public String checkYourself(String stringGuess){
		// Преобразуем ввод в число понятное системе
		int guess = Integer.parseInt(stringGuess);
		// Результат = Default
		String result = "Мимо";
		// Проверяем пользовательский ввод на корректнность ввода
		if (guess>=0 && guess<=7){
			// Проверяем каждый элемен противника корабля с пользовательским вводом
			/*for(int cell : locationCells){
				// Если пользовательское число = числу противника корабля, то КоличествоПопаданий++, Результат = Попал
				if (guess == cell){
					result = "Попал";
					numOfHits++;
					break;
				}
			}*/
			int index = locationCells.indexOf(guess);
			if (index >= 0){
				locationCells.remove(index);
				if(locationCells.isEmpty()){
					result = "потопил";
				}else {result = "Попал";}
			}
				
			
			
			
			
			
			// Если КоличествоПопаданий = ДлиннеКорабля противника, то Результат = Потопил
			/*if (numOfHits == locationCells.length){
				result = "потопил";
			}	*/
		} 
		else {result = "Ошибка ввода";}
			// Показываем пользователю Результат
			System.out.println(result);
			// Если не одно из условий не выполнено, возвращаем Результат = Default
			return result;
		
	}
	
}
class SimpleMainMenu{
	private boolean Game = true;
	private boolean MainMenu = true;
	private boolean Exit = true;
	
	public void setGame(boolean sGame){
		Game = sGame;
	}
	public void setMainMenu(boolean sMainMenu){
		MainMenu = sMainMenu;
	}
	public void setExit(boolean sExit){
		Exit = sExit;
	}
	
	public boolean getGame(){
		return Game;
	}
	public boolean getMainMenu(){
		return MainMenu;
	}
	public boolean getExit(){
		return Exit;
	}
	
	
	// Проверяем пользовательский ввод (для конца игрыМетод)
	public int checkMenu(String stringGuess){
		int guess = Integer.parseInt(stringGuess);
		if (guess==1){ return 1;}
		else if (guess==2){ return 2;}
			else{ return 0;}
	}
	
	
}
