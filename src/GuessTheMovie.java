public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        // Initializing GuessTheMovie game
        Game game = new Game();
        // Movie draw
        game.movieDraw("movies.txt");
        System.out.println("Random movie title is: " + game.randomTitle);

        game.titleGuessAlgorithm();
    }
}
