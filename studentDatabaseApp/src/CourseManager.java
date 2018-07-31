import java.util.ArrayList;
import java.util.List;


public class CourseManager {
    public static CourseManager instance;

    private List<Course> courseList;

    private CourseManager() {
        courseList = new ArrayList<>();
    }

    //instance of class
    public static CourseManager getInstance() {
        if (instance == null) {
            instance = new CourseManager();
        }
        return instance;
    }

    //add course by name cost pre-course credit
    public void addCourse(String courseName, int cost, List<Course> pc, int credit) {
        int check = 0;
        for (int i = 0; i < courseList.size(); i++) {
             if (courseList.get(i).getCourseName().equals(courseName))
            check = 1;
        }
        if (check == 0) {
            Course c = new Course(courseName, cost, pc, credit);
            courseList.add(c);
        }
    }


    //add course by course
    public void addCourse(Course c) {
        int check = 0;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(c.getCourseName()))
            check = 1;
        }
        if (check == 0) {
            courseList.add(c);
        }
    }


    // return a course by name if it is in instance
    public Course findCourseByName(String name) {
        int n = getNumCourses();
        for (int i = 0; i < n; i++) {
            if (courseList.get(i).getCourseName().equals(name))
                return courseList.get(i);
        }
        return null;
    }




    public int getNumCourses() {
        return courseList.size();
    }

    public void clearCourse() {
        courseList.clear();
    }


}
