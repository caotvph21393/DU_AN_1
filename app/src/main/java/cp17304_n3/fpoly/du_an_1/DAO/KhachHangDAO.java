package cp17304_n3.fpoly.du_an_1.DAO;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.DTO.User;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;

public class KhachHangDAO {
    SharedPreferences sharedPreferences;
    Connection objConn;

    public KhachHangDAO(Context context){
        // hàm khởi tạo để mở kết nối
        DbSqlServer db = new DbSqlServer();
        objConn = db.openConnect();
        // tạo mới DAO thì mở kết nối CSDL
        sharedPreferences=context.getSharedPreferences("THONGTIN", Context.MODE_PRIVATE);
    }
    int idkh=0;
    public int checkdangnhap (String username, String pass) {
        int check = 0;
        try {
            if (this.objConn != null) {

                String sqlQuery = "SELECT * FROM KhachHang where username like '"+username+"'and pass like '"+pass+"'";

                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list
                    idkh=resultSet.getInt("idKH");
                    check = resultSet.getInt("idKH");
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("idKH",String.valueOf(resultSet.getInt("idKH")));
                    editor.putString("loaitk","khach");
                    editor.putString("hoten",resultSet.getString("hoTen"));

                    editor.commit();

                }

            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu ");
            e.printStackTrace();
        }
        return check;
    }
    public User getThongTin(){
        User user=new User();
        try {
            if (this.objConn != null) {

                String sqlQuery = "SELECT * FROM KhachHang where idKH="+String.valueOf(idkh);

                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list

                    user.setIdUser(resultSet.getInt("idKH"));
                    user.setHoTen(resultSet.getString("hoTen"));
                    user.setDiaChi(resultSet.getString("diaChi"));
                    user.setSdt(resultSet.getString("sdt"));
                    user.setTenDangNhap(resultSet.getString("username"));
                    user.setPass(resultSet.getString("pass"));

                }

            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu ");
            e.printStackTrace();
        }
        return user;
    }
}
