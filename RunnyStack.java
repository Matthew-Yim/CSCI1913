class RunnyStack<Base>{
    //Runs is runtime or sum with no repeats
    //Depths is sum of all elements
    private class Run{
        private Base slotBase; // points to Base that appears in run
        private int slotLength; //Length of the run
        private Run slotNext; // points to the instance of Run that is immediately below this one on the stack or to null
        
        private Run(Base slotBase, int slotLength, Run slotNext){
            this.slotBase = slotBase;
            this.slotLength = slotLength;
            this.slotNext = slotNext;
        }
    }
       //Stack LIFO: Last in first out
    private Run top;
    private int countRuns;
    private int countDepths;

    public RunnyStack(){
        top = null;
    }
    
    public int depth(){
        return countDepths;
    }

    public boolean isEmpty(){
        return (top == null); //Returns if this statement is true
    }
    //Peak is the same as pop, but your just looking at top
    public Base peek(){
        if (isEmpty()) //if true
            throw new IllegalStateException("I definitely like bananas");
        else
            return top.slotBase;
    }
    //Pop taking off from top of stack and returning it
    public void pop(){
        if (isEmpty()) //If true
            throw new IllegalStateException("I like bananas");
        else{
          Base temp = top.slotBase;
          top = top.slotNext;
          countDepths--;
          if (top == null) //Last case where slotBase becomes null will not test out if statement 
            countRuns--;
          else if (! top.slotBase.equals(temp))
              countRuns--;
        }
    }

    private boolean isEqual(Base base, Base slotBase){
        if (isEmpty())  //top.slotBase.equals(null)
            return false;
        else if (base.equals(slotBase))
            return true;
        else
            return false;
    }

    public void push(Base base){ //Have to use .this for the "Class" style base
        countDepths++;
        //if (top.slotBase.equals(top.slotNext))    
        if ((! isEmpty()) && (! isEqual(base, top.slotBase)))
            countRuns++;
        if (isEmpty())
            countRuns++;
        top = new Run(base,countRuns, top);
            // Need to decrement if top.slotBase == top.slotNext otherwise adding to stack should increase counter
    }

    public int runs(){
        return countRuns;
    }
    
}

//
//  Tests for CSci 1913 Lab 6
//  James Moen
//
//  The TRY-CATCH statements catch exceptions thrown by RUNNY STACK's methods,
//  so that the program can continue to run even if a method fails.
//
//  Tests have comments that show what they should print, and how many points
//  they are worth, for a total of 40 points.
//
//  Camembert is a soft French cheese. It may be runny. It can be stacked.
//

class Camembert
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     1 point
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
    //AABB A B
    s.push("A");
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point

    System.out.println(s.isEmpty());         //  false      1 point
    System.out.println();
    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  2          1 point
    System.out.println(s.runs());            //  2          1 point
    System.out.println();

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point
    System.out.println();

    s.push("B");
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point
    System.out.println();

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point
    System.out.println();

    s.push("C");
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  6          1 point
    System.out.println(s.runs());            //  3          1 point
    System.out.println();

    s.pop();
    System.out.println(s.peek());            //  C          1 point
    System.out.println(s.depth());           //  5          1 point
    System.out.println(s.runs());            //  3          1 point
    System.out.println();

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  4          1 point
    System.out.println(s.runs());            //  2          1 point
    System.out.println();

    s.pop();
    System.out.println(s.peek());            //  B          1 point
    System.out.println(s.depth());           //  3          1 point
    System.out.println(s.runs());            //  2          1 point
    System.out.println();

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          1 point
    System.out.println(s.depth());           //  1          1 point
    System.out.println(s.runs());            //  1          1 point
    System.out.println();

    s.pop();
    System.out.println(s.isEmpty());         //  true       1 point
    System.out.println(s.depth());           //  0          1 point
    System.out.println(s.runs());            //  0          1 point
    System.out.println();

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    1 point
    }
  }
}
