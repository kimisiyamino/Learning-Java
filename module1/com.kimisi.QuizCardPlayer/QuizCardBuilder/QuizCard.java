package QuizCardBuilder;


public class QuizCard{
	public QuizCard(String a, String q){
		question = q;
		answer = a;
	}
	
	String question;
	String answer;
	
	public String getQuestion(){
		return question;
	}
	
	public String getAnswer(){
		return answer;
	}
}