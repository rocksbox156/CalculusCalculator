final class Integral {
  final static double INCREMENT = Math.pow(10, -4);
  //define an incremental value
  static double integrate(double a, double b, Function f){
    double area= 0;
    double modifier = 1;
    if(a>b){
      modifier = -1;
    }
    //create a modifier (if bounds are reversed) that allows the integral to appear as negative
    for(double i = a; i<b; i+= INCREMENT){
      if((i+INCREMENT)>b){
        double tempArea = ((b-i)/2)*(f.evaluate(i)+f.evaluate(b));
        area+=tempArea;
      }
      //special case if the Increment runs over b
      else{
        double tempArea = (INCREMENT/2)*(f.evaluate(i)+f.evaluate(i+INCREMENT));
        area+=tempArea;
      }
      //regular case would be this
    }
    return (modifier*area);
  }
}
//Define an abstract Integral Class, that implements some types of integral methods.

final class Derivative{
  final static double INCREMENT = Math.pow(10, -4);
  static double differentiate(double x, Function f){
    double fDelta = f.evaluate(x+INCREMENT)-f.evaluate(x);
    double Slope = fDelta/(INCREMENT);
    return Slope;
  }
}
//Define an abstract Derivative Class, that implements some methods of derivatives
interface Function{
  abstract double evaluate(double x);
}

class CalculusCalculator {
    public static void display(double x){
      System.out.println(Math.floor(x*1000)/1000);
    }
    public static void main(String args[]) {
    	
      Function square = (double x) -> Math.pow(x, 2);

      double integralSquare = Integral.integrate(0, 2, square);
      display(integralSquare);
  

      double derivativeSquare = Derivative.differentiate(2, square);
      display(derivativeSquare);

      Function sine = (double x) -> Math.sin(x);
     
      double integralSine = Integral.integrate(0, Math.PI/2, sine);
      display(integralSine);

      double derivativeSine = Derivative.differentiate(0, sine);
      display(derivativeSine);
    }
}

