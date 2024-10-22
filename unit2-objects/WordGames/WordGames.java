import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class WordGames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordGames extends Actor
{
    /**
     * Act - do whatever the WordGames wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img;
    private String word;
    
    public WordGames(String text){
        word = text;
        img = new GreenfootImage(word, 24, Color.BLACK, Color.PINK);
        setImage(img);
    }
    public String scramble() {
        int mid = word.length() / 2;
        String firstHalf = word.substring(0, mid); 
        String secondHalf = word.substring(mid);
        return secondHalf + firstHalf;
    }

    public String bananaSplit(int insertIdx, String insertText) {
        return word.substring(0, insertIdx) + insertText + word.substring(insertIdx); 
    }

   
    public String bananaSplit(String insertChar, String insertText) {
        int insertIdx = word.indexOf(insertChar); 
        if (insertIdx == -1) { 
            return word; 
        }
        return bananaSplit(insertIdx, insertText); 
    }

    
    public String toString() {
        return "[" + word + "]";
    }
    public void act()
    {
        // Add your action code here.
        // Ask for a word
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String userWord = input.nextLine();
        WordGames wordGame = new WordGames(userWord);

        // Scramble it
        String scrambledWord = wordGame.scramble();
        System.out.println("Scrambled word: " + scrambledWord);
        
        // Ask for an index
        System.out.print("Enter an integer: ");
        int idx = input.nextInt();
        input.nextLine(); // skip over the newline
        System.out.print("Enter another word: ");
        String insertWord = input.nextLine();
        
        // Add random word at index
        String newWordWithIndex = wordGame.bananaSplit(idx, insertWord);
        System.out.println("Word after banana split at index: " + newWordWithIndex);
        
        // Ask for a character
        System.out.print("Enter a character to insert after: ");
        String insertChar = input.nextLine();
        System.out.print("Enter another word: ");
        String insertWord2 = input.nextLine();
        
        // Add random word at character
        String newWordWithChar = wordGame.bananaSplit(insertChar, insertWord2);
        System.out.println("Word after banana split at character: " + newWordWithChar);
        
        // Print final word representation
        System.out.println("Final representation: " + wordGame);
    }
    
}
