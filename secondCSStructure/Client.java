package secondCSStructure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws SQLException {

        System.out.println("个人通讯录");

        while (true) {
            System.out.println("1、查看联系人信息    2、添加新的联系人    3、修改联系人信息    4、删除联系人     5、退出");

            @SuppressWarnings("resource")
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt();

            if (choose == 5){
                System.out.println("退出通讯录");
                break;
            }
            else if (choose < 5) {
                if (choose == 1) {
                    System.out.println("输入联系人姓名");
                    String inputData = input.next();
                    Server server = new Server();
                    ResultSet rs = server.select_name(inputData);
                    if (rs.next()) {
                        System.out.println("id	  姓名	  地址    电话");
                        do {
                            System.out.println(rs.getInt(1) + "    " + rs.getString(2) + "    " + rs.getString(3)+"    "+rs.getString(4));
                        }while (rs.next());
                    }else {
                        System.out.println("查不到此人");
                    }
                }
                if (choose == 2) {
                    System.out.println("输入联系人姓名、地址和电话");

                    String name, address,phone;
                    name = input.next();
                    address = input.next();
                    phone = input.next();

                    Server server = new Server();

                    if (server.insert(name, address,phone)) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                }
                if (choose == 3) {
                    System.out.println("输入要修改联系人姓名：");
                    String inputData = input.next();

                    System.out.println("输入要修改的内容(1、name, 2、phone，3、address):");
                    int number = input.nextInt();

                    System.out.println("输入修改后的值");
                    String modifyData = input.next();

                    Server server = new Server();
                    if (number == 1)
                        server.update_name(inputData, modifyData);
                    if (number == 2)
                        server.update_phone(inputData, modifyData);
                    if(number == 3){
                        server.update_address(inputData,modifyData);
                    }
                }
                if (choose == 4) {
                    System.out.println("输入要删除的联系人姓名：");
                    String inputNumber = input.next();

                    Server server = new Server();

                    if (server.delete(inputNumber)) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }

                }
            } else
                continue;
        }
    }
}
