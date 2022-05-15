using Hashtables;

User user = new User();

user.DefaultInsertions();
Console.WriteLine("After Default Insertions:");
user.PhoneBook.Print();

user.DefaultModifications();
Console.WriteLine("After Default Modifications:");
user.PhoneBook.Print();

user.DefaultDeletions();
Console.WriteLine("After Default Deletions:");
user.PhoneBook.Print();