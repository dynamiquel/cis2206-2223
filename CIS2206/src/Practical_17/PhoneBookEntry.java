package Practical_17;

public class PhoneBookEntry {
    private String surname;
    private String forename;
    private String phoneNumber;
    private String emailAddress;
    private String homeAddress;

    public PhoneBookEntry(String surname, String forename, String phoneNumber, String emailAddress, String homeAddress) {
        this.surname = surname;
        this.forename = forename;
        if (isValidPhoneNumber(phoneNumber))
            this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
    }

    public PhoneBookEntry(String surname, String forename, String phoneNumber) {
        this.surname = surname;
        this.forename = forename;
        if (isValidPhoneNumber(phoneNumber))
            this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }

    public String getFullName() {
        return forename + " " + surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Regex allows international numbers (without spaces) i.e. +44 7862485769 or +447862485769.
        // As well as UK numbers starting with 0 and have a total of 11 characters. i.e. 07538332719.
        return phoneNumber.matches("^(\\+\\d{1,3}( )?|[0])(\\d{10})$") ;
    }

    public boolean isValid() {
        // Phone number will not be empty if this is a valid entry.
        return phoneNumber != null && !phoneNumber.isEmpty();
    }

    /**
     * Easy way to clone this object while providing a new Phone Number.
     */
    public PhoneBookEntry clone(String newPhoneNumber) {
        return clone(newPhoneNumber, null, null);
    }

    /**
     * Easy way to clone this object while providing a new Phone Number, Email Address and Home Address.
     * Use null string or an empty string for parameters you do not wish to override.
     */
    public PhoneBookEntry clone(String newPhoneNumber, String newEmailAddress, String newHomeAddress) {
        // If a given parameter is a not empty string, use that as the new attribute.
        // Else, use the original value.
        return new PhoneBookEntry(
                getSurname(),
                getForename(),
                newPhoneNumber == null || newPhoneNumber.isEmpty() ? getPhoneNumber() : newPhoneNumber,
                newEmailAddress == null || newEmailAddress.isEmpty() ? getEmailAddress() : newEmailAddress,
                newHomeAddress == null || newHomeAddress.isEmpty() ? getHomeAddress() : newHomeAddress);
    }

    @Override
    public String toString() {
        return getFullName() + ": " +
                getPhoneNumber() + " - " +
                getEmailAddress() + " - " +
                getHomeAddress();
    }
}
