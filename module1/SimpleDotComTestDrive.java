import java.util.Scanner;
import java.util.ArrayList;

public class SimpleDotComTestDrive {
	public static void main (String[] args){
		SimpleMainMenu MainMenu = new SimpleMainMenu();
		MainMenu.setMainMenu(true);
		ArrayList<String> locationsList = new ArrayList<String>();
		
		while(MainMenu.getMainMenu() == true){
			MainMenu.setGame(true);
			MainMenu.setExit(true);
			
			// Создание объекта игры
			SimpleDotCom dot = new SimpleDotCom();
			// Создание объекта пользовательского ввода
			Scanner UserGuessObj = new Scanner(System.in);
			
			// Количество ходов (всего)
			int numOfGuesses = 0;
			
			// Создание корабля противника
			int Location1 = (int)(Math.random()*5);
			int Location2 = Location1+1;
			int Location3 = Location1+2;
			String Location1s = Integer.toString(Location1);
			String Location2s = Integer.toString(Location2);
			String Location3s = Integer.toString(Location3);
			//int[] locations = {firstLocation,firstLocation+1,firstLocation+2};
			
			locationsList.add(Location1s);
			locationsList.add(Location2s);
			locationsList.add(Location3s);
			
			
								//System.out.println(locationsList);
			// Устанавливаем корабль на поле
			dot.setLocationCells(locationsList);
			
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
class SimpleDotCom{
	//  Корабль противника (Массив из 3-х значений)
	//int[] locationCells;	
	ArrayList<String> locationCells = new ArrayList<String>();	
	// Количество попаданий по кораблю (Переменная)
	int numOfHits = 0;
	
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
		// Проверяем пользовательский ввод на корректнность ввод
		
		if (guess>=0 && guess<=7){
			/*
			// Проверяем каждый элемен противника корабля с пользовательским вводом
			for(int cell : locationCells){
				// Если пользовательское число = числу противника корабля, то КоличествоПопаданий++, Результат = Попал
				if (guess == cell){
					result = "Попал";
					numOfHits++;
					break;
				}
			}
			// Если КоличествоПопаданий = ДлиннеКорабля противника, то Результат = Потопил
			if (numOfHits == locationCells.length){
				result = "потопил";
			}	
			*/
			/*
			int index = locationCells.indexOf(guess);
			System.out.println("index = " + index);
			if (index >= 0){
				locationCells.remove(index);
				if (locationCells.isEmpty()){
					result = "потопил";
				}
				else{
					result = "Попал";
				}
			}
			*/
			
			boolean indec = locationCells.contains(stringGuess);
			
										//	System.out.println("indec = " + indec);
			if (indec == true){
				locationCells.remove(locationCells.indexOf(stringGuess));
				if (locationCells.isEmpty()){
					result = "потопил";
				}
				else{
					result = "Попал";
				}
			}
			
			
			
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
