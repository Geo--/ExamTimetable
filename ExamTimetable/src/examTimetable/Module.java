package examTimetable;
import java.util.*;

public interface Module {
public List<Student> getStudentsEnrolled();
public Exam getExam();
public int numberofstudents();
void enrollStudent(Student student);

}
