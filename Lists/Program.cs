// See https://aka.ms/new-console-template for more information

using System.Text;
using Lists;

var office = new StudentSupportOffice();
IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

office.DefaultEnrollment(modules, students);
foreach (var module in modules)
    Console.WriteLine(module.Value.ToString());

IReadOnlyList<Grade> grades = office.CreateDefaultGrades(modules, students);

office.RegisterGrades(grades);

var sb = new StringBuilder(200);
foreach (var module in modules)
{
    sb.AppendLine($"Grade Summary for Module {module.Key}");
    sb.AppendLine($"Average Score: {module.Value.AverageScore:N}");
    
    foreach (var grade in module.Value.Grades)
        sb.AppendLine($"Student '{grade.Student.ToString()}': {grade.Score}");
    
    sb.AppendLine();
}

Console.WriteLine(sb.ToString());

office.UpdateGradeScore(grades);

sb = new StringBuilder(200);
foreach (var module in modules)
{
    sb.AppendLine($"Grade Summary for Module {module.Key}");
    sb.AppendLine($"Average Score: {module.Value.AverageScore:N}");
    
    foreach (var grade in module.Value.Grades)
        sb.AppendLine($"Student '{grade.Student.ToString()}': {grade.Score}");
    
    sb.AppendLine();
}

Console.WriteLine(sb.ToString());

office.AmendGradeViaAddGrade(grades);

sb = new StringBuilder(200);
foreach (var module in modules)
{
    sb.AppendLine($"Grade Summary for Module {module.Key}");
    sb.AppendLine($"Average Score: {module.Value.AverageScore:N}");
    
    foreach (var grade in module.Value.Grades)
        sb.AppendLine($"Student '{grade.Student.ToString()}': {grade.Score}");
    
    sb.AppendLine();
}

Console.WriteLine(sb.ToString());

office.RemoveGrades(grades);

sb = new StringBuilder(200);
foreach (var module in modules)
{
    sb.AppendLine($"Grade Summary for Module {module.Key}");
    sb.AppendLine($"Average Score: {module.Value.AverageScore:N}");
    
    foreach (var grade in module.Value.Grades)
        sb.AppendLine($"Student '{grade.Student.ToString()}': {grade.Score}");

    sb.AppendLine();
}

Console.WriteLine(sb.ToString());