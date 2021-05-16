import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args){
        printActions();
        boolean quit = false;
        while(!quit){
            System.out.println("Choose your action: ");
            int action = input.nextInt();
            switch (action){
                case 0:
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printTheContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    public static void addNewContact(){
        System.out.println("Enter the name of the contact you want to add: ");
        String newName = input.next();
        System.out.println("Enter the new contact number: ");
        String newNumber = input.next();
        Contact newContact = Contact.createContact(newName,newNumber);
        mobilePhone.addNewContact(newContact);
    }

    public static void updateContact(){
        System.out.println("Enter an existing contact name: ");
        String name = input.next();
        System.out.println("Enter the new name of the contact: ");
        String newName = input.next();
        System.out.println("Enter the new contact number: ");
        String newNumber = input.next();
        Contact newContact = Contact.createContact(newName, newNumber);
        mobilePhone.updateContact(name, newContact);
    }

    public static void removeContact(){
        System.out.println("Enter an existing contact name to remove: ");
        String name = input.next();
        mobilePhone.removeContact(name);
    }

    public static void queryContact(){
        System.out.println("Enter an existing contact name for the query: ");
        String name = input.next();
        System.out.println(mobilePhone.queryContact(name).getName()
                + " is registered with " + mobilePhone.queryContact(name).getNumber() + ".");
    }

    public static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
    }

}





