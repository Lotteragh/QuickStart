package com.codility.forcepoint;

import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {


    public static void main(String[] args) {
        Test2 test = new Test2();
        //test.solve("baaaaa");
        //test.solve("baaabbaabbbaa");
        System.out.println(test.solution("aaaaaaaaa"));
    }


    public int solution(String S) {
        int result = 0;
        if (!S.contains("aaa") & !S.contains("bbb"))
            return 0;
        //flush A's
        int indexOfTripleA = -1;
        while ((indexOfTripleA = S.indexOf("aaa")) != -1) {
            if (S.length() == indexOfTripleA + 3) {
                S = S.substring(0, indexOfTripleA) + "aab";
                result++;
            }
            if (S.length() > indexOfTripleA + 3) {
                if (S.charAt(indexOfTripleA + 4) == 'a') {
                    S = S.substring(0, indexOfTripleA) + "aab" + S.substring(indexOfTripleA + 3);
                    result++;
                    continue;
                }
                if (S.charAt(indexOfTripleA + 4) == 'b') {
                    S = S.substring(0, indexOfTripleA) + "aba" + S.substring(indexOfTripleA + 3);
                    result++;
                }

            }
        }

        int indexOfTripleB = -1;
        while ((indexOfTripleB = S.indexOf("bbb")) != -1) {
            if (S.length() == indexOfTripleB + 3) {
                S = S.substring(0, indexOfTripleB) + "bba";
                result++;
            }
            if (S.length() > indexOfTripleB + 3) {
                if (S.charAt(indexOfTripleB + 4) == 'b') {
                    S = S.substring(0, indexOfTripleB) + "bba" + S.substring(indexOfTripleB + 3);
                    result++;
                }
                if (S.charAt(indexOfTripleB + 4) == 'a') {
                    S = S.substring(0, indexOfTripleB) + "bab" + S.substring(indexOfTripleB + 3);
                    result++;
                }
            }
        }


        return result;
    }


}
