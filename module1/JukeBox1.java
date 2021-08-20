import java.util.*;
import java.io.*;

public class JukeBox1 {
	ArrayList<Song> songList = new ArrayList<Song>();
	

	public void go(){
		getSongs();
		System.out.println(songList);
	//	Collections.sort(songList);
		
		TitleCompare titleCompare = new TitleCompare();
		Collections.sort(songList, titleCompare);
		Collections.sort(songList, new Comparator<Song>(){
			public int compare(Song one, Song two){
				return one.getArtist().compareTo(two.getArtist());
		}
			
		});
		
		System.out.println(songList);
		System.exit(0);
	}
	
	public void getSongs(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("SongList.txt")));
			String line = null;
			while ((line = reader.readLine()) != null){
				addSong(line);
			}
		}catch(Exception ex){	ex.printStackTrace();}
	}
	
	public void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
	
	public static void main(String[] args){
		new JukeBox1().go();
	}
	
	class TitleCompare implements Comparator<Song>{
		public int compare(Song one, Song two){
			return one.getTitle().compareTo(two.getTitle());
		}
	}
}


class Song{
	String title;
	String artist;
	String rating;
	String bmp;
	
	Song(String title, String artist, String rating, String bmp){
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.bmp = bmp;
	}
	
	public String getTitle(){
		return title;
	}
	public String getArtist(){
		return artist;
	}
	public String getRating(){
		return rating;
	}
	public String getBmp(){
		return bmp;
	}
	
	@Override
	public String toString(){
		return artist;
	}
}




/* version Comparable<T> 
class Song implements Comparable<Song>{
	String title;
	String artist;
	String rating;
	String bmp;
	
	@Override
	public int compareTo(Song s){
		return title.compareTo(s.getTitle());
	}
	
	Song(String title, String artist, String rating, String bmp){
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.bmp = bmp;
	}
	
	public String getTitle(){
		return title;
	}
	public String getArtist(){
		return artist;
	}
	public String getRating(){
		return rating;
	}
	public String getBmp(){
		return bmp;
	}
	
	@Override
	public String toString(){
		return title;
	}
}*/
