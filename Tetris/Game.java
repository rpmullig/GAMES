import javax.swing.*; 

class Game extends JFrame {
  Game() {
    World world = new World(); 
    this.add(world); 
    world.start(); 
    this.addKeyListener(world); 
    this.setSize(200, 400);
    this.setVisible(true); 
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
  }
  public static void main(String[] args) {
    Game game = new Game();  
  }
}