package thirdCSStructure;

import java.sql.ResultSet;
import java.util.List;

public class Business {
    private Data data;

    public Business() {
        data = new Data();
    }

    public ResultSet viewContactByName(String name) {
        return data.select_name(name);
    }

    public boolean addContact(String name, String address, String phone) {
        return data.insert(name, address, phone);
    }

    public void updateContactName(String oldName, String newName) {
        data.update_name(oldName, newName);
    }

    public void updateContactPhone(String name, String phone) {
        data.update_phone(name, phone);
    }

    public void updateContactAddress(String name, String address) {
        data.update_address(name, address);
    }

    public boolean deleteContact(String name) {
        return data.delete(name);
    }
}
