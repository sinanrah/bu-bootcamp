import java.util.*;

public class ContactManager {
    
    public static void main(String[] args) {
        
        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("Sinan Rahman", new Contact("Sinan Rahman", "+1 516 304 4111"));
        contacts.put("LeBron James", new Contact("LeBron James", "+1 623 623 2306"));
        contacts.put("Jalen Brunson", new Contact("Jalen Brunson", "+1 212 718 9170"));
        contacts.put("Rinan Sahman", new Contact("Rinan Sahman", "+1 411 130 4516"));
        contacts.put("Betty White", new Contact("Betty White", "+1 999 999 9999"));

        Contact toLookUp = contacts.get("Sinan Rahman");
        if (toLookUp == null) System.out.println("Contact not found\n");
        else System.out.println(toLookUp + "\n");
        
        toLookUp = contacts.get("Nanis Namhar");
        if (toLookUp == null) System.out.println("Contact not found\n");
        else System.out.println(toLookUp);
        
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort( (a, b) -> a.getName().compareTo(b.getName())); 
        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
    
}
