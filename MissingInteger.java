import java.util.HashSet;
import java.util.Set;

/**
 * MissingInteger
 */
public class MissingInteger {

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        int[] A =  {1, 3, 6, 4, 1, 2};
        int[] B = {1, 2, 3};
        int[] C =  {-1 , -3};
        System.out.println(" Answer is 5 " + (missingInteger.solution(A)==5));
        System.out.println(" Answer is 4 " + (missingInteger.solution(B)==4));
        System.out.println(" Answer is 1 " + (missingInteger.solution(C)==1));
        
    }

    public int solution(int[] A){
        int result =1;
        Set<Integer> setOfNumbers = new HashSet<Integer>();
        for(int i= 0 ; i < A.length; i++)
            setOfNumbers.add(A[i]);
        while(true){
            if(!setOfNumbers.remove(result))
                return result;
            result++;
        }
    }
}