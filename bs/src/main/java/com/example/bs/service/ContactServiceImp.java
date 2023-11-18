package com.example.bs.service;

import com.example.bs.Dao.ContactDao;
import com.example.bs.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContactServiceImp implements ContactService{
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> selectAll(){
        return contactDao.selectAll();
    }

    @Override
    public void update(Contact contact){
        contactDao.updateByName(contact);
    }

    @Override
    public Contact selectByContactName(String contactName) {
        Contact contact = contactDao.selectByName(contactName);
        return contact;
    }

    @Override
    public void deleteContactByName(String contactName) {
        contactDao.deleteByName(contactName);
    }

    @Override
    public void add(Contact contact){
        contactDao.addContact(contact);
    }
}
