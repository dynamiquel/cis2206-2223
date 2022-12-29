package pointers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StudentSupportOffice {
    public Map<String, Module> getAndCreateDefaultModules(Comparator<Student> comparator) {
        // Creates the required modules with the specified comparator.
        // Using a hash map to store modules as it makes it easier and faster to reference by ModuleID.
        var modules = new HashMap<String, Module>(3);
        modules.put("CIS2344", new Module("CIS2344", comparator));
        modules.put("CIS2360", new Module("CIS2360", comparator));
        modules.put("CIM2130", new Module("CIM2130", comparator));

        return modules;
    }

    public Map<String, Student> getAndCreateDefaultStudents() {
        // Using a hash map to store students as it makes it easier and faster to reference by StudentID.
        var students = new HashMap<String, Student>(5);

        // Complex Student Creation
        // Creates Students with a unique ID, in addition to basic attributes.
        var student = new Student("U0000001", "Hall", "Liam", 22);
        students.put(student.getStudentId(), student);

        student = new Student("U0000002", "Sinla", "Nari", 30);
        students.put(student.getStudentId(), student);

        student = new Student("U0000003", "Conhee", "Drea", 20);
        students.put(student.getStudentId(), student);

        student = new Student("U0000004", "Foster", "Harry", 21);
        students.put(student.getStudentId(), student);

        student = new Student("U0000005", "Musk", "Elon", 51);
        students.put(student.getStudentId(), student);

        return students;
    }

    public void defaultEnrollment(Map<String, Module> modules, Map<String, Student> students)
    {
        // The default enrollment criteria as specified in the assignment.
        modules.get("CIS2344").enroll(students.get("U0000001"));
        modules.get("CIS2344").enroll(students.get("U0000004"));

        modules.get("CIS2360").enroll(students.get("U0000001"));
        modules.get("CIS2360").enroll(students.get("U0000003"));
        modules.get("CIS2360").enroll(students.get("U0000005"));

        modules.get("CIM2130").enroll(students.get("U0000003"));
        modules.get("CIM2130").enroll(students.get("U0000004"));
        modules.get("CIM2130").enroll(students.get("U0000005"));
    }

    public void enrollmentChanges(Map<String, Module> modules, Map<String, Student> students)
    {
        // The end of enrollment criteria as specified in the assignment.
        modules.get("CIS2344").enroll(students.get("U0000002"));
        modules.get("CIS2344").enroll(students.get("U0000003"));
        // Evidence that duplicate students can't exist.
        modules.get("CIS2344").enroll(students.get("U0000004"));
        modules.get("CIS2344").enroll(students.get("U0000005"));

        modules.get("CIS2360").enroll(students.get("U0000002"));
        modules.get("CIS2360").disenroll(students.get("U0000003"));


        modules.get("CIM2130").enroll(students.get("U0000001"));
        modules.get("CIM2130").disenroll(students.get("U0000005"));
    }
}
