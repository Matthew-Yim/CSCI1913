// class Square extends Polygon // takes in one argument for length or sides
// {
//   Square squareObject = new Square();

// }

class Rectangle extends Polygon// takes in two arguments for length or sides
{
  public Rectangle(int x, int y){
    super(4,x,y,x,y);
  }
  public int area(){
    return(super.side(0)*super.side(1));
  }
}

class Polygon {
  private int sideLengths[];

  public Polygon(int sides, int ... banana)
      {
        int index = 0;
        sideLengths = new int [sides];
        for (int length: banana)
          {
            sideLengths[index] = length;
            index += 1;
          }
      }

  public int side(int number) {
    return sideLengths[number];
  }

  public int perimeter() {
    int total = 0;
    for (int index = 0; index < sideLengths.length; index += 1) {
      total += side(index);
    }
    return total;
  }
}

class ShapesDriver {
  public static void main(String[] args) {
    Rectangle wreck = new Rectangle(3, 5);
    System.out.println(wreck.side(0)); // 3 1 point.
    System.out.println(wreck.side(1)); // 5 1 point.
    System.out.println(wreck.side(2)); // 3 1 point.
    System.out.println(wreck.side(3)); // 5 1 point.
    System.out.println(wreck.area()); // 15 1 point.
    System.out.println(wreck.perimeter()); // 16 1 point.
    // Square nerd = new Square(7);
    // System.out.println(nerd.side(0)); // 7 1 point.
    // System.out.println(nerd.side(1)); // 7 1 point.
    // System.out.println(nerd.side(2)); // 7 1 point.
    // System.out.println(nerd.side(3)); // 7 1 point.
    // System.out.println(nerd.area()); // 49 1 point.
    // System.out.println(nerd.perimeter()); // 28 1 point
  }
}
//Git Lens