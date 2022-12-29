package pointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class representing a Module, containing a sorted list of Students.
 */
public class Module {
    private String moduleId;
    private List<Student> students;
    private Comparator<Student> studentComparator;

    public Module(String moduleId, Comparator<Student> studentComparator) {
        this.moduleId = moduleId;
        students = new ArrayList<>(5);

        // If no Student Comparator is selected, use the default comparator (by StudentId).
        if (studentComparator == null)
            studentComparator = new StudentIdComparator();

        this.studentComparator = studentComparator;
    }

    public String getModuleId() {
        return moduleId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getClassCount() {
        return students.size();
    }

    /**
     * Adds a new specified Student to the Module.
     * @param student The new student to enroll.
     * @return True if enrolled.
     */
    public boolean enroll(Student student) {
        if (student == null)
            return false;

        if (students.contains(student))
            return false;

        students.add(student);
        students.sort(studentComparator);

        return true;
    }

    /**
     * Removes a specified Student from the Module.
     * @param student The student to disenroll.
     * @return True if the student was disenrolled.
     */
    public boolean disenroll(Student student) {
        return students.remove(student);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(15 * getClassCount());

        sb.append("Class: ");
        sb.append(getModuleId());
        sb.append("\n");

        for (int i = 0; i < students.size(); i++) {
            sb.append("Student ");
            sb.append(i);
            sb.append(": ");
            sb.append(students.get(i).toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
