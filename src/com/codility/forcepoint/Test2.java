package com.codility.forcepoint;

public class Test2 {


    public static void main(String[] args) {
        Test2 test = new Test2();
        //test.solve("baaaaa");
        //test.solve("baaabbaabbbaa");
        System.out.println(test.solutionA("baaaaa"));
    }


    int solutionA(String S){
        int result = 0;
        if(S.indexOf("aaa") ==-1 & S.indexOf("bbb")==-1)
            return 0;
        //flush A's
        int indexOfTripleA = -1;
        while((indexOfTripleA =S.indexOf("aaa"))!=-1){
            String preString = S.substring(0, indexOfTripleA );
            String postString = S.substring( indexOfTripleA +3, S.length());

            if(preString.length() > 2 & !preString.substring(preString.length()-2, preString.length()).equals("bb") ){
                S = preString + "baa" + postString;
                result++;
            }

            if(postString.length() > 2 & !postString.substring(0, 2).equals("bb") ){
                S = preString + "aab" + postString;
                result++;
            }

            if(preString.length() > 2 & preString.substring(preString.length()-2, preString.length()).equals("bb") & postString.length() > 2 & postString.substring(0, 2).equals("bb") ){
                S = preString + "aba" + postString;
                result++;
            }

        }
        //flush B
        int indexOfTripleB = -1;
        while((indexOfTripleB =S.indexOf("bbb"))!=-1){
            String preString = S.substring(1, indexOfTripleB );
            String postString = S.substring( indexOfTripleB +3, S.length());

            if(preString.length() > 2 & !preString.substring(preString.length()-2, preString.length()).equals("aa") ){
                S = preString + "abb" + postString;
                result++;
            }

            if(postString.length() > 2 & !postString.substring(0, 2).equals("aa") ){
                S = preString + "bba" + postString;
                result++;
            }

            if(preString.length() > 2 & preString.substring(preString.length()-2, preString.length()).equals("aa") & postString.length() > 2 & postString.substring(0, 2).equals("aa") ){
                S = preString + "bab" + postString;
                result++;
            }

        }

        return result;
    }

     int solution( String solve){
         int result = 0;
        if(solve.indexOf("aaa") ==-1 & solve.indexOf("bbb")==-1)
            return 0;
         char[] characters = solve.toCharArray();

         int numberOfConsecutiveChars = 1;
         for(int i = 1 ; i < characters.length ; i++){
            if(characters[i] == characters[i-1]){
                numberOfConsecutiveChars++;
            }

            if(numberOfConsecutiveChars==3){
                numberOfConsecutiveChars = 0;
                result++;
                characters[i-3] = (characters[i] =='a'? 'b' : 'a');
            }
         }

         return result;
    }
}
