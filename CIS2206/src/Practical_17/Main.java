package Practical_17;

public class Main {
    public static void main(String[] args) {
        var user = new User();

        user.defaultInsertions();
        System.out.println("After Default Insertions:");
        user.printPhonebook();

        user.defaultModifications();
        System.out.println("After Default Modifications:");
        user.printPhonebook();

        user.defaultDeletions();
        System.out.println("After Default Deletions:");
        user.printPhonebook();
    }
}
