package example;public class HelloWorld {
  public double sayHelloWorldFrom(double income) {
//    String result = "Hello, world, from " + from;
    double result = 0;
    if(income>3500){
      result = (income-3500) *0.02;
    }
    System.out.println(result);
    return result;
  }
}
