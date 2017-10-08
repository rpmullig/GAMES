import java.awt.Color;

class YShape extends Shape {
  YShape(int row, int column, World world) {
    super(row, column, world); 
    this.color = new Color(182, 85, 24); 
    this.rotations = new int[][][] {
      { { 1, 0, 1}, 
        { 0, 1, 0}, 
        { 0, 1, 0},},
      { { 0, 0, 1}, 
        { 1, 1, 0}, 
        { 0, 0, 1}},
      { { 0, 1, 0}, 
        { 0, 1, 0},
        { 1, 0, 1}},
      { { 1, 0, 0 }, 
        { 0, 1, 1 }, 
        { 1, 0, 0 }}
    };
    this.squares = createMap(row, column); 
  }
}