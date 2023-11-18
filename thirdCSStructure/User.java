package thirdCSStructure;

import secondCSStructure.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    public static void main(String args[]) throws SQLException {
        System.out.println("欢迎使用个人通讯录系统！");
        Business business = new Business();

        while (true) {
            System.out.println("1、查看联系人信息    2、添加新的联系人    3、修改联系人信息    4、删除联系人     0、退出");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("感谢使用个人通讯录系统！");
                    System.exit(0);
                case 1:
                    System.out.println("输入联系人姓名");
                    String inputData1 = input.next();
                    //Server server1 = new Server();
                    ResultSet rs = business.viewContactByName(inputData1);
                    if (rs.next()) {
                        System.out.println("姓名	  地址    电话");
                        do {
                            System.out.println(rs.getString(1) + "    " + rs.getString(2)+"    "+rs.getString(3));
                        }while (rs.next());
                    }else {
                        System.out.println("查无此人");
                    }
                    break;
                case 2:
                    System.out.println("输入联系人姓名、地址和电话");

                    String name, address,phone;
                    name = input.next();
                    address = input.next();
                    phone = input.next();

                    //Server server2 = new Server();

                    if (business.addContact(name, address,phone)) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                    break;
                case 3:
                    System.out.println("输入要修改联系人姓名：");
                    String inputData3 = input.next();

                    System.out.println("输入要修改的内容(1、name, 2、phone，3、address):");
                    int number = input.nextInt();

                    System.out.println("输入修改后的值");
                    String modifyData = input.next();

                    //Server server3 = new Server();
                    if (number == 1)
                        business.updateContactName(inputData3, modifyData);
                    if (number == 2)
                        business.updateContactPhone(inputData3, modifyData);
                    if(number == 3){
                        business.updateContactAddress(inputData3,modifyData);
                    }
                    break;
                case 4:
                    System.out.println("输入要删除的联系人姓名：");
                    String inputNumber = input.next();

                    //Server server4 = new Server();

                    if (business.deleteContact(inputNumber)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }
}
