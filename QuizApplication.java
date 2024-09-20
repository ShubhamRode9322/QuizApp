import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int currentQuestion = 0;
    private static String[][] questions = {
            {"What is the capital of France?", "A. Paris", "B. London", "C. Berlin", "D. Rome", "A"},
            {"What is the largest planet in our solar system?", "A. Venus", "B. Jupiter", "C. Mars", "D. Saturn", "B"},
            {"Who wrote Romeo and Juliet?", "A. William Shakespeare", "B. Charles Dickens", "C. Jane Austen", "D. Mark Twain", "A"}
    };

    public static void main(String[] args) {
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                showResult();
                System.exit(0);
            }
        }, 30000);

        while (currentQuestion < questions.length) {
            System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion][0]);
            for (int i = 1; i < questions[currentQuestion].length - 1; i++) {
                System.out.println(questions[currentQuestion][i]);
            }
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(questions[currentQuestion][5])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
            currentQuestion++;
        }

        showResult();
        timer.cancel();
    }

    private static void showResult() {
        System.out.println("\n--- Quiz Results ---");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (questions.length - score));
    }
}