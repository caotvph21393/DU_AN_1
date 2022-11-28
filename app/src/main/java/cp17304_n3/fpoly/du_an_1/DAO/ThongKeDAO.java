package cp17304_n3.fpoly.du_an_1.DAO;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;

public class ThongKeDAO {
    Connection objConn;

    public ThongKeDAO() {
        DbSqlServer db=new DbSqlServer();
        objConn=db.openConnect();
    }
    public int getDoanhThuNgay(String ngay){
        ngay=ngay.replace("/","-");
        int sumday=0;
        try {
            if(this.objConn!=null){
                String sqlQuery="select sum(DonGia) as sumday from ChiTietHoaDon as cthd join DonHang as dh on cthd.idDonHang=dh.idDonHang where  dh.ThoiGian like '"+ngay+"' group by dh.ThoiGian";
                Statement statement=this.objConn.createStatement();// khởi tạo cấu trúc truy vấn

                ResultSet resultSet=statement.executeQuery(sqlQuery);// thực thi câu lệnh truy vấn
                while (resultSet.next()){//đọc dữ liệu gán vào đối tượng
                    sumday=resultSet.getInt("sumday");

                }
            }
        }catch (Exception e){
            Log.e("zzzzz","getDoanhThuNgay: co loi truy van du lieu");
            e.printStackTrace();
        }
        return sumday;

    }
    public int getDoanhThuThang(String thang){
        int summouth=0;
        try {
            if(this.objConn!=null){
                String sqlQuery="select sum(DonGia) as summonth from ChiTietHoaDon as cthd join DonHang as dh on cthd.idDonHang=dh.idDonHang where month(dh.ThoiGian)="+thang+" group by month(dh.ThoiGian)";
                Statement statement=this.objConn.createStatement();// khởi tạo cấu trúc truy vấn

                ResultSet resultSet=statement.executeQuery(sqlQuery);// thực thi câu lệnh truy vấn
                while (resultSet.next()){//đọc dữ liệu gán vào đối tượng
                    summouth=resultSet.getInt("summonth");

                }

            }
        }catch (Exception e){
            Log.e("zzzz","getDoanhThuThang:co loi truy van");
        }
        return summouth;
    }
    public int getSoHoaDonNgay(String ngay){
        ngay=ngay.replace("/","-");
        int soHoaDonNgay=0;
        try {
            if(this.objConn!=null){
                String sqlQuery="select count(idDonHang) as sodonhangngay from DonHang where  ThoiGian like '"+ngay+"' group by ThoiGian";
                Statement statement=this.objConn.createStatement();// khởi tạo cấu trúc truy vấn

                ResultSet resultSet=statement.executeQuery(sqlQuery);// thực thi câu lệnh truy vấn
                while (resultSet.next()){//đọc dữ liệu gán vào đối tượng
                    soHoaDonNgay=resultSet.getInt("sodonhangngay");

                }

            }
        }catch (Exception e){
            Log.e("zzzz","số đơn hàng ngày:co loi truy van");
        }
        return soHoaDonNgay;
    }
    public int getSoHoaDonThang(String thang){
        int soHoaDonThang=0;
        try {
            if(this.objConn!=null){
                String sqlQuery="select count(idDonHang) as sodonhangthang from DonHang where  month(ThoiGian)="+thang+" group by month(ThoiGian)";
                Statement statement=this.objConn.createStatement();// khởi tạo cấu trúc truy vấn

                ResultSet resultSet=statement.executeQuery(sqlQuery);// thực thi câu lệnh truy vấn
                while (resultSet.next()){//đọc dữ liệu gán vào đối tượng
                    soHoaDonThang=resultSet.getInt("sodonhangthang");

                }

            }
        }catch (Exception e){
            Log.e("zzzz","số đơn hàng tháng:co loi truy van");
        }


        return soHoaDonThang;
    }
    public int getSoLuongSachDaBan(String ngay){
        ngay=ngay.replace("/","-");
        int soLuongSachDaBan=0;
        try {
            if(this.objConn!=null){
                String sqlQuery="select sum(cthd.SoLuong) as sumsoluong from ChiTietHoaDon as cthd join DonHang as dh on cthd.idDonHang=dh.idDonHang where  dh.ThoiGian like '"+ngay+"' group by dh.ThoiGian";
                Statement statement=this.objConn.createStatement();// khởi tạo cấu trúc truy vấn

                ResultSet resultSet=statement.executeQuery(sqlQuery);// thực thi câu lệnh truy vấn
                while (resultSet.next()){//đọc dữ liệu gán vào đối tượng
                    soLuongSachDaBan=resultSet.getInt("sumsoluong");

                }

            }
        }catch (Exception e){
            Log.e("zzzz","số lượng sách đã bán:co loi truy van");
        }
        return soLuongSachDaBan;
    }

}
