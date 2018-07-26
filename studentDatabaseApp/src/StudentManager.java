import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    public static StudentManager instance;

    private Map<String, Student> studentMap;
    private Student selected;

    private StudentManager() {
        studentMap = new HashMap<>();
        selected = null;
    }

    //instance of class
    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    //add student
    public void addStudent() {
        Student s = new Student();
        studentMap.put(s.getStudentID(), s);
    }

    //add n student
    public   void addNStudents(int n) {
        for (int i = 0; i < n; i++) {
            addStudent();
        }
    }


    /**
     * get student selected with given student id (String)
     */
    public void getStudentWithId(String id) {
        if (studentMap.containsKey(id)) {
            selected = studentMap.get(id);
            System.out.println("Student info: ");
            selected.checkInfo();
        } else {
            System.out.println("Sorry, can not find this id student.");
        }
    }


    public int getNumStudents() {
        return studentMap.size();
    }

    public void clearStudents() {
        studentMap.clear();
    }


}
