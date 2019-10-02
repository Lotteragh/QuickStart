package com.codility.forcepoint;

public class Test3 {


    public static void main(String[] args) {
        Test3 test = new Test3();
    }

    public int solution(int[] A){
        int lengthOfTurb = 0;

        if(A.length == 1)
            return 1;
        if(A.length==2){
            if(A[0] == A[1])
                return 0;
            else
                return 1;
        }
        int currentLongest = 0;
        for(int i=1 ; i < A.length-1; i++){
            if(A[i-1] > A[i] && A[i+1] > A[i])
                currentLongest++;
            if(A[i-1] < A[i] && A[i+1] < A[i])
                currentLongest++;
            if(A[i-1] == A[i])
                currentLongest = 0;
            if(A[i-1] > A[i] && A[i] > A[i+1])
                currentLongest = 0 ;
            if(A[i-1] < A[i] && A[i] < A[i+1])
                currentLongest = 0;

            if(currentLongest > lengthOfTurb)
                lengthOfTurb = currentLongest;
        }

        return lengthOfTurb;
    }
}
