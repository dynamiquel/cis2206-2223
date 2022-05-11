using System.Text;

namespace Pointers;

/// <summary>
/// A class representing a Module, containing a sorted list of Students.
/// </summary>
public class Module
{
    public string ModuleId { get; set; }
    public readonly List<Student> _students = new(5);
    public IComparer<Student> StudentsComparer { get; }

    public Module(string moduleId, IComparer<Student>? studentsComparer = null)
    {
        ModuleId = moduleId;
        
        // If no Student Comparer is selected, use the default comparer (by StudentId).
        studentsComparer ??= new StudentIdComparer();
        StudentsComparer = studentsComparer;
    }

    public IReadOnlyList<Student> Students => _students;
    public int ClassCount => _students.Count;

    /// <summary>
    /// Adds a new specified Student to the Module.
    /// </summary>
    /// <param name="newStudent"></param>
    /// <returns>True, if enrolled.</returns>
    public bool Enroll(Student newStudent)
    {
        if (_students.Contains(newStudent))
            return false;
        
        _students.Add(newStudent);
        _students.Sort(StudentsComparer);
        return true;
    }

    /// <summary>
    /// Removes a specified Student from the Module.
    /// </summary>
    /// <param name="student"></param>
    /// <returns>True, if disenrolled.</returns>
    public bool Disenroll(Student student)
    {
        return _students.Remove(student);
    }

    public override string ToString()
    {
        var sb = new StringBuilder(15 * ClassCount);

        sb.AppendLine($"Class: {ModuleId}");
        
        for (var i = 0; i < _students.Count; i++)
            sb.AppendLine($"Student {i}: {_students[i].ToString()}");

        return sb.ToString();
    }
}