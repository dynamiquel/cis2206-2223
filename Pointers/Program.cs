// See https://aka.ms/new-console-template for more information

using Pointers;

var office = new StudentSupportOffice();
IReadOnlyDictionary<string, Module> modules = office.CreateDefaultModules();
IReadOnlyDictionary<string, Student> students = office.CreateDefaultStudents();

office.DefaultEnrollment(modules, students);
foreach (var module in modules)
    Console.WriteLine(module.Value.ToString());
    
office.EnrollmentChanges(modules, students);
foreach (var module in modules)
    Console.WriteLine(module.Value.ToString());