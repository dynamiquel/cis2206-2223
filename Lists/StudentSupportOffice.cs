namespace Lists;

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
        const int studentCount = 5;

        // Using a dictionary to store students as it makes it easier and faster to reference by StudentID.
        var students = new Dictionary<string, Student>(studentCount);

        // Simple Student Creation

        for (var i = 1; i < studentCount + 1; i++)
        {
            var studentId = $"U{i:0000000}";
            students[studentId] = new Student(studentId);
        }

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

    public IReadOnlyList<Grade> CreateDefaultGrades(IReadOnlyDictionary<string, Module> modules,
        IReadOnlyDictionary<string, Student> students)
    {
        return new List<Grade>(8)
        {
            new(modules["CIS2344"], students["U0000001"], 70),
            new(modules["CIS2344"], students["U0000004"], 66),

            new(modules["CIS2360"], students["U0000001"], 74),
            new(modules["CIS2360"], students["U0000003"], 38),
            new(modules["CIS2360"], students["U0000005"], 52),

            new(modules["CIM2130"], students["U0000003"], 91),
            new(modules["CIM2130"], students["U0000004"], 38),
            new(modules["CIM2130"], students["U0000005"], 29)
        };
    }

    public void RegisterGrades(IEnumerable<Grade> grades)
    {
        foreach (var grade in grades)
            grade.Student.AddNewGrade(grade);
    }

    public void UpdateGradeScore(IReadOnlyList<Grade> grades)
    {
        grades[0].Score = 71;
        grades[2].Score = 55;
        grades[4].Score = 21;
    }

    public void AmendGradeViaAddGrade(IReadOnlyList<Grade> grades)
    {
        grades[1].Student.AddNewGrade(new Grade(grades[1].Module, grades[1].Student, 43));
    }

    public void RemoveGrades(IReadOnlyList<Grade> grades)
    {
        grades[1].Destroy();
        grades[3].Destroy();
        grades[5].Destroy();
    }
}