package cp17304_n3.fpoly.du_an_1.DTO;

import java.util.Date;

public class DanhSachDonHang {
    int img;
    int idDanhSach;
    Date NgayMua;
    String TrangThai;

    public DanhSachDonHang(int img, Date ngayMua, String trangThai) {
        this.img = img;
        NgayMua = ngayMua;
        TrangThai = trangThai;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date ngayMua) {
        NgayMua = ngayMua;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
