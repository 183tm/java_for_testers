package ru.stqa.geometry.figures;



public record Triangle(double a, double b, double c) {

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("The sum of two sides of a triangle must be greater than the third side");
        }
    }

    public double perimeter() {
        return (a + b + c);
    }

    public double triangleSquare() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void printTriangleArea(Triangle t) {
        var text = String.format("Пощадь треугольника со сторонами %.1f ,%.1f и %.1f = %.1f", t.a, t.b, t.c, t.triangleSquare());
        System.out.println(text);
    }

}



