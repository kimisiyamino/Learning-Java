public class BeerSong{    
    public static void main (String args[]){
		int beerNum = 99;
		String word = "бутылок (бутылки)";
	
		while (beerNum > 0){
			if (beerNum == 11 || beerNum == 12 || beerNum == 13 || beerNum == 14)
				word = "бутылок";
			else if ((beerNum%10) == 1)
				word = "бутылка";
			else if ((beerNum%10) == 2 || (beerNum%10) == 3 || (beerNum%10) == 4)
				word = "бутылки";
			else 
				word = "бутылок";
			
		
			System.out.println(beerNum + " " + word  + " пива на стене");
	        System.out.println(beerNum + " " + word  + " пива!");
	        System.out.println("Возьми одну, пусти по кругу");
	        beerNum-=1;
            System.out.println(beerNum + " " + word  + " пива на стене!\n");
			if (beerNum == 0)
				System.out.println("Нет бутылок пива на стене");
                             
		
		
		}
    }
}