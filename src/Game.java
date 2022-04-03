import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    // Fields
    public String randomTitle;
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

    void titleGuessAlgorithm () {
        // Creating new string with letters converted to underscores
        int numberOfLetters = randomTitle.length();
        String hiddenTitle = randomTitle.replaceAll("(?i)[a-z]", "_"); // (?i) case insensitive
        System.out.println("Hidden title: " + hiddenTitle);

        // User input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter one letter: ");
        char letter = userInput.next().charAt(0);
        System.out.println("You chose letter: " + letter);

        // Getting index(es) of typed letter and checking if there's any
        int index;
        if (randomTitle.indexOf(letter) != -1) {
            index = randomTitle.indexOf(letter);
            while(index >= 0) {
                System.out.println(index);
                index = randomTitle.indexOf(letter, index+1);
            }
        } else {
            System.out.println("There is no '" + letter + "' in that title!");
        }
    }

}
