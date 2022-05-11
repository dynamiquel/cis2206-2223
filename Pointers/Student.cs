using System.Text;

namespace Pointers;

/// <summary>
/// A class representing a uniquely identifiable Student.
/// </summary>
public class Student : IComparable<Student>
{
    public Student(string studentId)
    {
        StudentId = studentId;
    }

    public string StudentId { get; }
    public string? Surname { get; set; }
    public string? Forename { get; set; }
    public int? Age { get; set; }

    public int CompareTo(Student? other)
    {
        // Using StudentId as the default compare implementation.
        if (ReferenceEquals(this, other)) return 0;
        if (ReferenceEquals(null, other)) return 1;
        return string.Compare(StudentId, other.StudentId, StringComparison.Ordinal);
    }

    public override string ToString()
    {
        var sb = new StringBuilder(70);
        sb.Append($"Student {StudentId}: (");
        sb.Append($"Surname: '{Surname}', ");
        sb.Append($"Forename: '{Forename}', ");
        sb.Append($"Age: '{Age}')");
        
        return sb.ToString();
    }
}

public class StudentIdComparer : IComparer<Student>
{
    public int Compare(Student? x, Student? y)
    {
        if (ReferenceEquals(x, y)) 
            return 0;
        if (ReferenceEquals(null, y)) 
            return 1;
        if (ReferenceEquals(null, x)) 
            return -1;
        
        return string.Compare(x.StudentId, y.StudentId, StringComparison.Ordinal);
    }
}

public class StudentNameComparer : IComparer<Student>
{
    public int Compare(Student? x, Student? y)
    {
        if (ReferenceEquals(x, y)) 
            return 0;
        if (ReferenceEquals(null, y)) 
            return 1;
        if (ReferenceEquals(null, x)) 
            return -1;
        
        // Compares by surname first, then forename.
        var surnameComparison = string.Compare(x.Surname, y.Surname, StringComparison.Ordinal);
        if (surnameComparison != 0) 
            return surnameComparison;
        
        return string.Compare(x.Forename, y.Forename, StringComparison.Ordinal);
    }
}

public class StudentAgeComparer : IComparer<Student>
{
    public int Compare(Student? x, Student? y)
    {
        if (ReferenceEquals(x, y)) 
            return 0;
        if (ReferenceEquals(null, y)) 
            return 1;
        if (ReferenceEquals(null, x)) 
            return -1;
        
        return Nullable.Compare(x.Age, y.Age);
    }
}