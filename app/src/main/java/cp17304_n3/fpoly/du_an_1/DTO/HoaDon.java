package cp17304_n3.fpoly.du_an_1.DTO;

import java.util.Date;

public class HoaDon {
    int idHoaDon;
    int idUser;
    Date ThoiGian;
    String TrangThai;

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
