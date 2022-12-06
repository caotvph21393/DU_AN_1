package cp17304_n3.fpoly.du_an_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DAO.HoaDonDao;
import cp17304_n3.fpoly.du_an_1.DAO.SachDao;
//import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;
import cp17304_n3.fpoly.du_an_1.Fragment.DangKi;
import cp17304_n3.fpoly.du_an_1.Fragment.DangNhap;
import cp17304_n3.fpoly.du_an_1.Fragment.DanhSachSP;
import cp17304_n3.fpoly.du_an_1.Fragment.GioHang;
import cp17304_n3.fpoly.du_an_1.Fragment.ThemSP;
import cp17304_n3.fpoly.du_an_1.Fragment.ThongKe;
import cp17304_n3.fpoly.du_an_1.Fragment.danhSachDonHang;

public class MainActivity extends AppCompatActivity implements DangNhap.ISendData {
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
        navigationView=findViewById(R.id.id_naviView);

        View headerLayout=navigationView.getHeaderView(0);
        TextView loginusername=headerLayout.findViewById(R.id.login_username);
        SharedPreferences sharedPreferences=getSharedPreferences("THONGTIN",MODE_PRIVATE);
        String hoTen= sharedPreferences.getString("hoten","");
        loginusername.setText(hoTen);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        FragmentManager fragmentManager = getSupportFragmentManager();
        DanhSachSP danhSachSP = new DanhSachSP();
        fragmentManager.beginTransaction().replace(R.id.id_frameLayout,danhSachSP).commit();
        navigationView = findViewById(R.id.id_naviView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                toolbar.setTitle(item.getTitle());

                return false;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_frameLayout,fragment);
        transaction.commit();

    }




    @Override
    public void sendIdKH(int idKH) {
        GioHang gioHang= (GioHang) getSupportFragmentManager().findFragmentById(R.id.id_frameLayout);
        gioHang.receiveIdKH(idKH);
    }
}