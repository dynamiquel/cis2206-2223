using System.ComponentModel.DataAnnotations;
using System.Text;

namespace Hashtables;

public class PhoneBook
{
    private readonly IDictionary<string, PhoneBookEntry> byNameMap;
    private readonly IDictionary<string, PhoneBookEntry> byPhoneNumberMap;

    private readonly PhoneAttribute phoneVerifier;

    public PhoneBook()
    {
        byNameMap = new Dictionary<string, PhoneBookEntry>(10);
        byPhoneNumberMap = new Dictionary<string, PhoneBookEntry>(10);
        phoneVerifier = new PhoneAttribute();
    }

    public bool Insert(PhoneBookEntry entry)
    {
        // Do not allow entries without a valid phone number to be added.
        if (entry.PhoneNumber == null)
            return false;
        
        // Someone with a different name already has this phone number; ignore this insertion.
        if (!byNameMap.ContainsKey(entry.FullName) && byPhoneNumberMap.ContainsKey(entry.PhoneNumber))
            return false;
        
        byNameMap[entry.FullName] = entry;
        byPhoneNumberMap[entry.PhoneNumber] = entry;
        return true;
    }

    public bool Delete(string nameOrPhoneNumber)
    {
        return phoneVerifier.IsValid(nameOrPhoneNumber) 
            ? DeleteByPhoneNumber(nameOrPhoneNumber) 
            : DeleteByName(nameOrPhoneNumber);
    }

    public bool DeleteByName(string name)
    {
        PhoneBookEntry? entry = Get(name);
        if (entry == null) 
            return false;
        
        byNameMap.Remove(name);
            
        if (entry.PhoneNumber != null)
            byPhoneNumberMap.Remove(entry.PhoneNumber);

        return true;
    }
    
    public bool DeleteByPhoneNumber(string phoneNumber)
    {
        PhoneBookEntry? entry = GetByPhoneNumber(phoneNumber);
        if (entry == null) 
            return false;
        
        byNameMap.Remove(entry.FullName);
        byPhoneNumberMap.Remove(phoneNumber);
        
        return true;
    }

    public PhoneBookEntry? Get(string nameOrPhoneNumber)
    {
        return phoneVerifier.IsValid(nameOrPhoneNumber) 
            ? GetByPhoneNumber(nameOrPhoneNumber) 
            : GetByName(nameOrPhoneNumber);
    }
    
    public PhoneBookEntry? GetByName(string name) => ContainsByName(name) ? byNameMap[name] : null;
    
    public PhoneBookEntry? GetByPhoneNumber(string phoneNumber) => ContainsByPhoneNumber(phoneNumber) ? byPhoneNumberMap[phoneNumber] : null;

    public bool Contains(string nameOrPhoneNumber)
    {
        return phoneVerifier.IsValid(nameOrPhoneNumber) 
            ? ContainsByName(nameOrPhoneNumber) 
            : ContainsByPhoneNumber(nameOrPhoneNumber);
    }
    
    public bool ContainsByName(string name) => byNameMap.ContainsKey(name);
    
    public bool ContainsByPhoneNumber(string phoneNumber) => byPhoneNumberMap.ContainsKey(phoneNumber);

    public void PrintEntry(string name)
    {
        if (byNameMap.ContainsKey(name))
            Console.WriteLine(byNameMap[name].ToString());
    }

    public void Print() => Console.WriteLine(ToString());

    public override string ToString()
    {
        var sb = new StringBuilder(100 * byNameMap.Count);
        
        foreach (var entry in byNameMap)
            sb.AppendLine(entry.Value.ToString());

        return sb.ToString();
    }
}