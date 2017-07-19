import java.util.Random;

/**
 * Created by klongrich on 12/12/16.
 */
public class AI {

  int xVaules[][] ={ {0, 0},
                     {1, 0},
                     {0, 1},
                     {1, 1} };

  double target[] = {1, 0, 0, 1};

  Random rand = new Random();

  double w1 = rand.nextInt(100);
  double w2 = rand.nextInt(100);

  double s1 = w1;
  double s2 = w2;

  public double sigmoid(double x) {
        return (1/( 1 + Math.pow(Math.E,(-1*x))));
  }

  public int check(double result)
  {
      if (result >= .5)
      {
          return (1);
      }
      else
      {
          return (0);
      }
  }

  public void train()
  {
      boolean error;
      int y;
      double r1;
      double r2;
      int result;

      y = 0;
      error = true;
      System.out.println(w1 + " , " + w2 );
      System.out.println();
      while (error)
      {
          r1 = sigmoid((((xVaules[y][0] * w1) + (xVaules[y][1] * w2)) - 50) / 100);
          r2 = sigmoid((((xVaules[y][0] * w1) + (xVaules[y][1] * w2)) - 150) / 100);

          System.out.println(r1 + " , " + r2);

          result = check(r1 * r2);

          System.out.println(result);

          if (result != target[y])
          {
              w1 += 5;
              w2 += 5;
              y = 0;
          }
          if (y == 3)
          {
              error = false;
          }
          y++;
      }
  }

  public void test()
  {
      double r1;
      double r2;
      int result;

      System.out.println();
      System.out.println("Starting: " + s1 + " , " + s2);
      System.out.println("Adjusted: " + w1 + " , " + w2);
      System.out.println();

      for(int y = 0; y < 4; y++)
      {
          r1 = ((xVaules[y][0] * w1) + (xVaules[y][1] * w2)) - 50;
          r2 = ((xVaules[y][0] * w1) + (xVaules[y][1] * w2)) - 150;

          result = check(r1 * r2);

          System.out.println(xVaules[y][0] + " " + xVaules[y][1] + " = " + result);

      }
  }
}
