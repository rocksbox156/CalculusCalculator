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
    	
      Function square = (x) -> Math.pow(x, 2);
      //You can create a function by typing the keyword function, followed by a name for your function
      //You can then define the rules of your function by typing "(x) ->" followed by your function (i.e. x*x)
      //Use Math.pow(x, power) to define functions like x^2 or x^3
      //Use Math.sin(x) or Math.cos(x) in order to calculate integrals of trig functions
      
      
      double integralSquare = Integral.integrate(0, 2, square);
      display(integralSquare);
      //In order to integrate your function, simply type "Integral.integrate(start value, end value, function)".
      //Replace the start and end values with endpoints of your choice
      //Remember to set this answer equal to a variable of choice
      //In order to display the answer to your calculation, type display(variable)
  

      double derivativeSquare = Derivative.differentiate(2, square);
      display(derivativeSquare);
      //In order to differentiate your function, simply type "Derivative.differentiate(value, function)".
      //Replace the word value to a number of your choice
      //Remember to set this answer equal to a number of your choice
      //In order to display the answer to your calculation, type display(variable)
      	
      //An example of this process works as follows:
      Function sine = (x) -> Math.sin(x);
     
      double integralSine = Integral.integrate(0, Math.PI/2, sine);
      display(integralSine);

      double derivativeSine = Derivative.differentiate(0, sine);
      display(derivativeSine);
    }
}

