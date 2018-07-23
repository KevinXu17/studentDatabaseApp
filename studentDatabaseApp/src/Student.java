import exception.IncorrectMoneyException;
import exception.NoEnoughtMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;

    private List<Course> courses;

    private static int id = 1001;

    private StudentTuition balance;

    //constructor: prompt user to enter student's name and year
    public Student() {
        Scanner input = new Scanner(System.in);

        //NAME
        System.out.println("Please enter student's first name: ");
        firstName = input.nextLine();
        System.out.println("Please enter student's last name: ");
        lastName = input.nextLine();
        System.out.println(firstName + " " + lastName);

        //YEAR
        System.out.println("Please enter student's class level: \n 1: First Year \n 2: Second Year \n 3: Third Year \n 4: Forth Year");
        gradeYear = input.nextInt();

        //ID
        setStudentID();

        //new courses
        courses = new ArrayList<>();

        //create tuition : 0
        balance = new StudentTuition();




    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getTuitionBalance() {
        return balance.getTuitionBalance();
    }

    public List<Course> getCourses() {
        return courses;
    }


    public static int getId() {
        return id;
    }

    //generate an ID
    private void setStudentID() {
        // Grade level + ID
        studentID = Integer.toString(gradeYear * 10000 + id);

        id++;
    }

    //Enroll in courses
    public void enroll(Course course) {
        if (course.getPreCourse() == null || courses.containsAll(course.getPreCourse())) {
            try {
                payTuition(course);
                courses.add(course);
            } catch (NoEnoughtMoneyException e) {
                System.out.println("No enought balance.");
            }
        } else if (!courses.containsAll(course.getPreCourse())) {
            System.out.println("No enough pre-course");
        }
    }

    //View balance
    public void getBalance(){
        System.out.println("The balance is: " + getTuitionBalance());
    }

    //Pay Tuition
    private void payTuition(Course course) throws NoEnoughtMoneyException {
        if (getTuitionBalance() < course.getCost()) {
            throw new NoEnoughtMoneyException("Your balance is not enought.");
        }
        balance.payTuition(course.getCost());
    }

    //debit balance
    public void debitBalance(int i)  {
        try {
            balance.debitMoney(i);
        } catch (IncorrectMoneyException e) {
            System.out.println("Please insert the correct number of money.");
        }
    }


    //Show status
    public void checkInfo( ) {
        System.out.println("The student's name: "+ firstName + " " + lastName);
        System.out.println("Class level: "+ gradeYear);
        System.out.println("Student ID: " + studentID);
        System.out.println("Tuition balance: " + getTuitionBalance());

        System.out.println("The courses the student taked: ");
        List<Course> cs = getCourses();
        if (cs.size() == 0) {
            System.out.println("No courses the students have taken.");
        } else {
            for (int i = 0; i < cs.size(); i++) {
                System.out.println(cs.get(i).getCourseName());
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(studentID, student.studentID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentID);
    }
}
