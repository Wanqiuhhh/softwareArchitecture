package secondCSStructure;

import org.junit.Test;

import java.sql.*;

public class Server {
    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String userName = "root";
    private String password = "abc123";
    private String url = "jdbc:mysql://localhost:3306/personaladdressbook";

    public Server() {

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
            e.printStackTrace();
        }
    }

    // 查询根据名字
    public ResultSet select_name(String name) throws SQLException {
        String sql = "select * from personinformation where name = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();

        return rs;
    }

    // 查询根据电话号码
    public ResultSet select_phone(String phone) throws SQLException {
        String sql = "select * from personinformation where phoneNumber = ?";

        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, phone);

        ResultSet rs = pstmt.executeQuery();

        return rs;
    }

    // 新增
    public Boolean insert(String name, String address,String phone) {
        String sql = "insert into personinformation (name, address, phoneNumber) VALUES (?, ?, ?)";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, phone);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    // 修改联系人姓名
    public void update_name(String oldName, String newName) {
        String sql = "update personinformation set name = ? where name= ? ";// 生成一条mysql语句

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setString(2, oldName);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 修改联系人电话
    public void update_phone(String name, String phone) {
        String sql = "update personinformation set phoneNumber = ? where name= ? ";// 生成一条mysql语句

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phone);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 修改联系人地址
    public void update_address(String name, String address) {
        String sql = "update personinformation set address = ? where name= ? ";// 生成一条mysql语句

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, address);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 删除
    public Boolean delete(int id) {
        String sql = "delete from personinformation where id=?";

        PreparedStatement pstmt;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    @Test
    public void test1() throws Exception { // 下面方法有不同的异常，我直接抛出一个大的异常
        Server j = new Server();

        j.delete(3);

    }
}
