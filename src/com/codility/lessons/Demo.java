package com.codility.lessons;

import java.util.*;


public class Demo {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] A = {1,2,2,1,2};
        int[] B = {2,1,3,1,2,2,3};

        Demo demo = new Demo();

        //demo.solution(4,2, A);
        //demo.solution(3,5, B);
        //demo.solution(2,5, B);
        System.out.println(demo.solution(1,5, B).length);
        System.out.println(demo.solution(5,5, B).length);
        System.out.println(demo.solution(7,5, B).length);
//
        long endTime = System.currentTimeMillis();
    }

    public int[] solution(int K, int M, int[] A){
        ArrayList<Integer> leadersList = new ArrayList<Integer>();

        //for each segment
        for(int i = 0 ; i <= A.length -K ; i++ ){
            int[] modifiedArray = Arrays.copyOf(A ,A.length);
             modifiedArray = getModifiedArray(i,K,modifiedArray);
            int leader = getLeader(modifiedArray);
            if(leader!=0)
                leadersList.add(leader);
        }
        Collections.sort(leadersList);
        //remove duplicated by adding to set
        TreeSet<Integer> leadersSet = new TreeSet<Integer>(leadersList);

        int[] primitiveLeaders = new int[leadersSet.size()];
        Iterator<Integer> iterator = leadersSet.iterator();
        int i=0;
        while(iterator.hasNext()) {
            primitiveLeaders[i] = iterator.next().intValue();
            i++;
        }

        return primitiveLeaders;
    }

    boolean isThisALeader(int value, int leaderThreshold, int A []){
        boolean leader = false;
        int occurrences = 0;
        for(int i =0; i < A.length ; i++){
            if(A[i] == value)
                occurrences++;
            if(occurrences > leaderThreshold){
                return true;
            }
            if(i>=A.length/2 & occurrences==0)
                return false;

        }
        return leader;
    }

    int getLeader(int A[]){
        int leaderThreshold = A.length/2;
        for(int i=0 ; i<=A.length/2; i++){
            if(isThisALeader(A[i], leaderThreshold, A)==true)
                return A[i];
        }
        return 0;
    }

    private int[] getModifiedArray(int offset, int K, int[] A){
        for( int i=0 ; i < K; i++){
            A[offset+i] = A[offset+i] +1;
        }
        return A;
    }
}
