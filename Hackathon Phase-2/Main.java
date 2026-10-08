import java.util.Scanner;

class Student {
    String studentName, courseName;
    int rollNumber, courseCredits;
    double marks;

   
    Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) return fee * 0.20;
        if (marks >= 70) return fee * 0.10;
        return 0;
    }

    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    void displayDetails() {
        System.out.println("Name: " + studentName + "\nRoll: " + rollNumber + "\nMarks: " + marks);
        System.out.println("Course: " + courseName + "\nCredits: " + courseCredits);
        System.out.println("Eligible: " + checkEligibility());
        System.out.println("Total Fee: " + calculateFee());
        System.out.println("Scholarship: " + calculateScholarship());
        System.out.println("Final Fee: " + calculateFinalFee());
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name, Roll, Marks, Course, Credits: ");
        Student s = new Student(sc.next(), sc.nextInt(), sc.nextDouble(), sc.next(), sc.nextInt());

        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("Student is not eligible for registration.");
        }
        
        sc.close();
    }
}