import java.util.ArrayList;

public class MobilePhone {
    private  ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<Contact>();
    }


    public void printTheContacts() {
        if (myContacts.size() > 0) {
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println((i+1) + ". Name: " + myContacts.get(i).getName() +
                        " -> Number: " + myContacts.get(i).getNumber());
            }
        }else {
            System.out.println("There is no contact!");
        }
    }

    public boolean addNewContact(Contact newContact){
//        Contact newContact = createContact(newName,newNumber);
        if(findContact(newContact.getName())>=0){
            System.out.println("Contact already exists!");
            return false;
        }else {
            myContacts.add(newContact);
            return true;
        }
    }

    public boolean updateContact(String name, Contact newContact){

        if(findContact(name)>=0){
//            Contact newContact = contact.createContact(newName,newNumber);
            if(findContact(newContact.getName())>=0){
                System.out.println("Contact already exist!");
                return false;
            }else {
                System.out.println("Contact updated!");
                myContacts.set(findContact(name), newContact);
                return true;
            }
            }else {
                System.out.println("Contact does not exist!");
                return false;
            }


    }

    public boolean removeContact(String name){
        if(findContact(name)>=0){
            myContacts.remove(findContact(name));
            System.out.println("Contact removed!");
            return true;
        }
        System.out.println("Contact does not exist!");
        return false;
    }

    public Contact queryContact(String name){
        if(findContact(name)>=0){
            return myContacts.get(findContact(name));
        }
        System.out.println("Contact does not exist!");
        return null;
    }

    public int findContact(String name){
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public int findContact(Contact contact){
        for(int i = 0; i < myContacts.size(); i++){
            if(myContacts.get(i) == contact){
                return i;
            }
        }
        return -1;
    }



}
