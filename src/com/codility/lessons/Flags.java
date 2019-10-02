package com.codility.lessons;

import java.util.ArrayList;

public class Flags {
    public static void main(String[] args) {

        int[] B = {1};
        int[] C = {1,5,4};
        int[] D = {1,5,4,5,3};
        int[] E = {1,5,3,4,3,4,1,2,3,4,6,2,4,1};
        Flags flags = new Flags();

        System.out.println(flags.getPeaks(B).toString());
        System.out.println(flags.getPeaks(C).toString());
        System.out.println(flags.getPeaks(D).toString());
        System.out.println(flags.getPeaks(E).toString());
        System.out.println(flags.getPeaksGaps(flags.getPeaks(E)).toString());

        flags.solution(B);
        flags.solution(C);
        flags.solution(D);
        flags.solution(E);
    }

    public int solution(int[] A){
        int result = 0;
        //if array length is less that three, return zero
        if(A.length < 3)
            return result;

        ArrayList<Integer> peaks = getPeaks(A);

        return result;
    }

    public ArrayList<Integer> getPeaks(int[] A){
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        for(int i = 1; i < A.length ; i++){
            if (A[i - 1] < A[i] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }
        return  peaks;
    }

    public ArrayList<Integer> getPeaksGaps(ArrayList<Integer> peaks){
        ArrayList<Integer> peakGaps = new ArrayList<Integer>(peaks.size()-1);
        for(int i = 1; i < peaks.size() ; i++){
                peakGaps.add(peaks.get(i)-peaks.get((i-1)));
        }
        return  peakGaps;
    }


    private  boolean areFlagsValid(int numberOfFlags , ArrayList<Integer> listOfPeaks, int[] mountainRange){
        boolean flagsAreValid = false;
        //case of one flag
        if(numberOfFlags==1 && listOfPeaks.size()>1 && mountainRange.length >2)
                return true;

        Integer previousPeak = 0;
        for(Integer peak : listOfPeaks){
            if(peak - previousPeak >= numberOfFlags){
                flagsAreValid = true;
                previousPeak = peak;
            }


        }

        return flagsAreValid;

    }
}
