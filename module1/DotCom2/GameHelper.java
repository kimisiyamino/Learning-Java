import java.io.*; // BufferedReader
import java.util.*; // ArrayList

public class GameHelper {
	
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[49];
	private int comCount = 0;
	
	////////// USER INPUT //////////
	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.print(prompt + " ");
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0) return null;
		} catch (IOException e){
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}
	
	public ArrayList<String> placeDotCom(int comSize){
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphacoords = new String[comSize];				// хранит координаты типа f6
		String temp = null;										// Временная строка для конкатенации
		int[] coords = new int[comSize];							// Координаты текущего противника
		int attempts = 0;										// Счетчик текущих попыток
		boolean succes = false;									// Нашли подходящее местоположение?
		int location = 0;										// Текущее начальное положение
		
		comCount++;
		int incr = 1;
		if((comCount % 2) == 1) {
			incr = gridLength;
		}
		
		while(!succes & attempts++ < 200){
			location = (int)(Math.random() * gridSize);
			// System.out.println("Пробуем " +  location);
			int x = 0;
			succes = true;
			
			while (succes && x < comSize){
				
				if (grid[location] == 0){
					coords[x++] = location;
					location += incr;
					
					if (location >= gridSize){
						succes = false;
					}
					if (x > 0 && (location % gridLength == 0)){
						succes = false;
					}
				}else {
					// System.out.println("Используется " +  location);
					succes = false;
				}	
			}	
		}
		
		int x = 0;
		int row = 0;
		int column = 0;
		
		while (x < comSize){
			grid [coords [x]] = 1;
			row = (int)(coords[x] / gridLength);
			column = coords[x] % gridLength;
			temp = String.valueOf(alphabet.charAt(column));
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			// System.out.println("coord X " + x + " = " + alphaCells.get(x-1));
		}
		return alphaCells;
	}
}
	