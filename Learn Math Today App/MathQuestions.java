import jdk.dynalink.Operation;

import java.security.SecureRandom;
import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.JOptionPane;

public class MathQuestions {


    private static SecureRandom randomize = new SecureRandom();

    private static enum ToBeUsedOperator {ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, ALL};
    private static ToBeUsedOperator math_operator;

    private static int number1, number2, answer;
    private static int bound;
    private static char operator_being_used;
    private static String message_to_display;
    private static boolean set_another_question = true;
    private static int questions_asked;
    private static int right_answered_questions;
    public static int total_questions_to_be_asked = 10;


    private static double getRawStudentMarks () {
        double student_marks = (double) right_answered_questions/questions_asked;
        return student_marks;
    }

    private static void calculatePercentageForStudent () {

        double student_marks = getRawStudentMarks();
        double student_percentage = student_marks * 100;

        String win = "You have really nailed it! Keep up the good work\nCongratulations\nFlowers and fruits!!\nYour marks: "+student_percentage+"%";
        String mid = "You are at mid level, please continue refreshening the maths and seek for more practice\nYour marks: "+student_percentage+" %";
        String low = "You have failed, please seek for help and study hard for the next challenge!\nYour marks: "+student_percentage+"%";

        if (student_percentage >= 70)
            JOptionPane.showMessageDialog(null,win);
        else if (student_percentage < 70 && student_percentage >= 50)
            JOptionPane.showMessageDialog(null,mid);
        else
            JOptionPane.showMessageDialog(null,low);
    }


    private static String winningMessages () {
        String message = "";
        int num = randomize.nextInt(3);

        switch (num) {
            case 0 -> message += "Excellent!\nU got it right congratulations!\nMuscle up with a new challenge then";
            case 1 -> message += "Very good!\nEven sad panda approve your excellence!\nDo it again king";
            case 2 -> message += "Nice work!\nProve it real, roll another question kid";
        }

        message += "\nPress 1 to get another challenge and 0 to stop: ";
        return message;
    }



    private static int displayWinMessage () {

        String message_to_display = winningMessages();
        int next = Integer.parseInt(JOptionPane.showInputDialog(message_to_display));
        return next;
    }


    private static String losingMessages () {

        String message = "";
        int num = randomize.nextInt(2);

        switch (num) {
            case 0 -> message += "Outch! try again\nYou were almost there";
            case 1 -> message += "Never give up\nNo pain no gain";
        }

        message += "\nPress 1 to try again the challenge and 0 to stop: ";
        return message;
    }


    private static int displayLossMessage () {

        String message_to_display = losingMessages();
        int next = Integer.parseInt(JOptionPane.showInputDialog(message_to_display));
        return next;
    }


    private static void setMessageToDisplayWhenAskingStudent (Student a_student) {

        int num = randomize.nextInt(3);

        switch (num) {
            case 0 -> message_to_display = "Let's see what you got little genius";
            case 1 -> message_to_display = "Make the difference now\nProve it's a better "+a_student.getName()+" than before";
            case 2 -> message_to_display = "Quick warm up "+a_student.getName();
        }
    }

    private static void askingStudentTheQuestionUI () {

        String msg_to_display = "Question number "+ questions_asked +"/"+total_questions_to_be_asked+"\n"+"Your current score: "+right_answered_questions +" / "+ (questions_asked - 1) +"\n"+ message_to_display + "\n" + "What is: " + number1 + " " + operator_being_used + " "+ number2 + " ?";

        int student_answer = Integer.parseInt(JOptionPane.showInputDialog(msg_to_display));

        if (student_answer == answer) {
            right_answered_questions ++;
            set_another_question = true;
        }
        else {
            set_another_question = false;
        }
    }

    private static void setNewQuestion () {
        number1 = 1 + randomize.nextInt((int)Math.pow(10,bound));
        number2 = 1 + randomize.nextInt((int)Math.pow(10,bound));

        operator_being_used = setOperator();

        switch (operator_being_used) {
            case '+':
                answer = (int) number1 + number2;
            break;
            case '-':
                answer = (int) number1 - number2;
            break;
            case '*':
                answer = (int) number1 * number2;
            break;
            case '/':
                answer = (int) number1 / number2;
            break;
        }
    }

    private static char setOperator () {
        char operator = 'a';
        if (math_operator == ToBeUsedOperator.ADDITION)
            operator = '+';
        else if (math_operator == ToBeUsedOperator.SUBSTRACTION)
            operator = '-';
        else if (math_operator == ToBeUsedOperator.DIVISION)
            operator = '/';
        else if (math_operator == ToBeUsedOperator.MULTIPLICATION)
            operator = '*';
        else if (math_operator == ToBeUsedOperator.ALL)
            operator = chose_random_operator();

        return operator;
    }

    private static char chose_random_operator () {

        char operator = 'a';
        int random = randomize.nextInt(4);
        switch (random) {
            case 0:
                 operator = '+';
            break;
            case 1:
                 operator = '-';
            break;
            case 2:
                 operator = '*';
            break;
            case 3:
                 operator = '/';
            break;
        }
        return operator;
    }

    private static void setRandom_numbersBound (int user_chosen_bound) {
        bound = user_chosen_bound;
    }

    private static void setMathOperator (char user_chosen_operator) {

        switch (user_chosen_operator) {
            case '*' -> math_operator = ToBeUsedOperator.MULTIPLICATION;
            case '/' -> math_operator = ToBeUsedOperator.DIVISION;
            case '+' -> math_operator = ToBeUsedOperator.ADDITION;
            case '-' -> math_operator = ToBeUsedOperator.SUBSTRACTION;
            case '@' -> math_operator = ToBeUsedOperator.ALL;
        }
    }

    public static boolean mathQuestionsSetup (int bound, char operator) {

        if ((bound >= 0 && bound < 4) &&
           (operator == '*' || operator == '/' || operator == '+' || operator == '-' || operator == '@'))
        {
            startQuiz();
            setRandom_numbersBound (bound);
            setMathOperator (operator);
            return true;
        }
        return false;
    }



    private static void startQuiz () {
        questions_asked = 1;
        right_answered_questions = 0;
    }

    public static void getQuestion (Student a_student) {

        int get_a_question = 1;

        while (get_a_question != 0) {

            setMessageToDisplayWhenAskingStudent(a_student);

            if (set_another_question) {
                setNewQuestion();
            }
            askingStudentTheQuestionUI();

            if (questions_asked < total_questions_to_be_asked) {
                get_a_question = set_another_question ? displayWinMessage() : displayLossMessage();
            }
            else {
                calculatePercentageForStudent();
                break;
            }
            questions_asked++;
        }
    }

}
