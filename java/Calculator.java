public class Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }
        public static void main(String[] args) {
        Calculator myCalculator = new Calculator();

        double number1 = 10.5;
        double number2 = 25.3;

        double sumResult = myCalculator.add(number1, number2);

        System.out.println("--- First Example ---");
        System.out.println("The first number is: " + number1);
        System.out.println("The second number is: " + number2);
        System.out.println("The sum of " + number1 + " and " + number2 + " is: " + sumResult);

       
    }
}

