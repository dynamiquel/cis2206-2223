using System.Text;

namespace Lists;

/// <summary>
/// A class representing a uniquely identifiable Student.
/// </summary>
public class Student : IComparable<Student>
{
    public string StudentId { get; }
    public IList<Grade> Grades { get; }

    public double? AverageScore
    {
        get
        {
            if (Grades.Count == 0)
                return null;
            
            double avg = Grades.Average(grade => grade.Score);
            return avg;
        }
    }
    
    public Student(string studentId)
    {
        StudentId = studentId;
        Grades = new List<Grade>();
    }

    public Grade? GetGradeForModule(Module module)
    {
        foreach (var grade in Grades)
            if (grade.Module == module) 
                return grade;

        return null;
    }

    public Grade? AddNewGrade(Grade grade)
    {
        // Checks if the Student already has a Grade for this Module.
        // If so, update the already existing Grade instead.
        var previousGrade = GetGradeForModule(grade.Module);
        if (previousGrade != null)
        {
            previousGrade.Score = grade.Score;
            return previousGrade;
        }
        
        // Only allow the Grade to be added if this Student is enrolled in this Module.
        if (grade.Module.Students.Contains(this))
        {
            Grades.Add(grade);
            grade.Module.Grades.Add(grade);

            return grade;
        }

        return null;
    }

    public int CompareTo(Student? other)
    {
        // Using StudentId as the default compare implementation.
        if (ReferenceEquals(this, other)) return 0;
        if (ReferenceEquals(null, other)) return 1;
        return string.Compare(StudentId, other.StudentId, StringComparison.Ordinal);
    }

    public override string ToString()
    {
        var sb = new StringBuilder(20);
        sb.Append(StudentId);
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