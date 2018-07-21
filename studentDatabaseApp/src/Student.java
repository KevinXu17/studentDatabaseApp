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
    private int tuitionBalance;
    private List<Course> courses;

    private static int id = 1001;

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
        return tuitionBalance;
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
        if (!courses.containsAll(course.getPreCourse())) {
            System.out.println("No enough pre-course");
        } else {
            try {
                payTuition(course);
            } catch (NoEnoughtMoneyException e) {
                System.out.println("No enought balance.");
            }
        }
    }

    //View balance
    public void getBalance(){
        System.out.println("The balance is: " + tuitionBalance);
    }

    //Pay Tuition
    private void payTuition(Course course) throws NoEnoughtMoneyException {
        if (this.tuitionBalance < course.getCost()) {
            throw new NoEnoughtMoneyException("Your balance is not enought.");
        }
        tuitionBalance -= course.getCost();
    }

    //debit balance
    public void debitBalance(int i) throws IncorrectMoneyException {
        if (i <= 0) {
            throw new IncorrectMoneyException("Please insert the correct number.");
        }
        tuitionBalance += i;
    }


    //Show status
    public void checkInfo( ) {
        System.out.println("The student's name: "+ firstName + " " + lastName);
        System.out.println("Class level: "+ gradeYear);
        System.out.println("Student ID: " + studentID);
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
