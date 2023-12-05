package cs1102.projects;
import java.util.Scanner;

public class QuizGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		// questions and their correct answers
		String[] question = {
				"Who was the first democratically elected governor of Akwa Ibom state?",
				"Who invented Java programming language?",
				"What is the color of the sun?",
				"What is the largest mammal on earth?",
				"Who is the erstwhile president of Nigeria? "
		};
		
		// options for answer
		String[] options = {
				    "A. Akpan Isemin   B. Udom Emmanuel    C. Obong Attah   D. Umo Eno",
	                "A. Elon Musk    B. James Gosling    C. James Bond D. Samuel Peter",
	                "A. Black B. White   C. Green  D. Indigo",
	                "A. Cat  B. Blue Whale  C. Lion   D. Elephant",
	                "A. Muhammadu Buhari   B. Bola Tinubu C. Clement Isong   D. Olusegun Obansanjo"
		};
		
		// Display and process each question
		char[] correctAnswers = {'C', 'B', 'B', 'B', 'A'};
		int totalQuestions = question.length;
		int correctResponses = 0;
		
		for (int i = 0; i < totalQuestions; i++) {
			 // Display the question
			System.out.println(question[i]);
			System.out.println(options[i]);
			
			  // Prompt user for input
			System.out.print("Your answer (A, B, C, or D): ");
			char userAnswer = scanner.next().toUpperCase().charAt(0);
			
			
			// Check if the user's answer is correct using switch case
			switch (userAnswer) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
                if (userAnswer == correctAnswers[i]) {
                    System.out.println("Correct!\n");
                    correctResponses++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".\n");
                }
                break;
            default:
                System.out.println("Invalid input. Please enter A, B, C, or D.\n");
                break;
        }
			
    
		}
		
		 // Calculate and display the final score
		double score = (double) correctResponses / totalQuestions * 100;
        System.out.println("Your final score: " + score + "%");

        // Close the scanner to prevent resource leak
        scanner.close();
		};
		
		

	};

