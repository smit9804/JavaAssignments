public class BasicsTest {
    public static void main (String[] args){
        Basics go = new Basics();

        go.print1To255();

        go.printOddTo255();

        go.printSum();

        int[] testArr = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        go.iterateArray(testArr);
        
        int[] testArr = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        go.findMax(testArr);
        
        int[] testArr = {2,10,3};
        go.findAvg(testArr);

        go.arrayOdd();

        int[] testArr = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        go.greaterThanY(testArr, 1);

        int[] testArr = {1,2,3,4};
        go.squared(testArr);

        int[] testArr = {-3, 3, -1, 7, -12, 14, 5, -4};
        go.eliminateNegs(testArr);
        
        int[] testArr = {-3, 3, -1, 7, -12, 14, 5, -4};
        go.maxMinAvg(testArr);

        int[] testArr = {-3, 2, 3, -1, 6, -7};
        go.shiftValues(testArr);
    }
}