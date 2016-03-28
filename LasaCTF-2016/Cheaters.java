import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cheaters {

    public static ArrayList<Character> A = new ArrayList<>();
    public static ArrayList<Character> B = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("studentdata.dat"));
        scan.next();scan.next();scan.next();scan.next();
        String formA = scan.next();
        scan.next();scan.next();scan.next();scan.next();
        String formB = scan.next();
        ArrayList<Student> students = new ArrayList<>();

        /**********************Parsing Input**********************/
        for (int i = 0; i < formA.length(); i++) {
            A.add(formA.charAt(i));
            B.add(formB.charAt(i));
        }
        scan.nextLine(); // go to the next line so the whole thing doesn't get rekt
        String currentLine;
        Scanner scan2;
        char form;
        String name, temp;
        ArrayList<Character> answers = new ArrayList<>();
        double grade;
        while (scan.hasNextLine()) {
            currentLine = scan.nextLine();
            scan2 = new Scanner(currentLine);
            form = scan2.next().charAt(0);
            temp = scan2.next() + " " + scan2.next();
            name = temp.substring(0, temp.length() - 1);
            grade = scan2.nextDouble();
            temp = scan2.next();
            for (int i = 0; i < temp.length(); i++) {
                answers.add(temp.charAt(i));
            }
            students.add(new Student(name, grade, answers, form));
            answers.clear();
        }
        /**********************Parsing Input**********************/

        //students.forEach(System.out::println);

        /**********************Gather Statistical Data**********************/
        //compute average score for tests
        double sumA = 0.0, sumB = 0.0;
        int countA = 0, countB = 0;
        for (Student s : students) {
            if (s.getForm() == 'A') {
                sumA += s.getGrade();
                countA++;
            } else {
                sumB += s.getGrade();
                countB++;
            }
        }
        double Form_A_Average = sumA / countA;
        double Form_B_Average = sumB / countB;
        //System.out.println("Form A Average Score: " + Form_A_Average);
        //System.out.println("Form B Average Score: " + Form_B_Average);

        //compute the average percentage of incorrect
        //answers with letter choices that are NOT correct on the opposite form
        //i.e. the proportion of completely incorrect answers that are not suspect of cheating
        double p_hat;
        ArrayList<Double> sample_proportions = new ArrayList<>();
        for (Student s : students) {
            p_hat = get_pHat(s);
            if (p_hat != 0.0)
                sample_proportions.add(p_hat);
        }
        double prop_sum = 0.0, population_average_percentage;
        for (double d : sample_proportions)
            prop_sum += d;
        population_average_percentage = prop_sum / (double) sample_proportions.size() * 100;
        //System.out.println("Average percentage of incorrect " +
        //        "answers that were incorrect on both forms: " + population_average_percentage);
        //System.out.println("Average percentage of incorrect " +
        //        "answers that were correct on the opposite form: " + (100.0 - population_average_percentage));
        /**********************Gather Statistical Data**********************/

        /**********************Single Proportion Z-Test**********************/

        ArrayList<String> cheaters = new ArrayList<>();

        for (Student s : students) {
            //compute z-score
            p_hat = get_pHat(s);
            double z = (p_hat - (population_average_percentage / 100))
                    / (Math.sqrt(((population_average_percentage / 100)
                    * (1 - (population_average_percentage / 100))) / getN(s)));
            if (z > 4 || z < -4) { //if the z is outrageous
                //System.out.println(z);
                cheaters.add(s.getName().split(" ")[1]);
                //if the z value is above 4 we can be close to 100% positive that this person cheated
            }
        }

        Collections.sort(cheaters);
        System.out.println(cheaters);

        /**********************Single Proportion Z-Test**********************/

    }
    /****************************Utility Methods****************************/
    public static int getN(Student s) {
        int n = 0;
        for(int i = 0; i < s.getAnswers().size(); i++) {
            switch (s.getForm()) {
                case 'A':
                    if (A.get(i) != s.getAnswers().get(i))
                        n++; //count incorrect problems
                    break;
                case 'B':
                    if (B.get(i) != s.getAnswers().get(i))
                        n++; //count incorrect problems
                    break;
            }
        }
        return n;
    }

    public static double get_pHat(Student s) {
        int sum, n; double p_hat = 0.0;
        sum = 0; n = 0;
        for(int i = 0; i < s.getAnswers().size(); i++) {
            switch (s.getForm()) {
                case 'A':
                    if(A.get(i) != s.getAnswers().get(i))
                        n++; //count incorrect problems
                    break;
                case 'B':
                    if(B.get(i) != s.getAnswers().get(i))
                        n++; //count incorrect problems
                    break;
            }
            if(A.get(i) != s.getAnswers().get(i) && B.get(i) != s.getAnswers().get(i))
                sum++; //count incorrect problems that were wrong on BOTH forms
        }
        if(n > 0) //make sure twe don't divide by zero
            p_hat = (double) sum / n; //get percentage for this student

        return p_hat;
    }

    public static double grader(ArrayList<Character> answers, Character Key) {
        int correct = 0;
        switch (Key) {
            case 'A':
                correct = 0;
                for(int i = 0; i < answers.size(); i++) {
                    if (answers.get(i) == B.get(i))
                        correct++;
                }
                break;
            case 'B':
                correct = 0;
                for(int i = 0; i < answers.size(); i++) {
                    if(answers.get(i) == A.get(i))
                        correct++;
                }
                break;
        }
        return (double) correct/200.0 * 100;
    }
    /****************************Utility Methods****************************/
}

class Student {
    private double altGrade;
    private String name;
    private double grade;
    private ArrayList<Character> answers;
    private Character form;

    public Student(String name, double grade, ArrayList<Character> answers, Character form) {
        this.grade = grade;
        this.answers = new ArrayList<>(answers);
        this.form = form;
        this.name = name;
        switch (form) {
            case 'A':
                altGrade = Cheaters.grader(answers, 'A');
                break;
            case 'B':
                altGrade = Cheaters.grader(answers, 'B');
                break;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Grade: " + grade + "\n"
                + "Alt Grade: " + altGrade + "\n"
                + "Form " + form + "\n"
                + "Answers: " + answers + "\n\n";
    }

    public Character getForm() {
        return form;
    }

    public ArrayList<Character> getAnswers() {
        return answers;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}
