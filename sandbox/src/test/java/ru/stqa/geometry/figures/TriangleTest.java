package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static ru.stqa.geometry.figures.Triangle.trianglePerimeter;
import static ru.stqa.geometry.figures.Triangle.triangleSquare;

public class TriangleTest {

    @Test
    void calculatePerimeter(){
        double result = trianglePerimeter(14.0, 10.0, 10.0);
        Assertions.assertEquals(34, result);
    }

    @Test
    void calculateSquare(){
        double result = Math.ceil(triangleSquare(14.0, 10.0, 10.0));
        Assertions.assertEquals(50, result);
    }
}
