import java.util.*;

public class Main {
    public static void main(String[] args) {
        //init var
        Scanner scan = new Scanner(System.in);
        String input;
        final String SENTINEL = "EXIT"; //value that exits the initial word input/output loop
        ArrayList<String> allWords = new ArrayList<String>(); //contains all user input words, not all result portmanteaus

        //input/output all words
        System.out.println("Input all words you'd like to combine. Type "+SENTINEL+" when you're done.");

        //scans for words until sentinel value is input
        do{
            input = scan.next();
            if(!input.equals(SENTINEL)) {
                // "why do you have to have the same case in both the condiiton for the dowhile and as an if statement inside the same dowhile" IF I DONT HAVE THIS IF STATEMENT THEN IT WILL ADD EXIT TO THE LIST OF WORDS AND THATS DUMB
                allWords.add(input);
            }
        }while (!input.equals(SENTINEL));


        //THE ACTUAL WORD GEN PROCESS //BEGIN --------------------------------------------------------------------------
        ArrayList<String> finalList = new ArrayList<String>();

        //uses all combination of start/end words in the list of provided words
        for(String startingWord:allWords){
            for(String endingWord:allWords){
                if(!startingWord.equals(endingWord)){ //redundancy check
                    System.out.println("STARTING WORD: "+startingWord+" ENDING WORD: "+endingWord); //inital output
                    //finds all combination of word output pieces and adds to the piecelists
                    for(int startingWordIndex = 0; startingWordIndex < startingWord.length(); startingWordIndex++){
                        //a nested for-loop must be used because the iterator(int i) must iterate a certain way; that being endingWordIndex goes through all possible values before startingIndex increases even once, every time
                        for(int endingWordIndex = 0; endingWordIndex < endingWord.length(); endingWordIndex++){
                            String result = startingWord.substring(0, startingWordIndex) + endingWord.substring(endingWordIndex);// (first half of startWord, cut off at char # I ; plus second half of endWord, cut off at character #I
                            if(validityCheck(startingWord.substring(0, startingWordIndex), endingWord.substring(endingWordIndex), result, startingWord, endingWord)) { //checks if word is more than 3 chars and has vowels
                                finalList.add(result);
                            }
                        }
                    }
                }
                System.out.println(finalList);
                finalList.clear(); //clears at the end so the next portmanteau doesnt have the results of the last one
            }
        }
    }
    public static boolean validityCheck(String start, String end, String resultWord, String startingWord, String endingWord) {
        boolean lengthCheck = false;
        boolean vowelCheck = false;
        final String[] VOWELS = {"A","E","I","O","U"};
        /* ^ "why is this list of entirely single-characters a string list BECAUSE .EQUALSIGNORECASE() DOESNT WORK FOR CHAR
        AND CASTING A LIST OF VALUES THAT IS ONLY USED ONCE FROM CHAR TO STRING INSTEAD OF JUST INITIALIZING IT AS STRING IS DUMB*/


        if (start.length()>=2 && end.length()>=2 && resultWord.length() > 3 && !start.equals(startingWord) && !end.equals(endingWord)) {
            //length check; start/end must not be the exact same as the input or shorter than 2 characters, and the resulting word must be more than 3 chars long
            lengthCheck = true;

            //vowel check: checks every character in final word; if no vowels are in final word, return false
            for (int i = 0; i < resultWord.length(); i++) {
                String currentChar = Character.toString(resultWord.charAt(i));
                for(String j:VOWELS){
                    //this has to check if the current character equals every item in the vowels list INDIVIDUALLY because java is dumb idk how to do (arraylist).contains and make it case sensitive and work for char
                    if(currentChar.equalsIgnoreCase(j)){
                        vowelCheck = true;
                    }
                }
            }
        }

        if(vowelCheck&&lengthCheck){
            return true;
        }else{
            return false;
        }
    }
}