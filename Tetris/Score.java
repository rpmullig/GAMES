import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

import java.util.*;

class Score {
	String name;
	
	String askName() {
		this.name = JOptionPane.showInputDialog("What is your name?");
		return name; 
	}

	Score() {} // empty object constructor
	
   int lines = 0;
   void addToScore(int a) {
	   this.lines = this.lines + a; 
	   // System.out.println(lines); works properly and keeps track of lines
   }
  
  
   //  private Map<String, Integer> ordered;
   //void order() throws FileNotFoundException ;   
   //Scanner in = new Scanner(new File(filename));
   // this.ordered = new HashMap<String, Integer>();
   
   int count;
   String players;
   Score (String name, int count) {
	   this.count = count;
	   this.players = name;
   }
   String playerName() {
	   return this.players;
   }
   int playerScore() {
	   return this.count;
   }
   
   public static void answer(Score me) throws FileNotFoundException {
	   
   ArrayList<Score> list;
   list = new ArrayList<Score>();
   String filename = "scores.txt";
   
   Scanner in = new Scanner(new File(filename));
   
   while(in.hasNextLine()) {
	   String line = in.nextLine();
	   Scanner tokens = new Scanner(line);
	   Score player = new Score(tokens.next(), tokens.nextInt());
	   list.add(player);
    }
	
   File scoreList = new File(filename);
   FileOutputStream fileStream = new FileOutputStream(scoreList, false);
   String stuff = null;
   for (int i = 0; i < list.size(); i++) {
	   if ( list.get(i).playerScore() > me.playerScore() ) {
		   
		   stuff = stuff + "\n" + list.get(i).askName() + " " + list.get(i).playerScore();
	   }
	   //else if (list.get(i).playerName().compareTo( me.playerName() ))
		//		   {
			   
		//		   	}
   //}
		//FileOutputStream.write(stuff)
  }
   
 }
   
  
   
}