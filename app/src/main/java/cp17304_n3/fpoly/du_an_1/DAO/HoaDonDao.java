package cp17304_n3.fpoly.du_an_1.DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;

public class HoaDonDao {
    Connection objConn;
    public HoaDonDao(){
        // hàm khởi tạo để mở kết nối
        DbSqlServer db = new DbSqlServer();
        objConn = db.openConnect(); // tạo mới DAO thì mở kết nối CSDL
    }
    public List<HoaDon> getAll(){
        List<HoaDon> listCat = new ArrayList<HoaDon>();

        try {
            if (this.objConn != null) {

                String sqlQuery = "SELECT * FROM HoaDon ";

                Statement statement = this.objConn.createStatement(); // khởi tạo cấu trúc truy vấn

                ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

                while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list

                    HoaDon objCat = new HoaDon();
                    objCat.setIdHoaDon(resultSet.getInt("idHoaDon")); // truyền tên cột dữ liệu
                    objCat.setIdKH(resultSet.getInt("idKH")); // tên cột dữ liệu là name
                    objCat.setIdNV(resultSet.getInt("idNV"));
                    objCat.setThoiGian(resultSet.getDate("ThoiGian"));
                    objCat.setTrangThai(resultSet.getString("TrangThai"));
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

//    public void insertRow (HoaDon objCat){
//
//        try {
//            if (this.connection != null) {
//                // ghép chuỗi SQL
//                String insertSQL = "INSERT INTO HoaDon VALUES ("+objCat.getIdUser()+","+objCat.getThoiGian()+","+objCat.getTrangThai()+") ";
//
//                String generatedColumns[] = { "ID" };
//                PreparedStatement stmtInsert = this.connection.prepareStatement(insertSQL, generatedColumns);
//                stmtInsert.execute();
//
//                Log.d("zzzzz", "insertRow: finish insert");
//                // lấy ra ID cột tự động tăng
//                ResultSet rs = stmtInsert.getGeneratedKeys();
//                if (rs.next()) {
//                    long id = rs.getLong(1);
//                    Log.d("zzzz", "insertRow: ID = " + id);
//                }
//
//            } // nếu kết nối khác null thì mới select và thêm dữ liệu vào, nếu không thì trả về ds rỗng
//
//
//        } catch (Exception e) {
//            Log.e("zzzzzzzzzz", "insertRow: Có lỗi thêm dữ liệu " );
//            e.printStackTrace();
//        }
//    }
}
