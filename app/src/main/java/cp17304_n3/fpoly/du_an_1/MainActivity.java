package cp17304_n3.fpoly.du_an_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import java.sql.Connection;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DAO.SachDao;
//import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;
import cp17304_n3.fpoly.du_an_1.Fragment.DangKi;
import cp17304_n3.fpoly.du_an_1.Fragment.DangNhap;
import cp17304_n3.fpoly.du_an_1.Fragment.DanhSachSP;
import cp17304_n3.fpoly.du_an_1.Fragment.GioHang;
import cp17304_n3.fpoly.du_an_1.Fragment.ThemSP;
import cp17304_n3.fpoly.du_an_1.Fragment.ThongKe;
import cp17304_n3.fpoly.du_an_1.Fragment.danhSachDonHang;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.id_DrawerLayout);
        toolbar = findViewById(R.id.id_toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opendrawer ,R.string.closedrawer);
        toggle.syncState();
        FragmentManager manager = getSupportFragmentManager();
        DanhSachSP danhSachSP = new DanhSachSP();
        manager.beginTransaction().replace(R.id.id_frameLayout,danhSachSP).commit();
        navigationView = findViewById(R.id.id_naviView);
        navigationView.setNavigationItemSelectedListener(this);


//        DbSqlServer dbSqlServer = new DbSqlServer();
//        Connection conn = dbSqlServer.openConnect();
//        SachDao sachDao=new SachDao();
//        List<Sach> listCat = sachDao.getAll(); // lấy danh sách cho vào biến
//
//        // duyệt mảng in ra danh sách
//        for(int i = 0; i<listCat.size(); i++){
//            Sach objCat = listCat.get(i);
//
//            Log.d("zzzzz", "onCreate: phần tử thứ " + i + ":  id = " + objCat.getIdSach() + ", name = " + objCat.getTenSach());
//
//        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_TRangchu){
            replaceFragment(DanhSachSP.newInstance());
        }else if(id == R.id.nav_DangKi){
            replaceFragment(DangKi.newInstance());
        }
        else if(id == R.id.nav_DangNhap){
            replaceFragment(DangNhap.newInstance());
        }else if(id == R.id.nav_GioHang){
            replaceFragment(GioHang.newInstance());
        }else if(id == R.id.nav_DanhsachDonHang){
            replaceFragment(danhSachDonHang.newInstance());
        }
        else if(id == R.id.nav_themSP){
            replaceFragment(ThemSP.newInstance());
        }
        else if(id == R.id.nav_ThongKe){
            replaceFragment(ThongKe.newInstance());
        }

        drawerLayout.closeDrawer(navigationView);
        return true;
    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_frameLayout,fragment);
        transaction.commit();
    }
}