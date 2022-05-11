using System.Collections.ObjectModel;

namespace Pointers;

public class StudentSupportOffice
{
    public IReadOnlyDictionary<string, Module> CreateDefaultModules(IComparer<Student>? comparer = null)
    {
        // Creates the required modules with the specified comparer.
        // Using a dictionary to store modules as it makes it easier and faster to reference by ModuleID.
        var modules = new Dictionary<string, Module>
        {
            ["CIS2344"] = new("CIS2344", comparer),
            ["CIS2360"] = new("CIS2360", comparer),
            ["CIM2130"] = new("CIM2130", comparer)
        };

        return modules;
    }

    public IReadOnlyDictionary<string, Student> CreateDefaultStudents()
    {
        // Using a dictionary to store students as it makes it easier and faster to reference by StudentID.
        var students = new Dictionary<string, Student>(5);

        /* Simple Student Creation
        var studentCount = 5;

        for (var i = 1; i < studentCount + 1; i++)
        {
            var studentId = $"U{i:0000000}";
            students[studentId] = new Student(studentId);
        }
        */
        
        // Complex Student Creation
        // Creates Students with a unique ID, in addition to basic attributes.
        var student = new Student("U0000001")
        {
            Surname = "Hall",
            Forename = "Liam",
            Age = 21,
        };
        students[student.StudentId] = student;
        
        student = new Student("U0000002")
        {
            Surname = "Sinla",
            Forename = "Nari",
            Age = 30,
        };
        students[student.StudentId] = student;
        
        student = new Student("U0000003")
        {
            Surname = "Conhee",
            Forename = "Drea",
            Age = 19,
        };
        students[student.StudentId] = student;
        
        student = new Student("U0000004")
        {
            Surname = "Foster",
            Forename = "Harry",
            Age = 20,
        };
        students[student.StudentId] = student;
        
        student = new Student("U0000005")
        {
            Surname = "Musk",
            Forename = "Elon",
            Age = 40,
        };
        students[student.StudentId] = student;
        
        return students;
    }
    
    public void DefaultEnrollment(IReadOnlyDictionary<string, Module> modules, IReadOnlyDictionary<string, Student> students)
    {
        // The default enrollment criteria as specified in the assignment.
        modules["CIS2344"].Enroll(students["U0000001"]);
        modules["CIS2344"].Enroll(students["U0000004"]);
        
        modules["CIS2360"].Enroll(students["U0000001"]);
        modules["CIS2360"].Enroll(students["U0000003"]);
        modules["CIS2360"].Enroll(students["U0000005"]);
        
        modules["CIM2130"].Enroll(students["U0000003"]);
        modules["CIM2130"].Enroll(students["U0000004"]);
        modules["CIM2130"].Enroll(students["U0000005"]);
    }

    public void EnrollmentChanges(IReadOnlyDictionary<string, Module> modules,
        IReadOnlyDictionary<string, Student> students)
    {
        // The end of enrollment criteria as specified in the assignment.

        modules["CIS2344"].Enroll(students["U0000002"]);
        modules["CIS2344"].Enroll(students["U0000003"]);
        // Evidence that duplicate students can't exist.
        modules["CIS2344"].Enroll(students["U0000004"]);
        modules["CIS2344"].Enroll(students["U0000005"]);
        
        modules["CIS2360"].Enroll(students["U0000002"]);
        modules["CIS2360"].Disenroll(students["U0000003"]);

        modules["CIM2130"].Enroll(students["U0000001"]);
        modules["CIM2130"].Disenroll(students["U0000005"]);
    }
}