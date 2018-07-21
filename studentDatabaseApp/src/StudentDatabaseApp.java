import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentDatabaseApp {
    static HashMap students = new HashMap();


    public  static void addStudents(int n) {
        for (int i = 0; i < n; i++) {
            Student s1 = new Student();
            students.put(s1.getStudentID(),s1);
        }
    }


    public static void main(String[] args) {


        Course cs110 = new Course("cs110", 600, null,4);
        Course cs121 = new Course("cs121", 600, null,4);
        List<Course> preCourseOfcs210 = new ArrayList<>();
        preCourseOfcs210.add(cs110);
        preCourseOfcs210.add(cs121);
        Course cs210 = new Course("cs210", 600, preCourseOfcs210,4);


        //ask how many students we want to add
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students need to add: ");
        int numOfStudent = input.nextInt();

        //create a number of new students
        //addStudents(numOfStudent);

        Student s = new Student();

        s.checkInfo();




    }




}
