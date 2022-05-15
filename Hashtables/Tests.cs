using System.ComponentModel.DataAnnotations;

namespace Hashtables;

public class Tests
{
    [Xunit.Theory]
    [Xunit.InlineData("Hall", "Liam", "lol")]
    [Xunit.InlineData("Sinla", "Nari", "+447862485764")]
    [Xunit.InlineData("Conhee", "Drea", "07538332719")]
    public void VerifyValidInsertion(string surname, string forename, string phoneNumber)
    {
        var user = new User();
        bool valid = user.PhoneBook.Insert(new PhoneBookEntry(surname, forename, phoneNumber));

        var fullname = $"{surname} {forename}";
        var phoneNumberVerifier = new PhoneAttribute();
        
        // If the number is valid and unique, then it should have been added to the phonebook.
        Xunit.Assert.Equal(phoneNumberVerifier.IsValid(phoneNumber), valid);
        Xunit.Assert.Equal(phoneNumberVerifier.IsValid(phoneNumber), user.PhoneBook.ContainsByName(fullname));

        if (valid)
        {
            Xunit.Assert.Equal(phoneNumber, user.PhoneBook.GetByName(fullname)!.PhoneNumber);
            Xunit.Assert.Equal(fullname, user.PhoneBook.GetByPhoneNumber(phoneNumber)!.FullName);
            
            // Verifies that the automatic Get method works correctly.
            Xunit.Assert.Equal(phoneNumber, user.PhoneBook.Get(fullname)!.PhoneNumber);
            Xunit.Assert.Equal(fullname, user.PhoneBook.Get(phoneNumber)!.FullName);
        }
    }

    [Xunit.Theory]
    [Xunit.InlineData("Hall", "Liam", "lol", "+44 7462 457563")]
    [Xunit.InlineData("Sinla", "Nari", "+447862485764", "+447862485764")]
    [Xunit.InlineData("Conhee", "Drea", "07538332719", "07575865429")]
    [Xunit.InlineData("Sohal", "Sav", "+447898785123", "xd")]
    [Xunit.InlineData("Null", "Null", "invalid", "number")]
    public void VerifyNumberModification(string surname, string forename, string phoneNumber, string newPhoneNumber)
    {
        var user = new User();
        bool valid = user.PhoneBook.Insert(new PhoneBookEntry(surname, forename, phoneNumber));

        var fullname = $"{surname} {forename}";
        var phoneNumberVerifier = new PhoneAttribute();

        if (valid)
        {
            user.PhoneBook.GetByName(fullname)!.PhoneNumber = newPhoneNumber;

            if (!phoneNumberVerifier.IsValid(newPhoneNumber))
            {
                // If both numbers were invalid, we expect a null phone number.
                if (!phoneNumberVerifier.IsValid(phoneNumber))
                    Xunit.Assert.Null(user.PhoneBook.GetByName(fullname));
                // If only the new number is invalid, we expect the previously valid phone number.
                else
                    Xunit.Assert.Equal(phoneNumber, user.PhoneBook.GetByName(fullname)!.PhoneNumber);
            }
            // If new number is valid, we expect the new number.
            else
                Xunit.Assert.Equal(newPhoneNumber, user.PhoneBook.GetByName(fullname)!.PhoneNumber);
        }
    }

    [Xunit.Theory]
    [Xunit.InlineData("Hall", "Liam", "lol", "+44 7462 457563")]
    [Xunit.InlineData("Sinla", "Nari", "+447862485764", "+447862485764")]
    [Xunit.InlineData("Conhee", "Drea", "07538332719", "07575865429")]
    [Xunit.InlineData("Sohal", "Sav", "+447898785123", "xd")]
    [Xunit.InlineData("Null", "Null", "invalid", "number")]
    public void VerifyReplacement(string surname, string forename, string phoneNumber, string newPhoneNumber)
    {
        var user = new User();
        user.PhoneBook.Insert(new PhoneBookEntry(surname, forename, phoneNumber));

        var fullname = $"{surname} {forename}";
        user.PhoneBook.Insert(new PhoneBookEntry(surname, forename, newPhoneNumber));
        
        var phoneNumberVerifier = new PhoneAttribute();

        if (!phoneNumberVerifier.IsValid(newPhoneNumber))
        {
            // If both numbers were invalid, we expect a null phone number.
            if (!phoneNumberVerifier.IsValid(phoneNumber))
                Xunit.Assert.Null(user.PhoneBook.GetByName(fullname));
            // If only the new number is invalid, we expect the previously valid phone number.
            else
                Xunit.Assert.Equal(phoneNumber, user.PhoneBook.GetByName(fullname)!.PhoneNumber);
        }
    }
}