import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {
    private ArrayList<String> words;
    private int wordIndex;
    private WordGameState gameState;

    public static class WordGameState {
        private String word;
        private int mistakes;
        private int mistakeLimit;
        private int missingChars;
        private WordGameState(){
            word = "";
            mistakes = 0;
            mistakeLimit = 0;
            missingChars = 0;
        }
        public String getWord(){
            return word;
        }
        public int getMistakes(){
            return mistakes;
        }
        public int getMistakeLimit(){
            return mistakeLimit;
        }
        public int getMissingChars(){
            return missingChars;
        }
    }

    public WordGame(String wordFilename) throws FileNotFoundException{
        File fileObj = new File(wordFilename);
        Scanner scanner = new Scanner(fileObj);
        words = new ArrayList<String>();
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            words.add(data);
        }
        gameState = new WordGameState();

    }

    public void initGame(int wordIndex, int mistakeLimit) throws GameStateException {
        this.wordIndex = wordIndex % words.size();
        gameState.word = "";
        for(int i = 0; i < words.get(this.wordIndex).length(); i++){
            gameState.word += "_";
        }
        gameState.mistakeLimit = mistakeLimit;
        gameState.missingChars = gameState.word.length();
        gameState.mistakes = 0;
    }

    public Boolean isGameActive(){
        return gameState != null && gameState.getMissingChars() > 0 && gameState.getMistakes() <= gameState.getMistakeLimit();
    }

    public WordGameState guess(char c) throws GameStateException {
        c = Character.toLowerCase(c);
        if(!isGameActive()){
            throw new GameStateException("There is currently no active word game!");
        }
        if(gameState.word.indexOf(c) != -1){
            gameState.mistakes++;
            return gameState;
        }
        int index = words.get(wordIndex).indexOf(c);
        if(index != -1){
            String newWord = "";
            for (char letter : words.get(wordIndex).toCharArray()) {
                if (letter == c) {
                    newWord += c;
                    gameState.missingChars--;
                } else {
                    newWord += gameState.word.charAt(newWord.length());
                }
            }
            gameState.word = newWord;
        }
        else{
            gameState.mistakes++;
            
            if(gameState.mistakes > gameState.mistakeLimit){
                gameState.word = words.get(wordIndex);
            }
        }
        return gameState;
    }
    public WordGameState guess(String s) throws GameStateException {
        if(!isGameActive()){
            throw new GameStateException("There is currently no active word game!");
        }
        if(words.get(wordIndex).equals(s)){
            gameState.word = s;
            gameState.missingChars = 0;
        } else {
            gameState.mistakes++;
            if(gameState.mistakes > gameState.mistakeLimit){
                gameState.word = words.get(wordIndex);
            }
        }
        return gameState;
    }

    public WordGameState getGameState() throws GameStateException {
        if(!isGameActive()){
            throw new GameStateException("There is currently no active word game!");
        }
        return gameState;
    }
}