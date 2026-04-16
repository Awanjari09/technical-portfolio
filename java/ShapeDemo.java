class Shape {
    protected double dim1; 
    protected double dim2; 
    public void PrintArea() {
        System.out.println("Area calculation not implemented for generic Shape.");
    }
}

class Triangle extends Shape {
    public Triangle(double base, double height) {
        this.dim1 = base;   
        this.dim2 = height; 
    }
    @Override
    public void PrintArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Triangle Area: " + area);
    }
}

class Rectangle extends Shape {
    public Rectangle(double length, double width) {
        this.dim1 = length; 
        this.dim2 = width; 
    }
    @Override
    public void PrintArea() {
        double area = dim1 * dim2;
        System.out.println("Rectangle Area: " + area);
    }
}

class Circle extends Shape {
    public Circle(double radius) {
        this.dim1 = radius; 
        this.dim2 = 0;      
    }
    @Override
    public void PrintArea() {
        double area = Math.PI * dim1 * dim1; 
        System.out.println("Circle Area: " + area);
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10, 5);
        Rectangle rectangle = new Rectangle(8, 4);
        Circle circle = new Circle(7);

        System.out.println("--- Calculating Areas ---");
        triangle.PrintArea();
        rectangle.PrintArea();
        circle.PrintArea();
    }
}
