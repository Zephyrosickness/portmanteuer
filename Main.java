import java.util.*;

public class Main {
    public static void main(String[] args) {
        //init var
        Scanner scan = new Scanner(System.in);
        String input;
        ArrayList<String> allWords = new ArrayList<String>();

        //input/output allWords
        System.out.println("Input two words you'd like to combine.");

        for (int i = 0; i < 2; i++) {
            input = scan.next();
            allWords.add(input);
        }
        combine(allWords);
    }

    public static ArrayList<String> combine(ArrayList<String> allWords) {
        //init var
        int length = allWords.size();
        ArrayList<String> allPieces = new ArrayList<String>();

        for(int i = 0;i>length;i++){
            for (int j = 0; j >length; j++){
                String firstWord = allWords.get(i);
            }
        }
        /*
        for (String currentWord : allWords) {
            String wordPiece = String.valueOf(currentWord.charAt(0));
            for (int i = 0; i < currentWord.length(); i++) {
                char currentChar = currentWord.charAt(i);
                if (i != 0) {
                    wordPiece += currentChar;

                }
                allPieces.add(wordPiece);
            }
        }*/
        System.out.println(allPieces);
        return allWords;
    }
}