package thirdCSStructure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Contact> contacts = new ArrayList<Contact>();
    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String userName = "root";
    private String password = "abc123";
    private String url = "jdbc:mysql://localhost:3306/personaladdressbook";

    public Data() {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void finalize() {
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 查询根据名字
    public ResultSet select_name(String name) {
        String sql = "select * from personinformation where contactName = ?";

        PreparedStatement pstmt;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 新增
    public Boolean insert(String name, String address,String phone) {
        String sql = "insert into personinformation (contactName, address, phoneNumber) VALUES (?, ?, ?)";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, phone);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 修改联系人姓名
    public void update_name(String oldName, String newName) {
        String sql = "update personinformation set contactName = ? where contactName= ? ";// 生成一条mysql语句

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setString(2, oldName);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 修改联系人电话
    public void update_phone(String name, String phone) {
        String sql = "update personinformation set phoneNumber = ? where contactName= ? ";// 生成一条mysql语句

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phone);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 修改联系人地址
    public void update_address(String name, String address) {
        String sql = "update personinformation set address = ? where contactName= ? ";// 生成一条mysql语句

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, address);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除联系人
    public Boolean delete(String name) {
        String sql = "delete from personinformation where contactName=?";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
