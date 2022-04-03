public class GuessTheMovie {
    public static void main(String[] args) {
        // Initializing GuessTheMovie game
        Game game = new Game();

        // Displaying list of movies
        try {
            game.displayMovieList("movies.txt");
        } catch (Exception exception) {
            System.out.println("File missing!");
        }


    }
}
