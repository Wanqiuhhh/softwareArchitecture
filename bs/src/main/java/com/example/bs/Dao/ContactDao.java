package com.example.bs.Dao;

import com.example.bs.entity.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface ContactDao {
    List<Contact> selectAll();

    int updateByName(Contact contact);

    Contact selectByName(String contactName);

    int deleteByName(String contactName);

    int addContact(Contact contact);
}
