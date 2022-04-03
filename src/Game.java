import java.io.File;
import java.util.Scanner;

public class Game {
    // Fields

    // Constructor

    // Methods
    void displayMovieList (String fileTitle) throws Exception {
        File file = new File (fileTitle);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            // Fields
            String movieTitle = scanner.nextLine();
            System.out.println(movieTitle);
        }
    }
}
