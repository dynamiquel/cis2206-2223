namespace Lists;

public class Grade
{
    public Module Module { get; }
    public Student Student { get; }
    public int Score { get; set; }

    public Grade(Module module, Student student, int score)
    {
        Module = module;
        Student = student;
        Score = score;
    }

    public void Destroy()
    {
        // Removes the main stored references for this object.
        Student.Grades.Remove(this);
        Module.Grades.Remove(this);
    }
}