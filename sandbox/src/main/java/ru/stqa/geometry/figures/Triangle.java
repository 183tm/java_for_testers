package ru.stqa.geometry.figures;



public record Triangle(double a, double b, double c) {
    public static double triangleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    public static double trianglePerimeter(double a, double b, double c) {
        return (a + b + c);
    }

    public static void printTriangleSquare(double a, double b, double c) {
        var text = String.format("Пощадь треугольника со сторонами %.1f ,%.1f и %.1f = %.1f", a, b, c, triangleSquare(a, b, c));
        System.out.println(text);
    }

    public static void printTrianglePerimeter(double a, double b, double c) {
        var text = String.format("Периметр треугольника со сторонами %.1f ,%.1f и %.1f = %.1f", a, b, c, trianglePerimeter(a, b, c));
        System.out.println(text);
    }
}



