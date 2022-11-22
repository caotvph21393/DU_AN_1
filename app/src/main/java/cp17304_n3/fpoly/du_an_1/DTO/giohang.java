package cp17304_n3.fpoly.du_an_1.DTO;

public class giohang {
    private String tenSach,moTaSach;
    private int AvataBook;
    public giohang() {

    }

    public giohang(String tenSach, String moTaSach, int avataBook) {
        this.tenSach = tenSach;
        this.moTaSach = moTaSach;
        AvataBook = avataBook;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMoTaSach() {
        return moTaSach;
    }

    public void setMoTaSach(String moTaSach) {
        this.moTaSach = moTaSach;
    }

    public int getAvataBook() {
        return AvataBook;
    }

    public void setAvataBook(int avataBook) {
        AvataBook = avataBook;
    }
}
