package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TriangleTest {

    @Test
    void calculateSquare() {
        double result = Math.ceil(new Triangle(14.0, 10.0, 10.0).triangleSquare());
        Assertions.assertEquals(50, result);
    }

    @Test
    void calculatePerimeter(){
        Assertions.assertEquals(34,(new Triangle(14.0, 10.0, 10.0).perimeter()));
    }

    @Test
    void cannotCreateSquareWithNegativeSide() {
        try {
            new Triangle(-5, 5, 9);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }

    @Test
    void cantCreateTriangleWithUncorrectSumOfTwoSides() {
        try {
            new Triangle(2, 3, 8);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
        }
    }
    @Test
    void testEquality(){
        var q = new Triangle (3, 4, 5);
        var q1 = new Triangle (3,4,5);
        Assertions.assertEquals(q, q1);
    }
    @Test
    void testEquality2(){
        var q = new Triangle (3, 4, 5);
        var q1 = new Triangle (4,5,3);
        Assertions.assertEquals(q, q1);
    }
}
