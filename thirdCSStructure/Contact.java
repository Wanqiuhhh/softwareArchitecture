package thirdCSStructure;

public class Contact {
    private String contactName;
    private String address;
    private String phoneNumber;

    public Contact(String contactName,String address, String phoneNumber) {
        this.contactName = contactName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
