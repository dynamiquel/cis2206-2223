package pointers;

import java.util.Comparator;

/**
 * A class representing a uniquely identifiable Student.
 */
public class Student implements Comparable<Student> {
    private String studentId;
    private String surname;
    private String forename;
    private int age;

    public Student(String studentId, String surname, String forename, int age) {
        this.studentId = studentId;
        this.surname = surname;
        this.forename = forename;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        // Using StudentId as the default compare implementation.
        if (this == other)
            return 0;
        if (other == null)
            return 1;

        return studentId.compareTo(other.getStudentId());
    }

    @Override
    public String toString() {
        var sb = new StringBuilder(70);
        sb.append("Student ");
        sb.append(studentId);
        sb.append(": (Surname: '");
        sb.append(surname);
        sb.append("', Forename: '");
        sb.append(forename);
        sb.append("', Age: '");
        sb.append(age);
        sb.append("')");

        return sb.toString();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class StudentIdComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1 == null)
            return -1;
        if (student2 == null)
            return 1;

        return student1.getStudentId().compareToIgnoreCase(student2.getStudentId());
    }
}

class StudentAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1 == null)
            return -1;
        if (student2 == null)
            return 1;

        return Integer.compare(student1.getAge(), student2.getAge());
    }
}

class StudentNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1 == null)
            return -1;
        if (student2 == null)
            return 1;

        // Compares by surname first, then forename.
        var surnameComparison = student1.getSurname().compareToIgnoreCase(student2.getSurname());
        if (surnameComparison != 0)
            return surnameComparison;

        return student1.getForename().compareToIgnoreCase(student2.getForename());
    }
}
