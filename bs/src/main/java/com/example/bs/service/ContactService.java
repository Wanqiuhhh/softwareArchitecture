package com.example.bs.service;

import com.example.bs.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> selectAll();

    void update(Contact contact);

    Contact selectByContactName(String contactName);

    void deleteContactByName(String contactName);

    void add(Contact contact);
}
