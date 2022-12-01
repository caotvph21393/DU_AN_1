package cp17304_n3.fpoly.du_an_1.DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;

public class SachDao {
    Connection connection;

    public SachDao() {
        DbSqlServer dbSqlServer=new DbSqlServer();
        connection= dbSqlServer.openConnect();

    }
    public List<Sach> getAll(){
List<Sach> list=new ArrayList<Sach>();
try {
    if (this.connection != null) {

        String sqlQuery = "SELECT * FROM Sach ";
        Statement statement = this.connection.createStatement(); // khởi tạo cấu trúc truy vấn
        ResultSet resultSet = statement.executeQuery(sqlQuery); // thực thi câu lệnh truy vấn

        while (resultSet.next()) { // đọc dữ liệu gán vào đối tượng và đưa vào list

            Sach objCat = new Sach();
            objCat.setIdSach(resultSet.getInt("idSach")); // truyền tên cột dữ liệu
            objCat.setGia(resultSet.getInt("GiaTien"));
            objCat.setIdNxb(resultSet.getInt("idNXB"));
            objCat.setTenSach(resultSet.getString("TenSach")); // tên cột dữ liệu là name
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


}
