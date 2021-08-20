import java.io.IOException;

public class CanvasGameOfLife{
	int N = 50;
	int M = 100;
	char dote = '*';
	char blank = ' ';

	int[][] fieldBool;
	int newfieldBool[][];
	
	int Life;
	
	int count = 0;
	
	public static void main(String[] args) {
		new CanvasGameOfLife().go();
	}
	
	public void go(){
	
		fieldBool = new int[N][M];
		startGeneration();
		
		nextStep();
	}
	
	public void startGeneration(){
		for(int i = 0; i < N; i++){
			System.out.print("\n");
			for(int j = 0; j < M; j++){
				Life = (int)(Math.random()*2);
				if(Life == 1){
					System.out.print(dote);
					fieldBool[i][j] = Life;
				}else{
					System.out.print(blank);
					fieldBool[i][j] = Life;
				}
			}
		}	
	}
	
	public void nextStep(){
		//int count = neighborCount(0,0);
		newfieldBool = new int[N][M];
		while(count<=1000){
			count++;
			
			
			//System.out.print("\033[H\033[2J");
			//System.out.flush();	
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				int count = neighborCount(i,j);
				if(fieldBool[i][j] == 1 && (count < 2 || count > 3)) {newfieldBool[i][j] = 0;}
				if(fieldBool[i][j] == 1 && (count == 2 || count == 3)) {newfieldBool[i][j] = 1;}
				if(fieldBool[i][j] == 0 && (count == 3)) {newfieldBool[i][j] = 1;}
				//System.out.println(i + " " + j + " " + count);
			}
		}
		
		// print
			try{
				Thread.sleep(100);
				for(int i = 0; i < N; i++){
					System.out.print("\n");
					for(int j = 0; j < M; j++){
						if(newfieldBool[i][j] == 1){
							System.out.print(dote);
							fieldBool[i][j] = newfieldBool[i][j];
						}else{
							System.out.print(blank);
							fieldBool[i][j] = newfieldBool[i][j];
						}
					}
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		//System.out.println(count);
	}
	
	public int neighborCount(int i, int j){
		int count = 0;
		for(int x = i - 1; x < i + 2; x++){
			for(int y = j - 1; y < j + 2; y++){
				if(x < 0 || y < 0 || y > M - 1 || x > N - 1){ continue; }		// Уход за границы
				if(x == i && y == j){ continue; }								// Текущая ячейка
				if(fieldBool[x][y] == 1){ count++; }							// Найденный живой сосед
			}	
		}
		return count;
	}
}