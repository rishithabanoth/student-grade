import javax.swing.JOptionPane;

public class Main {

    public static String studentgradecalculator(double averagePercentage) {
        if (averagePercentage >= 75 && averagePercentage <=100) {
            return "A";
        }else if (averagePercentage >= 65 && averagePercentage < 75) {
            return "B";
        }else if (averagePercentage >= 50 && averagePercentage < 65) {
            return "C";
        }else if (averagePercentage >= 40 && averagePercentage < 50) {
            return "D";
        }else if (averagePercentage >= 31 && averagePercentage < 40) {
            return "E";
        }else if (averagePercentage >= 0 && averagePercentage < 31) {
            return "F";
        }else {
            return "Invalid percentage"; //this handles any out-of-bound percentages.
        }
    }

    public static void main(String[] args) {
        //Input: Take student's personal information and works using JOptionpane
        String name = JOptionPane.showInputDialog("Enter the student's name:");
        String surname = JOptionPane.showInputDialog("Enter the student's surname:");
        String studentNumber = JOptionPane.showInputDialog("enter the student's number:");

        int numModules = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of modules:"));
        String[] modules = new String[numModules];
        double[] marks = new double[numModules];

        for (int i = 0; i < numModules; i++) {
            modules[i] = JOptionPane.showInputDialog("Enter the name of subject" + (i + 1) + ":");
            marks[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter marks for" + modules[i] + ":"));
        }

        // Calculator Total Marks
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        // Calculate Average Percentage
        double averagePercentage = totalMarks / numModules;

        //Grade Calculation
        String grade = studentgradecalculator(averagePercentage);

        //Display Results
        StringBuilder message = new StringBuilder();
        message.append(String.format("Student Name: %s %s\n", name, surname));
        message.append(String.format("Student Number: %s\n\n", studentNumber));
        message.append("Modules and Marks:\n");

        for (int i = 0; i < numModules; i++){
            message.append(String.format("%s: %.2f\n", modules[i], marks[i]));
        }
        
        message.append("\n");
        message.append(String.format("Total Marks: %.2f\n", totalMarks));
        message.append(String.format("Average Percentage: %.2f%%\n", averagePercentage));
        message.append(String.format("Grade: %s", grade));

        JOptionPane.showMessageDialog(null, message.toString(), "Student Grade Report", JOptionPane.INFORMATION_MESSAGE);
     }
}