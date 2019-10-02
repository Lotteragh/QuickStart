package com.codility.lessons;

import java.util.ArrayList;
import java.util.Collections;

public class Peaks {
    public static void main(String[] args) {
        int[] A = {};
        int[] B = {1, 1, 1, 1, 1, 1};
        int[] C = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        Peaks peaks = new Peaks();
        //System.out.println(peaks.solution(A));
        //System.out.println(peaks.solution(B));
        System.out.println(peaks.solution(C));
    }

    public int solution(int[] A) {
        ArrayList divisors = getDivisors(A.length);
        int maxNumberOfBlocks = 0;
        if (divisors.size() <= 2)
            return 1;
        ArrayList peaks = getPeaks(A);

        if (peaks.size() == 0)
            return 0;

        for (int i = peaks.size(); i > 0; i--)
            if (divisors.contains(i) && blockContainAtLeastOnePeak(i, peaks, A)) {
                System.out.println(" i is " + i);
                return i;
            }


        return maxNumberOfBlocks;
    }

    public boolean blockContainAtLeastOnePeak(int numberOfBlocks, ArrayList<Integer> peaks, int[] baseArray) {
        boolean flagBlockContainsAPeak = false;
        int blockSize = baseArray.length / numberOfBlocks;
//        // for each block, confirm at least one entry
        allBlocks:
        for (int i = 0; i < baseArray.length; i += blockSize) {
            for (int j = i; j < +i + blockSize; j++) {
                if (peaks.contains(baseArray[j])) {
                    flagBlockContainsAPeak = true;
                    break;
                }
            }
            if (flagBlockContainsAPeak == false)
                return false;
        }
        return flagBlockContainsAPeak;
    }

    private void If(boolean b) {
    }

    public ArrayList<Integer> getDivisors(int A) {
        ArrayList<Integer> divisors = new ArrayList<Integer>(0);
        for (int i = 1; i < A / 2; i++) {
            if (A % i == 0) {
                divisors.add(i);
            }

        }

        return divisors;
    }

    public ArrayList<Integer> getPeaks(int[] A) {
        ArrayList<Integer> peakIndexList = new ArrayList<Integer>(0);
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peakIndexList.add(i);
            }

        }

        return peakIndexList;
    }
}
