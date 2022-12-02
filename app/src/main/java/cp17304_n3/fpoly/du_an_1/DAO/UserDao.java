package cp17304_n3.fpoly.du_an_1.DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;
import cp17304_n3.fpoly.du_an_1.DTO.User;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;

public class UserDao {
    Connection objConn;
    public UserDao(){
        // hàm khởi tạo để mở kết nối
        DbSqlServer db = new DbSqlServer();
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }
    public List<User> getAll(){
        List<User> listCat = new ArrayList<User>();

        try {
            if (this.objConn != null) {

                String sqlQuery = "SELECT * FROM UserName ";

                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list

                    User objCat = new User();
                    objCat.setIdUser(resultSet.getInt("idUser")); // truyền tên cột dữ liệu
                    objCat.setHoTen(resultSet.getString("Hoten"));
                    objCat.setDiaChi(resultSet.getString("DiaChi"));
                    objCat.setSdt(resultSet.getString("sdt"));
                    objCat.setTenDangNhap(resultSet.getString("TenDangNhap"));
                    objCat.setPass(resultSet.getString("pass"));

                    listCat.add(objCat);
                    Log.e("aaa","ok");
                }
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng



        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu " );
            e.printStackTrace();
        }

        return  listCat;
    }
}
