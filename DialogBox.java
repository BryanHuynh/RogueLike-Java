import java.util.ArrayList;

public class DialogBox {
	TextWindow tw;
	String str = "text";

	public DialogBox(TextWindow tw){
		this.tw = tw;
	}


	public void render(){
		String[] words = str.split(" ");
		ArrayList<String> lines = new ArrayList<String>();
		String bar = "-----------------------------------------------------";
		//System.out.println(bar.length());
		String sentence = "";


		tw.append(bar + "\n");
		for(String word: words){
			if((sentence +" " + word).length() < bar.length()){
				sentence += " "+  word;
				tw.append(" "+word);
			}else{
				tw.append("\n");
				lines.add(sentence);
				sentence = word;
			}
		}
		tw.append("\n");

		tw.append(bar + "\n");
	}

	public void renderToConsole(){
		String[] words = str.split(" ");
		ArrayList<String> lines = new ArrayList<String>();
		String bar = "-----------------------------------------------------";
		String sentence = "";

		System.out.println(bar);
		for(String word: words){
			if((sentence +" " + word).length() < bar.length()){
				sentence += " "+  word;
				System.out.print(" "+word);
			}else{
				System.out.println();
				lines.add(sentence);
				sentence = word;
			}
		}

		System.out.println();
		System.out.println(bar);
	}
}
