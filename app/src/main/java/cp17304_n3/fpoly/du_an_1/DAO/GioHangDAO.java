package cp17304_n3.fpoly.du_an_1.DAO;

import android.content.SharedPreferences;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;

public class GioHangDAO {
    Connection objConn;

    public GioHangDAO(){
        // hàm khởi tạo để mở kết nối
        DbSqlServer db = new DbSqlServer();
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL

    }

    public ArrayList<Sach> getAllSachGioHang(String idKH){
        ArrayList<Sach> list=new ArrayList<>();
        try {
            if (this.objConn != null) {

                String sqlQuery = "select s.idSach,s.tenSach,s.linkAnh,s.giaTien from GioHang as gh join Sach as s on gh.idSach=s.idSach join KhachHang as kh on kh.idKH=gh.idKH where gh.idKH="+idKH;
                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn
                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list

                    Sach objCat = new Sach();
                    objCat.setIdSach(resultSet.getInt("idSach")); // truyền tên cột dữ liệu
                    objCat.setLinkAnh(resultSet.getString("linkAnh"));
                    objCat.setGia(resultSet.getInt("giaTien"));
                    objCat.setTenSach(resultSet.getString("tenSach")); // tên cột dữ liệu là name
                    list.add(objCat);
                    //Log.e("aa","ok");
                }
            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
        } catch (Exception e) {
            Log.e("zzzzzzzzzz", "getAll: Có lỗi truy vấn dữ liệu " );
            e.printStackTrace();
        }
        return list;
    }

    public boolean ThemVaoGioHang(int idsach,int idkh) throws SQLException {

                String sqlQuery = "insert into GioHang value( "+String.valueOf(idsach)+","+String.valueOf(idkh)+")";

                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn

                if(statement.executeUpdate(sqlQuery)>0) {
                    objConn.close();
                    return true;
                }else {
                    objConn.close();
                    return false;
    }

}
//check xem sp đã dc thêm vào gio hang hay chua
    public boolean checkthemgiohang (int idsach, int idkh) throws SQLException {
                String sqlQuery = "SELECT * FROM GioHang where idSach="+String.valueOf(idsach)+"and idKH= "+String.valueOf(idkh);

                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn
                if (resultSet!=null){
                    return true;
            } else {
                    return false;
                }
    }
}
