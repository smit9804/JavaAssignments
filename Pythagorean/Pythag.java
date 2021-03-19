import java.lang.Math;

public class Pythag {
    public double calculateHypotenuse(double sideA, double sideB) {
        double sideC = Math.pow(sideA,2) + Math.pow(sideB,2);
        System.out.println(sideC);
        double squareRoot = Math.sqrt(sideC);
        // int hypot = Math.sqrt(Math.pow(sideA) + Math.pow(sideB))
        return squareRoot;
    }
}