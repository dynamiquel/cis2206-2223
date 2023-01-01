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
        // First regex allows international numbers (without spaces) i.e. +44 7862485769 or +447862485769.
        // Second regex allows UK numbers starting with 0 (without spaces) i.e. 07538332719.
        return phoneNumber.matches("^(\\+\\d{1,3}( )?)?(\\d{10})$") ||
                phoneNumber.matches("^([0]\\d{10})$");
    }

    public boolean isValid() {
        // Phone number will not be empty if this is a valid entry.
        return phoneNumber != null && !phoneNumber.isEmpty();
    }

    @Override
    public String toString() {
        return getFullName() + ": " +
                getPhoneNumber() + " - " +
                getEmailAddress() + " - " +
                getHomeAddress();
    }
}
