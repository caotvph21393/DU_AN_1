package cp17304_n3.fpoly.du_an_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import cp17304_n3.fpoly.du_an_1.DAO.GioHangDAO;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;

public class ChiTietSachActivity extends AppCompatActivity {
    TextView txtmota,txtgiasach,txttensach;
    ImageView ivctsp;
    Toolbar toolbar;
    Button btnmaungay,btnthemgiohang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sach);
        txtmota=findViewById(R.id.txtmotactsp);
        txtgiasach=findViewById(R.id.txtgiactsp);
        txttensach=findViewById(R.id.txttensachctsp);
        ivctsp=findViewById(R.id.ivctsp);
        toolbar=findViewById(R.id.toolbarctsp);
        btnmaungay=findViewById(R.id.btnmuangay);
        btnthemgiohang=findViewById(R.id.btnthemgiohang);
        ActionToolBar();
        initdata();
        btnthemgiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickThemGioHang();
            }
        });

    }
    // lấy dữ liệu và gán thông tin sách
    private void initdata() {
        Sach sach= (Sach) getIntent().getSerializableExtra("chitietsanpham");
        txttensach.setText(sach.getTenSach());

        txtgiasach.setText("Giá: "+sach.getGia()+"đ");
        txtmota.setText(sach.getMoTa());
        Picasso.get().load(sach.getLinkAnh()).into(ivctsp);

    }

    private void ActionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void clickThemGioHang(){
        GioHangDAO dao=new GioHangDAO();

    }
    
}