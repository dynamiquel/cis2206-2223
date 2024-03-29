package Practical_11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class StudentTests {
    @Test
    public void ValidateContainsDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        Map<String, Module> modules = office.getAndCreateDefaultModules(new StudentIdComparator());
        Map<String, Student> students = office.getAndCreateDefaultStudents();

        office.defaultEnrollment(modules, students);

        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000005"));

        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000003"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));

        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000002"));
        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));
        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000005"));
    }

    @Test
    public void ValidateOrderedByIdDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        Map<String, Module> modules = office.getAndCreateDefaultModules(new StudentIdComparator());
        Map<String, Student> students = office.getAndCreateDefaultStudents();

        office.defaultEnrollment(modules, students);

        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000005"));

        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000003"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));

        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000002"));
        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));
        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000005"));
    }

    @Test
    public void ValidateOrderedByNameDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        Map<String, Module> modules = office.getAndCreateDefaultModules(new StudentNameComparator());
        Map<String, Student> students = office.getAndCreateDefaultStudents();

        office.defaultEnrollment(modules, students);

        assertEquals(modules.get("CIS2206").getStudents().get(0).getSurname(), "Hall");
        assertEquals(modules.get("CIS2206").getStudents().get(1).getSurname(), "Musk");

        assertEquals(modules.get("CIS2360").getStudents().get(0).getSurname(), "Conhee");
        assertEquals(modules.get("CIS2360").getStudents().get(1).getSurname(), "Foster");
        assertEquals(modules.get("CIS2360").getStudents().get(2).getSurname(), "Hall");

        assertEquals(modules.get("CIS2205").getStudents().get(0).getSurname(), "Foster");
        assertEquals(modules.get("CIS2205").getStudents().get(1).getSurname(), "Musk");
        assertEquals(modules.get("CIS2205").getStudents().get(2).getSurname(), "Sinla");
    }

    @Test
    public void ValidateOrderedByAgeDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        Map<String, Module> modules = office.getAndCreateDefaultModules(new StudentAgeComparator());
        Map<String, Student> students = office.getAndCreateDefaultStudents();

        office.defaultEnrollment(modules, students);

        assertEquals(modules.get("CIS2206").getStudents().get(0).getAge(), 22);
        assertEquals(modules.get("CIS2206").getStudents().get(1).getAge(), 51);

        assertEquals(modules.get("CIS2360").getStudents().get(0).getAge(), 20);
        assertEquals(modules.get("CIS2360").getStudents().get(1).getAge(), 21);
        assertEquals(modules.get("CIS2360").getStudents().get(2).getAge(), 22);

        assertEquals(modules.get("CIS2205").getStudents().get(0).getAge(), 21);
        assertEquals(modules.get("CIS2205").getStudents().get(1).getAge(), 30);
        assertEquals(modules.get("CIS2205").getStudents().get(2).getAge(), 51);
    }

    @Test
    public void ValidateContainsEnrollmentChanges()
    {
        var office = new StudentSupportOffice();
        Map<String, Module> modules = office.getAndCreateDefaultModules(new StudentIdComparator());
        Map<String, Student> students = office.getAndCreateDefaultStudents();

        office.defaultEnrollment(modules, students);
        office.enrollmentChanges(modules, students);

        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000003"));
        assertTrue(modules.get("CIS2206").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));
        assertEquals(modules.get("CIS2206").getClassCount(), 3);

        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000003"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000005"));
        assertTrue(modules.get("CIS2360").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000005"));
        assertEquals(modules.get("CIS2360").getClassCount(), 5);

        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000001"));
        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000003"));
        assertTrue(modules.get("CIS2205").getStudents().stream().anyMatch(
                x -> x.getStudentId() == "U0000004"));
        assertEquals(modules.get("CIS2205").getClassCount(), 3);
    }
}
