package com.codility.forcepoint;

public class Test1 {

    public static void main(String[] args) {
        Test1 test = new Test1();
        int[] A = {4,2,4,5};
        int[] B = {10,567,99,456};
        System.out.println(test.find_min(A));
        System.out.println(test.find_min(B));

        System.out.println(test.find_min(test.solution(1)));
        System.out.println(test.find_min(test.solution(2)));
        System.out.println(test.find_min(test.solution(3)));
        System.out.println(test.find_min(test.solution(4)));
        System.out.println(test.find_min(test.solution(5)));
        System.out.println(test.find_min(test.solution(100)));
    }

    /**
     * A counter example is any array of natural numbers (n>0), for sake of interest we have makde element of array
     * unique
     * @param N Non zero Number of elements in output array
     * @return array of natural numbers between 1 and N
     */
    int[] solution(int N){
        int[] result = new int[N];
        for( int i = 1; i <= N ; i++){
            result[i-1] = i;
        }
        return result;
    }



    int find_min(int[] A){
        int ans = 0;
        for (int i=1; i<A.length; i++){
            if(ans > A[i]){
                ans = A[1];
            }
        }
        return ans;
    }
}
