package Practical_17;

public class User {
    private PhoneBook phoneBook;

    public User() {
        phoneBook = new PhoneBook();
    }

    public void defaultInsertions() {
        phoneBook.insertOrUpdate(new PhoneBookEntry(
                "Hall",
                "Liam",
                "lol"));

        phoneBook.insertOrUpdate(new PhoneBookEntry(
                "Sinla",
                "Nari",
                "+44 7862485769",
                "narisinla@gmail.com",
                "87, LS3 1FC"));

        phoneBook.insertOrUpdate(new PhoneBookEntry(
                "Conhee",
                "Drea",
                "07538332719",
                "andreaconhee@hotmail.co.uk",
                "41a, HD3 2EU"));
    }

    public void defaultModifications() {
        phoneBook.insertOrUpdate(new PhoneBookEntry(
                "Hall",
                "Liam",
                "+447462457563",
                "liamhall@outlook.com",
                "55, HD5 6PL"));

        phoneBook.insertOrUpdate(new PhoneBookEntry(
                "Sinla",
                "Nari",
                "+447862485769",
                "narisinla@gmail.com",
                "32, LS5 4NF"));

        phoneBook.insertOrUpdate(new PhoneBookEntry(
                "Conhee",
                "Drea",
                "07575865429",
                "andreaconhee@hotmail.co.uk",
                "41a, HD3 2EU"));
    }

    public void defaultDeletions() {
        phoneBook.delete("Liam Hall");
        phoneBook.delete("Drea Conhee");
    }

    public void printPhonebook() {
        phoneBook.print();
    }
}
