public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        // Initializing GuessTheMovie game
        Game game = new Game();

        // Rules for user
        System.out.println("""
                The rules are simple:
                The computer randomly picks a movie title, and shows you how many letters it's made up of.\s
                Your goal is to try to figure out the movie by guessing one letter at a time.
                If a letter is indeed in the title the computer will reveal its correct position in the word,
                if not, you lose a point. If you lose 10 points, game over!
                """);

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
