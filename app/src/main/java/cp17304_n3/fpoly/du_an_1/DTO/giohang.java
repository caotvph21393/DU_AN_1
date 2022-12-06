package cp17304_n3.fpoly.du_an_1.DTO;

public class giohang {
    private String tenSach,giaSach;
    private int AvataBook;
    private int idsp;
    public giohang() {

    }

    public giohang(String tenSach, String giaSach, int avataBook, int idsp) {
        this.tenSach = tenSach;
        this.giaSach = giaSach;
      this.AvataBook = avataBook;
        this.idsp = idsp;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(String giaSach) {
        this.giaSach = giaSach;
    }


    public int getAvataBook() {
        return AvataBook;
    }

    public void setAvataBook(int avataBook) {
        AvataBook = avataBook;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }
}
