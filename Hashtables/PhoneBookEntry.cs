using System.ComponentModel.DataAnnotations;

namespace Hashtables;

public class PhoneBookEntry
{
    public string Surname { get; }
    public string Forename { get; }
    public string FullName => $"{Surname} {Forename}";

    private string? _phoneNumber;
    public string? PhoneNumber
    {
        get => _phoneNumber;
        set
        {
            // Ensure it is a well-formatted phone number before setting.
            if (new PhoneAttribute().IsValid(value))
                _phoneNumber = value;
        }
    }
    
    public string? EmailAddress { get; set; }
    
    public string? Address { get; set; }

    public PhoneBookEntry(string surname, string forename, string phoneNumber)
    {
        Surname = surname;
        Forename = forename;
        PhoneNumber = phoneNumber;
    }

    public override string ToString()
    {
        return $"{FullName} - {PhoneNumber}";
    }
}