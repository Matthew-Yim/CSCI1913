// Matthew Yim 4950946
// I was alone..

class Sieve
  {
    private boolean numbers [];
    Sieve (int max)
      {
        if (max < 2)
          throw new IllegalArgumentException();
        else
          numbers = new boolean [max];
          numbers [0] = false;
          numbers [1] = false;
        for (int i = 2; i <= numbers.length-1; i++)
          numbers [i] = true;
      }
    public void findPrimes()
      {
        numbers [2] = true;                          //initializes numbers[2] to be true to access if statement @ 19
        for (int i = 2; i <= ((numbers.length-1)/2); i++) //Starts loop at numbers[2] // Divide by 2 because j will never be divisible by anything greater than half itself
          {
            if (numbers [i]) // == true, since this is style with boolean by itself it is true // Too make sure it doesn't redo false position in the array
              {
                for(int j = i; j <= numbers.length-1; j++)
                  {
                    int remainder = j % i;  //returns either 0 or 1 good for prime/composite
                    if (numbers [j] != false && j != i)  //let true slots pass thru ex: numbers[9] (iteration of 2s)
                      {                                  //Also makes sure that you aren't redoing 2%2 forces it to be 3%2, 4%3, 5%4, etc.
                        if (remainder == 0)   //if statements below allow previous Trues to be false if it is a multiple
                          numbers [j] = false;
                        else
                          numbers [j] = true;
                      }
                  }
              }
          }
      }
    public String toString()
      {
        String numberlist = " ";
        for (int i = 0; i < numbers.length; i++)
          {
            if (numbers[i] == true)
                numberlist += i + " ";  //hopefully this converts int i into char stored in string z and it is "number then space"
          }
          return numberlist;
      }
  }
