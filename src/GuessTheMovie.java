public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        // Initializing GuessTheMovie game
        Game game = new Game();

        // Movie draw
        game.movieDraw("movies.txt");
        System.out.println("Random movie title is: " + game.randomTitle);

        // Hiding movie title by replacing its letters to '_'
        game.hideTitle();

        // The game itself
        while (game.hiddenTitle.indexOf('_') != -1 && !game.hasLost()) {
            game.getLetterFromUser();
            game.titleGuessAlgorithm();
            game.hasLost();
        }

        // Checking if player won the game
        if (game.hasLost()) {
            System.out.println("You have lost :(");
            System.out.println("The movie was: " + game.randomTitle);
        } else {
            System.out.println("You win!");
            System.out.println("You have guessed '" + game.randomTitle + "' correctly." );
        }
    }
}
