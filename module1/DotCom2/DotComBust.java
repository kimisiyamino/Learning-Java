import java.util.ArrayList;

public class DotComBust{
	
	private GameHelper helper = new GameHelper();					//  Создаём ОБЪЕКТ 
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();	// Создаём ARRAYLIST для хранения противников
	private int numOfGuesses = 0;									// Создаём ПЕРЕМЕННУЮ Количество ходов
	
		//////// SETUP //////////
	private void setUpGame(){	
									// Создаём трёх противников и даём им индивидуальные имена
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
									// Добавляем в ARRAYLIST наших противников
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
									// Выводим инструкции для пользователя
		System.out.println("Ваша цель - поттопить три сайта.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Попытайтесь потопить их за минимальное количество ходов.");
									// Проходим по нашему ARRAYLIST
		for(DotCom dotComToSet : dotComList){
			ArrayList<String> newLocation = helper.placeDotCom(3); // Запрашиваем у "помощника" координаты для 1 противника
			dotComToSet.setLocationCells(newLocation);			 //  Ставим полученные координаты на поле
		}		
	}
		//////// START //////////
	private void startPlaying(){
		while(!dotComList.isEmpty()){								 	 // ПОКА наш ARRAYLIST с кораблями противника не пуст, то
			String userGuess = helper.getUserInput("Сделайте ход: ");	 // Пользовательский ход
			checkUserGuess(userGuess);									 // Проверяем ход пользователя
		}
		finishGame();												// Вызов МЕТОДА конца игры
	}
		//////// CHECK GUESS //////////
	private void checkUserGuess(String userGuess){
		numOfGuesses++;			// Количство попыток ++
		String result = "Мимо";	// Результат хода пользователя = Default (Значение по умолчанию "Мимо")
		
									// Проходим по нашему ARRAYLIST
		for (DotCom dotComToTest : dotComList){
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("Попал")){
				break;
			}
			if (result.equals("Потопил")){
				dotComList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result); // Возвращаем "Мимо"
	}
	//////// FINISH //////////
	private void finishGame(){
		System.out.println("Все сайты ушли ко дну!");
		
		if(numOfGuesses <= 18){
			System.out.println("GG WP: " + numOfGuesses);
		} else {
			System.out.println("JUST NOOB: " + numOfGuesses);
		}	
		
	}
	//////// MAIN //////////
	public static void main (String[] args){
		DotComBust game = new DotComBust();	// Создаём ОБЪЕКТ игры
		game.setUpGame();						// SETUP
		game.startPlaying();					// START
	}
}