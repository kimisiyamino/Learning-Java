public class SimpleDotCom {
	// МАССИВ для хранения числа ячеек
	int[] locationCells;
	// ПЕРЕМЕННАЯ для хранения количества попаданий
	int numOfHits = 0;
	
	// СЕТТЕР принимающий массив, хранящий число ячеек
							// ПОЛУЧАЕМ
	public void setLocationCells(int[] locs){
		// ПРИСВАИВАЕМ
		locationCells = locs;
	}
	
	// МЕТОД принимающий ход пользователя, проверяет и возвращает результат
								// ПОЛУЧАЕМ ХодПользователя
	public String checkYourself(String stringGuess){
		// ПРЕОБРАЗУЕМ ХодПользователя
		int guess = Integer.parseInt(stringGuess);
		// Результат по умолчанию
		String result = "Мимо";
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
		}
		// ИНАЧЕ
		System.out.println(result);
		return result;
	}
}