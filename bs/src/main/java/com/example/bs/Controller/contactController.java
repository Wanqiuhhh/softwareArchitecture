package com.example.bs.Controller;

import com.example.bs.Common.Result;
import com.example.bs.Common.StatusCode;
import com.example.bs.Dao.ContactDao;
import com.example.bs.entity.Contact;
import com.example.bs.service.ContactService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class contactController {
    @Autowired
    private ContactDao contactDao;
    @Autowired
    private ContactService contactService;

    /*@GetMapping("/index")
    public String home() {
        return "index";
    }*/

    @ApiOperation(value="查询所有联系人")
    @GetMapping("/selectAll")
    public Result<List<Contact>> selectAll(){
        List<Contact> contacts = contactService.selectAll();
        return new Result<List<Contact>>(true, StatusCode.OK, "查询成功", contacts);
    }

    //修改联系人信息
    @ApiOperation(value = "根据姓名修改联系人信息")
    @PutMapping(value = "/updateContactByName/{contactName}")
    public Result<String> update(@Validated @RequestBody Contact contact, BindingResult bindingResult, @PathVariable("contactName") String contactName) {
        contact.setContactName(contactName);
        contactService.update(contact);
        return new Result<String>(true, StatusCode.OK, "信息修改成功", "修改成功");
    }

    //根据姓名查询联系人
    @ApiOperation(value = "根据姓名查询联系人")
    @GetMapping("/selectContactByName/{contactName}")
    public Result selectByUserName(@PathVariable("contactName") String contactName) {
        Contact contact = contactService.selectByContactName(contactName);
        return new Result(true, StatusCode.OK, "查询成功", contact);
    }

    //删除联系人
    @ApiOperation(value = "根据姓名删除联系人")
    @DeleteMapping("/deleteContactByName/{contactName}")
    public Result<String> deletes(@PathVariable("contactName") String contactName) {
        contactService.deleteContactByName(contactName);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //增加联系人
    @ApiOperation(value = "增加联系人")
    @PostMapping("/addContact")
    public Result<String> add(@RequestBody Contact contact) {
        contactService.add(contact);
        return new Result(true, StatusCode.OK, "新增成功");
    }
}
