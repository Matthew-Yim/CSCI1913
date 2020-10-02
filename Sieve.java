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
              number[i] = true;
      }
    int findPrimes()
      {
        numbers[2] = true;                          //initializes numbers[2] to be true to access if statement @ 19
        for (int i = 2; i <= numbers.length-1; i++) //Starts loop at numbers[2]
          {
            if (numbers[i] == true)
              {
                for(int j = i; j <= numbers.length-1; j++)
                  {
                    if (j != i)                 //makes sure that you aren't redoing 2%2 forces it to be 3%2, 4%3, 5%4, etc.
                      {
                        int remainder = j % i;  //returns either 0 or 1 good for prime/composite
                        if (numbers[j] != false)  //should be able to let true and undefined slots pass thru ex: numbers[3] undefined
                          {                       //if statements below allow previous Trues to be false if it is a multiple
                            if (remainder == 0)
                              numbers[j] = false;
                            else
                              numbers[j] = true;
                          }
                      }
                  }
              }
          }
      }
    String toString()
      {
        String z = " ";
        for (int i = 0; i < numbers.length; i++)
          {
            if (numbers[i] == true)
                z = i + z;  //hopefully this converts int i into char stored in string z and it is "number then space"
          }
          return s;
      }
  }


public class SieveDriver
  {//  MAIN. Find some primes.
    public static void main(String [] args)
      {
        Sieve sieve = null;  //  We must initialize SIEVE or Java will cry.
        //  5 points. This must print "Sieve size must be at least 2." but without the
        //  quotes.
        try
          {
            sieve = new Sieve(0);
          }
        catch (IllegalArgumentException oops)
          {
            System.out.println("Sieve size must be at least 2.");
          }
          //  5 points. This must print nothing.
        try
          {
            sieve = new Sieve(100);
          }
        catch (IllegalArgumentException oops)
          {
            System.out.println("Sieve size must be at least 2.");
          }
          //  10 points. This must print integers from 2 to 99, separated by blanks.
        System.out.println(sieve);
          //  10 points.  This must print the prime numbers between 2 and 99, terminated
          //  by blanks. They are:
          //
          //  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
        sieve.findPrimes();
        System.out.println(sieve);
      }
    }
