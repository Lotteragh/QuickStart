import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.lang.model.util.ElementScanner6;

/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] A = { 9, 3, 9, 3, 9, 7, 9 };
        int[] B = { 9, 3, 9, 3, 6, 9, 7, 9, 6 };
        int[] C = { 9, 3, 9, 3, 9, 7, 9 ,1,1,7,13,27,27,27,56,43,56,43};
        System.out.println("Solution is " + solution.solution(A));
        System.out.println("Solution is " + solution.solution(B));
        System.out.println("Solution is " + solution.solution(C));

        int[] baseArray = {1,2,3,4,5,6};
        solution.solution(baseArray, 8);

        System.out.println("Number of jumps is 3 " + (solution.solution(10, 85, 30)==3) );
        System.out.println("Number of jumps is 15 " + (solution.solution(10, 85, 5)==15) );
        System.out.println("Number of jumps is 1 " + (solution.solution(10, 25, 20)==1) );


        //PermMissingElement
        int[] permMissingElementA= {1,2,4,5};
        int[] permMissingElementB = {1,2,3,4,5,7};
        System.out.println("Missing int is 3 " + (solution.solution1(permMissingElementA)==3));
        System.out.println("Missing int is 6 " + (solution.solution1(permMissingElementB)==6));

        //TapeEquilbrium
        int[] te = {3,1,2,4,3, 7, 1, 6,2,7};
        System.out.println("Miniman Difference" + solution.getMinimalDifference(te));
        
        
    }

    public int getMinimalDifference(int[] A){
        int difference = 100000;
        int currentDifference = 1000000;
        for(int i =1; i < A.length-1 ; i++){
            currentDifference = getDifference(A, i);
            System.out.println("Current diff " + currentDifference );
            if(difference > currentDifference)
                difference = currentDifference;
        }

        return difference;
    }

    private int  getDifference(int[] A , int P) {
        int sumOne = 0;
        int sumTwo = 0;
        for( int i = 0 ; i < P; i++)
            sumOne += A[i];
        for( int i = P ; i < A.length; i++)
            sumTwo += A[i];
        return  sumOne-sumTwo > 0 ? sumOne - sumTwo : sumTwo-sumOne;

    }

    public int solution(int n) {
        int gap = 0;
        // String binaryString = intToBinary(n) ;
        String binaryString = Integer.toString(n, 2);

        int indexOfFirst1 = binaryString.indexOf("1");
        int indexOfSecond1 = binaryString.lastIndexOf("1");
        // if 1 does not exist return 0
        if (indexOfFirst1 == -1)
            return gap;
        // if first and last index are same
        if (indexOfFirst1 == indexOfSecond1)
            return gap;

        // otherwise get gap
        int tempGap = 0;
        String qualifiedString = binaryString.substring(indexOfFirst1, indexOfSecond1 + 1);
        for (int index = 1; index < (qualifiedString.length() - 1); index++) {
            if (qualifiedString.charAt(index) == '1')
                tempGap = 0;
            else
                tempGap++;
            if (tempGap > gap)
                gap = tempGap;
        }
        return gap;
    }

    private String intToBinary(int n) {
        if (n == 0)
            return "0";

        String binaryString = "";
        String digit = "";
        while (n > 0) {
            if (n % 2 == 0)
                digit = "0";
            else
                digit = "1";
            binaryString = digit + binaryString;
            n = n / 2;
        }
        return binaryString;
    }

    public int solution(int[] A) {
        
        List<Integer> distinctIntegerList = new ArrayList<Integer>();
        for (int index = 0; index < A.length; index++) {
            // get current element from array
            // if it already exists remove it, if not add it.
            Integer currentValue = Integer.valueOf(A[index]);
            
            if (distinctIntegerList.contains(currentValue) == true)
                distinctIntegerList.remove(currentValue);
            else
                distinctIntegerList.add(currentValue);
        }

        return distinctIntegerList.get(0).intValue();

    }

    public int solution1(int[] A) {
        
        List<Integer> integerList = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++)
            integerList.add(Integer.valueOf(A[i]));
        Collections.sort(integerList);

        for (int y = 0 ; y < integerList.size(); y++) {
            System.out.println("current is " + integerList.get(y).intValue());
            if(integerList.contains(Integer.valueOf(y+1))==false){
                return y+1;
            }
        }
        return 0;

    }

    public int[] solution(int[] A, int K) {
        int[] B = new int[A.length];
        for(int index = 0 ; index < A.length; index++){
            int rotatedIndex = (index + K)%A.length;
            System.out.println("length: " + A.length + " index: " + index + " rotatedIndex : " + rotatedIndex);
            B[rotatedIndex] = A[index];
        }
        
        return B;

    }

    public int solution(int X, int Y , int D) {

        return (Y-X)%D==0 ? (Y-X)/D : ((Y-X)/D)+1;
    }
}
