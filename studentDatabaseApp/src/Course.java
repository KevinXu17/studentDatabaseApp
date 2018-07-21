import java.util.List;
import java.util.Objects;

public class Course {
    private String courseName;
    private int cost;
    private List<Course> preCourse;
    private int credit;

    public Course(String courseName, int cost, List<Course> preCourse, int credit) {
        this.courseName = courseName;
        this.cost = cost;
        this.preCourse = preCourse;
        this.credit = credit;
    }

    // getter
    public String getCourseName() {
        return courseName;
    }

    public int getCost() {
        return cost;
    }

    public List<Course> getPreCourse() {
        return preCourse;
    }

    public int getCredit() {
        return credit;
    }

    //setter

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPreCourse(List<Course> preCourse) {
        this.preCourse = preCourse;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseName);
    }
}
