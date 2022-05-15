namespace Lists;

public class Tests
{
    [Xunit.Fact]
    public void ValidateContainsDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);

        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000001");
        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000004");
        
        Xunit.Assert.Contains(modules["CIS2360"].Students, x => x.StudentId == "U0000001");
        Xunit.Assert.Contains(modules["CIS2360"].Students, x => x.StudentId == "U0000003");
        Xunit.Assert.Contains(modules["CIS2360"].Students, x => x.StudentId == "U0000005");

        Xunit.Assert.Contains(modules["CIM2130"].Students, x => x.StudentId == "U0000003");
        Xunit.Assert.Contains(modules["CIM2130"].Students, x => x.StudentId == "U0000004");
        Xunit.Assert.Contains(modules["CIM2130"].Students, x => x.StudentId == "U0000005");
    }
    
    [Xunit.Fact]
    public void ValidateOrderedByIdDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules(new StudentIdComparer());
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);

        Xunit.Assert.True(modules["CIS2344"].Students[0].StudentId == "U0000001");
        Xunit.Assert.True(modules["CIS2344"].Students[1].StudentId == "U0000004");
        
        Xunit.Assert.True(modules["CIS2360"].Students[0].StudentId == "U0000001");
        Xunit.Assert.True(modules["CIS2360"].Students[1].StudentId == "U0000003");
        Xunit.Assert.True(modules["CIS2360"].Students[2].StudentId == "U0000005");

        Xunit.Assert.True(modules["CIM2130"].Students[0].StudentId == "U0000003");
        Xunit.Assert.True(modules["CIM2130"].Students[1].StudentId == "U0000004");
        Xunit.Assert.True(modules["CIM2130"].Students[2].StudentId == "U0000005");
    }

    [Xunit.Fact]
    public void ValidateDefaultGradesFromStudent()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);
        IReadOnlyList<Grade> grades = office.CreateDefaultGrades(modules, students);
        office.RegisterGrades(grades);
        
        Xunit.Assert.NotNull(students["U0000001"].GetGradeForModule(modules["CIS2344"]));
        Xunit.Assert.NotNull(students["U0000004"].GetGradeForModule(modules["CIS2344"]));
        Xunit.Assert.NotNull(students["U0000003"].GetGradeForModule(modules["CIS2360"]));
        Xunit.Assert.Null(students["U0000003"].GetGradeForModule(modules["CIS2344"]));
        
        Xunit.Assert.Equal(2, students["U0000001"].Grades.Count);
    }

    [Xunit.Fact]
    public void ValidateDefaultGradesFromModule()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);
        IReadOnlyList<Grade> grades = office.CreateDefaultGrades(modules, students);
        office.RegisterGrades(grades);
        
        Xunit.Assert.Equal(2, modules["CIS2344"].Grades.Count);
        Xunit.Assert.Equal(3, modules["CIS2360"].Grades.Count);
        Xunit.Assert.Equal(3, modules["CIM2130"].Grades.Count);
        
        Xunit.Assert.NotNull(modules["CIS2344"].Grades.FirstOrDefault(g => g.Student == students["U0000001"]));
        Xunit.Assert.NotNull(modules["CIS2344"].Grades.FirstOrDefault(g => g.Student == students["U0000004"]));
        Xunit.Assert.Null(modules["CIS2344"].Grades.FirstOrDefault(g => g.Student == students["U0000003"]));
        Xunit.Assert.NotNull(modules["CIM2130"].Grades.FirstOrDefault(g => g.Student == students["U0000005"]));
    }
    
    [Xunit.Fact]
    void ValidateModuleAverageGradeScores()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);
        IReadOnlyList<Grade> grades = office.CreateDefaultGrades(modules, students);
        office.RegisterGrades(grades);
        
        Xunit.Assert.Equal(68, modules["CIS2344"].AverageScore);
        Xunit.Assert.Equal(54.67, (double)modules["CIS2360"].AverageScore, 2);
        Xunit.Assert.Equal(52.67, (double)modules["CIM2130"].AverageScore, 2);
    }
    
    [Xunit.Fact]
    void ValidateStudentAverageGradeScores()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);
        IReadOnlyList<Grade> grades = office.CreateDefaultGrades(modules, students);
        office.RegisterGrades(grades);
        
        Xunit.Assert.Equal(72, (double)students["U0000001"].AverageScore, 2);
        Xunit.Assert.Equal(null, students["U0000002"].AverageScore);
        Xunit.Assert.Equal(64.5, (double)students["U0000003"].AverageScore, 2);
    }
}