
/* Filename: DiceGame *
* Created by: Robert Mulligan*
* Last Modified by: Robert Mulligan *
*/

/* This program runs a dicegame
*  The Player will enter his/her name and play against the PC
*  The first person to reach a score greater than or equal to 200, wins
*/ 

import java.util.*;
import javax.swing.JOptionPane;

public class DiceGame {
  public static void main( String[] args) {
    
    Dice d = new Dice();

    System.out.println("Welcome to the Dice Game simulator!");
    System.out.println("You vs. the PC to see who can obatin a score of 200 first");
    
    
    Player me = new Player(JOptionPane.showInputDialog("What is your name?") );
    Player pc = new Player( "Computer" );
    int my_roll, pc_roll, roll_count;
    roll_count = 1; 
    while (!me.isWinner() && !pc.isWinner()) {
    System.out.println();
    System.out.println("----- Roll Count: " + roll_count + " -----");
    roll_count++;
    
    my_roll = d.Roll();
    pc_roll = d.Roll();
    System.out.println( me.print() + " has a score of " + me.score() + " and rolled " + my_roll);
    System.out.println( pc.print() + " has a score of " + pc.score() + " and rolled " + pc_roll);
    me.add(my_roll);
    pc.add(pc_roll);
    System.out.println("--------------------------");
    }
    System.out.println();
    System.out.println("##########################");  
    System.out.println("########Game Over#########");    
    System.out.print( me.print() + " with a score of " + me.score() + " ");
      if(me.isWinner()){System.out.print("has won!\n");} else {System.out.print("lost :<\n");}
    System.out.print( pc.print() + " with a score of " + pc.score() + " ");
      if(pc.isWinner()){System.out.print("has won!\n");} else {System.out.print("lost :<\n");}    
    System.out.println("##########################");   
    
    ArrayList<Player> players = new ArrayList<Player>();
    for( int i = 0; i < args.length; i++ ) {
      players.add( new Player( args[i] ) );
      Game a = new Game( players ); 
      a.start();
    } 
  }
} //

class Dice {
  
  void Dice() { }
    
   // not needed, as I changed the way I did the solution
  // private int[] faces = new { 1, 2, 3, 4, 5, 6 };
  
  public int Roll() {
    // return faces[ Math.round((Math.Random() * 5) + 1) ];
      return (int) ( Math.random() * 5 + 1 );
  }
}

class Player{
  
  private String name;
  private boolean winner;
    
  private int score = 0;
  // private int[] dicevalues;
  private ArrayList<Integer> diceValues = new ArrayList<Integer>();
    
  
  // added return statement to constrcuter
  Player ( String name ) {
    this.name = name; 
  }    
  
  String print () {
    return name;  
  }
  
  void add( int num ) {
    this.score = this.score + num;
    
    this.diceValues.add(num);
  }
  
  String report() {
   return this.diceValues.toString(); 
  }
  int score() {
      return this.score;
  }
  
    boolean isWinner() {
      // mine wasn't wrong, I just shortened it like this
      return ( winner = ( this.score >= 200 ) ); 
    }
}


class Game {
  
  private ArrayList<Player> players = new ArrayList<Player>();

  Game ( ArrayList<Player> players ) {
    // I had to add this in.. originally I did it with arrays not arrayList
    this.players = players;
  }
  void start() {
    Dice d = new Dice();
    boolean bool = false;
    
     while( !bool ) {
      for ( int i = 0; i < this.players.size() ; i++) {
        this.players.get( i ).add( d.Roll() );
        System.out.println( this.players.get(i).print() 
                             + ": " 
                             + this.players.get(i).report()
                             + " "
                             + this.players.get(i).score() 
                             +" "
                             + this.players.get( i ).isWinner() ); 
 
       bool = ( this.players.get(i).isWinner() ) ;
      }
     } 
  }
}
  