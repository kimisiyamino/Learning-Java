import java.util.ArrayList;

public class DotCom {
	// МАССИВ для хранения числа ячеек
	//int[] locationCells;
	
	private ArrayList<String> locationCells;
	private String name;
	
	// ПЕРЕМЕННАЯ для хранения количества попаданий
	//int numOfHits = 0;
	
	// СЕТТЕР принимающий массив, хранящий число ячеек
							// ПОЛУЧАЕМ
	//public void setLocationCells(int[] locs)
	public void setLocationCells(ArrayList<String> loc){
		// ПРИСВАИВАЕМ
		locationCells = loc;
	}
	
	public void setName(String n){
		name = n;
	}
	
	// МЕТОД принимающий ход пользователя, проверяет и возвращает результат
								// ПОЛУЧАЕМ ХодПользователя
	public String checkYourself(String userInput){
		// ПРЕОБРАЗУЕМ ХодПользователя
		//int guess = Integer.parseInt(stringGuess);
		
		// Результат по умолчанию
		String result = "Мимо";

		/*
		// ПОВТОРЯЕМ // СРАВНИВАЕМ ХодПользователя с Ячейками
		for	(int cell : locationCells){
			if (guess == cell){
				result = "Попал";
				numOfHits++;
				break;
			}
		}
		// СРАВНИВАЕМ число попаданий с количеством ячеек противника
		if (numOfHits == locationCells.length){
			result = "Потопил";
		}*/
		
		int index = locationCells.indexOf(userInput); // Проверяем индекс
		if(index >= 0){
			locationCells.remove(index);
			if(locationCells.isEmpty()){
				result = "Потопил";
				System.out.println("Вы потопили " + name);
			}
			else {
				result = "Попал";
			}
			
		}
		
		// ИНАЧЕ
		//System.out.println(result);
		return result;
	}
}