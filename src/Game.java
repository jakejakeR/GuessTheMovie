import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    // Fields
    public String randomTitle;
    public char letter;
    public String hiddenTitle;
    public int wrongAnswers = 0;
    public String wrongLetters = "";
    // Constructor

    // Methods
    String movieDraw (String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        List<String> listOfTitles = new ArrayList<>();

        // Adding lines to the list
        try (scanner) {
            while (scanner.hasNextLine()) {
                listOfTitles.add(scanner.nextLine());
            }
        }
        // Declaring array that consists strings of movies' titles.
        String [] arrayOfTitles = listOfTitles.toArray(new String[]{});
        /*Test output prints
        System.out.println(Arrays.toString(arrayOfTitles));*/

        // Drawing a random movie title
        int randomNumber = (int) (Math.random()* arrayOfTitles.length);
        randomTitle = arrayOfTitles[randomNumber];

        return randomTitle;
    }

    String hideTitle () {
        // Creating new string with letters converted to underscores
        hiddenTitle = randomTitle.replaceAll("(?i)[a-z]", "_"); // (?i) case insensitive
        //System.out.println("Hidden title: " + hiddenTitle);
        return hiddenTitle;
    }

    char getLetterFromUser () {
        // User input
        System.out.println("You are guessing: " + hiddenTitle);
        System.out.println("You have guessed (" + wrongAnswers + ") wrong letters: " + wrongLetters);
        Scanner userInput = new Scanner(System.in);
        //System.out.println("Enter one letter: ");
        letter = Character.toLowerCase(userInput.next().charAt(0));
        //System.out.println("You chose letter: " + letter);
        return letter;
    }

    String titleGuessAlgorithm () {
        // Getting index(es) of typed letter and checking if there's any
        int index;

        if (randomTitle.indexOf(letter) != -1 && hiddenTitle.indexOf(letter) == -1) {
            index = randomTitle.indexOf(letter);
            while(index >= 0) {
                //System.out.println(index);
                hiddenTitle = hiddenTitle.substring(0, index) + letter + hiddenTitle.substring(index + 1);
                index = randomTitle.indexOf(letter, index+1);
            }
        } else if (hiddenTitle.indexOf(letter) != -1) {
            System.out.println("You already guessed that letter!");
        }
        else {
            wrongAnswers += 1;
            wrongLetters += letter + " ";
            System.out.println("There is no '" + letter + "' in that title!");
        }
        return hiddenTitle;
    }

    boolean hasLost () {
        return wrongAnswers == 10;
    }

}
