package lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class PhoneList {
    private Map<String, String> phonebook;

    public PhoneList() {
        phonebook = new HashMap<>();
    }

    public void add(String name, String phone) {
        phonebook.put(phone, name);
    }

    public Set<String> getPhone(String name) {
        Set<String> phones = new HashSet<>();
        phonebook.forEach((k, v) -> {
            if (v.equals(name)) {
                phones.add(k);
            }
        });
        return phones;
    }
}
