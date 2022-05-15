using System.ComponentModel.DataAnnotations;

namespace Hashtables;

public class User
{
    public PhoneBook PhoneBook { get; }

    public User()
    {
        PhoneBook = new PhoneBook();
    }

    public void DefaultInsertions()
    {
        PhoneBook.Insert(new PhoneBookEntry("Hall", "Liam", "lol")
        {
            EmailAddress = "liamhall@outlook.com",
            Address = "55, HD5 6PL"
        });
        
        PhoneBook.Insert(new PhoneBookEntry("Sinla", "Nari", "+447862485764")
        {
            EmailAddress = "narsinla@gmail.com",
            Address = "87, LS3 1FF"
        });
        
        PhoneBook.Insert(new PhoneBookEntry("Conhee", "Drea", "07538332719")
        {
            EmailAddress = "andreaconhee@hotmail.co.uk",
            Address = "41a, HD3 2EU"
        });
    }
    
    public void DefaultModifications()
    {
        PhoneBook.Insert(new PhoneBookEntry("Hall", "Liam", "+44 7462 457563")
        {
            EmailAddress = "liamhall@outlook.com",
            Address = "55, HD5 6PL"
        });
        
        PhoneBook.Insert(new PhoneBookEntry("Sinla", "Nari", "+447862485764")
        {
            EmailAddress = "narsinla@gmail.com",
            Address = "32, LS5 4NF"
        });

        PhoneBook.Get("Conhee Drea")!.PhoneNumber = "07575865429";
    }
    
    public void DefaultDeletions()
    {
        PhoneBook.Delete("Hall Liam");

        PhoneBook.Delete("Conhee Drea");
    }
}