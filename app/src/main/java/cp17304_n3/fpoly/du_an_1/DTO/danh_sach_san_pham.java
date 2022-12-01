package cp17304_n3.fpoly.du_an_1.DTO;

public class danh_sach_san_pham {
    private  String name;
    private int img;
    private double gia;

    public danh_sach_san_pham(String name, int img, double gia) {
        this.name = name;
        this.img = img;
        this.gia = gia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}

