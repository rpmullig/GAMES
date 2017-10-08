import java.awt.*; 

class TShape extends Shape {
  TShape(int row, int column, World world) {
    super(row, column, world); 
    this.color = new Color(204, 204, 102);
    this.rotations = new int[][][] {
      { { 1, 1, 1}, 
        { 0, 1, 0}, 
        { 0, 0, 0}}, //-------------------
      { { 0, 0, 1}, 
        { 0, 1, 1}, 
        { 0, 0, 1}}, //-------------------
      { { 0, 0, 0}, 
        { 0, 1, 0}, 
        { 1, 1, 1}}, //-------------------
      { { 1, 0, 0}, 
        { 1, 1, 0}, 
        { 1, 0, 0}}  //------------------- 
    };
    this.squares = createMap(row, column); 
  }
  public String toString() {
    return this.squares + ": " + super.toString();  
  }

}