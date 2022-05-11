namespace Pointers;

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
    public void ValidateOrderedByNameDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules(new StudentNameComparer());
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);

        Xunit.Assert.True(modules["CIS2344"].Students[0].Surname == "Foster");
        Xunit.Assert.True(modules["CIS2344"].Students[1].Surname == "Hall");
        
        Xunit.Assert.True(modules["CIS2360"].Students[0].Surname == "Conhee");
        Xunit.Assert.True(modules["CIS2360"].Students[1].Surname == "Hall");
        Xunit.Assert.True(modules["CIS2360"].Students[2].Surname == "Musk");

        Xunit.Assert.True(modules["CIM2130"].Students[0].Surname == "Conhee");
        Xunit.Assert.True(modules["CIM2130"].Students[1].Surname == "Foster");
        Xunit.Assert.True(modules["CIM2130"].Students[2].Surname == "Musk");
    }
    
    [Xunit.Fact]
    public void ValidateOrderedByAgeDefaultEnrollment()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules(new StudentAgeComparer());
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);

        Xunit.Assert.True(modules["CIS2344"].Students[0].Age == 20);
        Xunit.Assert.True(modules["CIS2344"].Students[1].Age == 21);
        
        Xunit.Assert.True(modules["CIS2360"].Students[0].Age == 19);
        Xunit.Assert.True(modules["CIS2360"].Students[1].Age == 21);
        Xunit.Assert.True(modules["CIS2360"].Students[2].Age == 40);

        Xunit.Assert.True(modules["CIM2130"].Students[0].Age == 19);
        Xunit.Assert.True(modules["CIM2130"].Students[1].Age == 20);
        Xunit.Assert.True(modules["CIM2130"].Students[2].Age == 40);
    }
    
    [Xunit.Fact]
    public void ValidateContainsEnrollmentChanges()
    {
        var office = new StudentSupportOffice();
        IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
        IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

        office.DefaultEnrollment(modules, students);
        office.EnrollmentChanges(modules, students);

        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000001");
        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000002");
        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000003");
        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000004");
        Xunit.Assert.Contains(modules["CIS2344"].Students, x => x.StudentId == "U0000005");
        Xunit.Assert.Equal(5, modules["CIS2344"].ClassCount);
        
        Xunit.Assert.Contains(modules["CIS2360"].Students, x => x.StudentId == "U0000001");
        Xunit.Assert.Contains(modules["CIS2360"].Students, x => x.StudentId == "U0000002");
        Xunit.Assert.Contains(modules["CIS2360"].Students, x => x.StudentId == "U0000005");
        Xunit.Assert.Equal(3, modules["CIS2360"].ClassCount);

        Xunit.Assert.Contains(modules["CIM2130"].Students, x => x.StudentId == "U0000001");
        Xunit.Assert.Contains(modules["CIM2130"].Students, x => x.StudentId == "U0000003");
        Xunit.Assert.Contains(modules["CIM2130"].Students, x => x.StudentId == "U0000004");
        Xunit.Assert.Equal(3, modules["CIM2130"].ClassCount);
    }
}