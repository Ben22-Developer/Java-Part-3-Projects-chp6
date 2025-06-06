import javax.swing.JOptionPane;

public class Main {

    private static String attention = "\nNote that every question is answered by an integer answer only\nThis program ignore the decimal part of answers\nExample 1/2 = 0.5, In this program just type 0 as the answer\nAnother example: 19/6 = 3.1666, In this program just type 3 as the answer\nPlease do it cause it will cause an error if u don't";


    private static char setMathOperator () {

        String addition = "Press '+' to use only addition operator";
        String substraction = "Press '-' to use only substraction operator";
        String multiplication = "Press '*' to use only multiplication operator";
        String division = "Press '/' to use only division operator";
        String all = "Press '@' to use all operations randomly";

        String operator_str = JOptionPane.showInputDialog(addition+"\n"+substraction+"\n"+multiplication+"\n"+division+"\n"+attention);
        char operator_char = operator_str.charAt(0);

        return operator_char;
    }

    private static int setMathQuestionsDifficulty () {

        String easy = "Press 1 to be asked questions which consist only of 1 digit";
        String medium = "Press 2 to be asked questions which consist 1 digit and 2 digits";
        String hard = "Press 3 to be asked questions which consist 1 digit, 2 digits and 3 digits";

        int questionDifficulty = Integer.parseInt(JOptionPane.showInputDialog(easy+"\n"+medium+"\n"+hard+"\n"+attention));

        return questionDifficulty;
    }

    private static String getStudentName () {
        String studentName = JOptionPane.showInputDialog("Enter your name and press 'ok' button to continue");
        return studentName;
    }

    private static void mainMathQuestionsController () {
        int user_response = Integer.parseInt(JOptionPane.showInputDialog("Welcome to our app it will help you learn mathematics like a pro!!\nProve yourself capable and get 70% for the first "+MathQuestions.total_questions_to_be_asked+" questions\nPress any number which is not 0 to continue"));

        while (user_response != 0) {

            String student_name = getStudentName();
            Student a_student = new Student(student_name);

            int difficultyLevel = setMathQuestionsDifficulty();
            char operatorUsed = setMathOperator();

            boolean setup_success = MathQuestions.mathQuestionsSetup (difficultyLevel,operatorUsed);

            if (!setup_success) {
                user_response =Integer.parseInt(JOptionPane.showInputDialog(a_student.getName()+" You have made a mistake in providing wrong inputs please be careful next time\nPress 1 to setup again or 0 to go out of the program:"));

                if (user_response != 0) {
                    continue;
                }
                else {
                    break;
                }
            }

            MathQuestions.getQuestion(a_student);

            user_response = Integer.parseInt(JOptionPane.showInputDialog("For the next student\nPress any number which is not 0 to continue:"));
            a_student = null;
        }
    }


    public static void main (String[] args) {

        mainMathQuestionsController();
        JOptionPane.showMessageDialog(null,"Be back soon never hesitate Mathematician");
   }
}
