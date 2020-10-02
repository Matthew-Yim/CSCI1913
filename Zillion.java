//Matthew Yim Previous Partner Xuefei 
class Zillion
  {
    private int[] digits;
    public Zillion (int size)
      {
        digits = new int [size];
      }
    public void increment()
      {
        for (int i = digits.length-1; i >= 0; i--)
          {
            if (digits[i] == 9)
              {
                digits[i] = 0;
              }
            else
              {
                digits[i]++;
                break;
              }
          }
      }
    public String toString()
      {
        String s = "";
        for (int i = 0; i < digits.length;i++)
          {
            s += digits[i];
          }
          return s;
      }
  }
