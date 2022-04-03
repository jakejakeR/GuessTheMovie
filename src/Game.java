import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    // Fields
    public String randomTitle;
    // Constructor

    // Methods
    /*void titleList (String fileTitle) throws Exception {
        int lineCounter = 0;
        File file = new File (fileTitle);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String movieTitle = scanner.nextLine();
            System.out.println(movieTitle);
        }
    }*/

    String movieDraw (String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        List<String> listOfTitles = new ArrayList<>();
        int lineCounter=0;

        // Adding lines to the list
        try (scanner) {
            while (scanner.hasNextLine()) {
                listOfTitles.add(scanner.nextLine());
                lineCounter += 1;
            }
        }
        // Declaring array that consists strings of movies' titles.
        String [] arrayOfTitles = listOfTitles.toArray(new String[]{});
        // Test output prints
        System.out.println(Arrays.toString(arrayOfTitles));
        for (int i=0; i<lineCounter; i++) {
            System.out.println(arrayOfTitles[i]);
        }

        // Drawing a random movie title
        int randomNumber = (int) (Math.random()*lineCounter);
        System.out.println(randomNumber);
        randomTitle = arrayOfTitles[randomNumber];
        System.out.println(randomTitle);

        return randomTitle;
    }

}
