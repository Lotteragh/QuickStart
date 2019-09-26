/**
 * Solution
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Solution is " + solution.solution(18));
        System.out.println("Solution is " + solution.solution(32));
        System.out.println("Solution is " + solution.solution(1041));

              
        
    }

    public int solution(int n){
        int gap = 0;
        //String binaryString =  intToBinary(n) ;
        String binaryString =  Integer.toString(n, 2);
        
        int indexOfFirst1 = binaryString.indexOf("1");
        int indexOfSecond1 = binaryString.lastIndexOf("1");
        //if 1 does not exist return 0
        if(indexOfFirst1==-1)
            return gap;
        // if first and last index are same
        if( indexOfFirst1 == indexOfSecond1)
            return gap;

        // otherwise get gap
        int tempGap = 0;
        String qualifiedString = binaryString.substring(indexOfFirst1, indexOfSecond1+1);
        for(int index = 1; index < (qualifiedString.length()-1); index++){
            if(qualifiedString.charAt(index)=='1')
                tempGap = 0;
            else    
                tempGap++;
            if(tempGap > gap)
                gap = tempGap;
        }
        return gap;
    }

    private String intToBinary(int n){
        if(n ==0)
            return "0";

        String binaryString = "";
        String digit = "";
        while(n > 0){
            if(n%2 == 0)
                digit = "0";
            else
                digit = "1";
            binaryString = digit + binaryString  ;
            n = n/2;
        }
        return binaryString;
    }
    
}
