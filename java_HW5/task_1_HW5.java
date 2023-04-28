package java_HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class task_1_HW5 {
    private final Map<String, List<String>> contacts;

    public task_1_HW5() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            contacts.put(name, phones);
        }
    }

    public List<String> getPhonesByName(String name) {
        return contacts.get(name);
    }

    public Map<String, List<String>> getContacts() {
        return contacts;
    }
}
