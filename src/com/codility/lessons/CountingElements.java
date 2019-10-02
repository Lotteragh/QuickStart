package com.codility.lessons;

import java.util.ArrayList;

/**
 * com.codility.lessons.CountingElements
 */
public class CountingElements {

    public static void main(String[] args) {
        CountingElements cElements = new CountingElements();
        int[] A = { 1, 2, 3 };
        int[] B = { 0 };
        int[] C = { 1, 2, 4 };
        int[] D = { 1 };
        int[] E = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int[] F = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15 };
        System.out.println(" A is a perm : " + (cElements.solution(A) == 1));
        System.out.println(" B is a perm : " + (cElements.solution(B) == 1));
        System.out.println(" C is a perm : " + (cElements.solution(C) == 1));
        System.out.println(" D is a perm : " + (cElements.solution(D) == 1));
        System.out.println(" E is a perm : " + (cElements.solution(E) == 1));
        System.out.println(" F is a perm : " + (cElements.solution(F) == 1));

        // FrogRiverOne
        int[] fr1 = { 1, 3, 1, 4, 2, 3, 5, 4 };
        int[] fr2 = { 1 };
        int[] fr3 = { 2 };
        System.out.println(" Frog steps 5 : " + (cElements.solution(5, fr1) ));
        System.out.println(" Frog steps 5 : " + (cElements.solution(3, fr1) ));
        System.out.println(" Frog steps 5 : " + (cElements.solution(17, fr1)));
        System.out.println(" Frog steps 1 : " + (cElements.solution(1, fr2)));
        System.out.println(" Frog steps 17 : " + (cElements.solution(17, fr2)));
        System.out.println(" Frog steps 3 : " + (cElements.solution(3, fr2)));

    }

    public int solution(int[] A) {
        int product = 1;
        int expectedProduct = 1;
        if (A[0] != 1)
            return 0;

        for (int i = 1; i < A.length; i++) {
            product *= A[i];
            expectedProduct *= i + 1;
            // System.out.println("Expected : " + expectedProduct);
            // System.out.println("Product : " + product);
        }
        return (product == expectedProduct) ? 1 : 0;
    }

    public int solution(int X, int[] A) {
        ArrayList<Integer> listOfLeaves = new ArrayList<Integer>(X);
        for (int i = 1; i <= X; i++)
            listOfLeaves.add(Integer.valueOf(i));

        for (int i = 0; i < A.length; i++) {
            //if (listOfLeaves.contains(Integer.valueOf(A[i])))
                listOfLeaves.remove(Integer.valueOf(A[i]));

            if (listOfLeaves.size() == 0)
                return i;
        }
        
        return -1;
    }

}