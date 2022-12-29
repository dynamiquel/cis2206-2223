package pointers;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var office = new StudentSupportOffice();
        Map<String, Module> modules = office.getAndCreateDefaultModules(new StudentIdComparator());
        Map<String, Student> students = office.getAndCreateDefaultStudents();

        office.defaultEnrollment(modules, students);

        System.out.println("After Default Enrollment");
        System.out.println("------------------------");
        for (var module : modules.values()) {
            System.out.println(module.toString());
        }

        office.enrollmentChanges(modules, students);

        System.out.println("After Enrollment Changes");
        System.out.println("------------------------");
        for (var module : modules.values()) {
            System.out.println(module.toString());
        }
    }
}
