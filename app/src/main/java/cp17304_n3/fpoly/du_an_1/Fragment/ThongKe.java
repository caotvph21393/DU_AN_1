package cp17304_n3.fpoly.du_an_1.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cp17304_n3.fpoly.du_an_1.DAO.ThongKeDAO;
import cp17304_n3.fpoly.du_an_1.R;


public class ThongKe extends Fragment {
    ImageView ivngay,ivthang;
    TextView txtngay,txtmenuthang,txtthang,txtdoanhthungay,txtdoanhthuthang,txtsodonhangngay,txtsodonhangthang,txtsosachdaban;
    ThongKeDAO dao=new ThongKeDAO();

    public static Fragment newInstance() {
        ThongKe fragment = new ThongKe();



        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_thong_ke, container, false);
        ivngay=view.findViewById(R.id.ivngay);
        txtngay=view.findViewById(R.id.txtngay);
        ivthang=view.findViewById(R.id.ivthang);
        txtmenuthang=view.findViewById(R.id.txtmenuthang);
        txtthang=view.findViewById(R.id.txtthang);
        txtdoanhthungay=view.findViewById(R.id.txtdoanhthungay);
        txtdoanhthuthang=view.findViewById(R.id.txtdoanhthuthang);
        txtsodonhangngay=view.findViewById(R.id.txtsodonhangngay);
        txtsodonhangthang=view.findViewById(R.id.txtsodonhangthang);
        txtsosachdaban=view.findViewById(R.id.txtsosangdaban);

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        String datetime = dateformat.format(calendar.getTime());
        String mounth=datetime.substring(5,7) ;
        txtngay.setText(datetime);
        txtthang.setText("Tháng "+mounth);
        ngay(datetime);
        thang(mounth);



        ivngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String ngay="";
                        String thang="";
                        if(dayOfMonth<10){
                            ngay="0"+dayOfMonth;
                        }else {
                            ngay=String.valueOf(dayOfMonth);
                        }
                        if((month+1)<10){
                            thang="0"+(month+1);
                        }else {
                            thang=String.valueOf((month+1));
                        }
                        txtngay.setText(year+"/"+thang+"/"+ngay);
                        ngay(datetime);

                    }
                },calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        ivthang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuthang();
            }
        });



        return view;

    }
    public void menuthang(){
        PopupMenu popupMenu=new PopupMenu(getContext(),txtmenuthang);
        MenuInflater info=popupMenu.getMenuInflater();
        info.inflate(R.menu.menuthang,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.m1:
                        txtthang.setText("Tháng 1");
                        thang("1");
                        break;
                    case R.id.m2:
                        txtthang.setText("Tháng 2");
                        thang("2");
                        break;
                    case R.id.m3:
                        txtthang.setText("Tháng 3");
                        thang("3");
                        break;
                    case R.id.m4:
                        txtthang.setText("Tháng 4");
                        thang("4");
                        break;
                    case R.id.m5:
                        txtthang.setText("Tháng 5");
                        thang("5");
                        break;
                    case R.id.m6:
                        txtthang.setText("Tháng 6");
                        thang("6");
                        break;
                    case R.id.m7:
                        txtthang.setText("Tháng 7");
                        thang("7");
                        break;
                    case R.id.m8:
                        txtthang.setText("Tháng 8");
                        thang("8");
                        break;
                    case R.id.m9:
                        txtthang.setText("Tháng 9");
                        thang("9");
                        break;
                    case R.id.m10:
                        txtthang.setText("Tháng 10");
                        thang("10");
                        break;
                    case R.id.m11:
                        txtthang.setText("Tháng 11");
                        thang("11");
                        break;
                    case R.id.m12:
                        txtthang.setText("Tháng 12");
                        thang("12");
                        break;

                }
                return false;
            }
        });
        popupMenu.show();


    }
    public void thang(String mounth){
        String sodonhangthang= String.valueOf(dao.getSoHoaDonThang(mounth));
        txtsodonhangthang.setText(sodonhangthang);
        String doanhthuthang= String.valueOf(dao.getDoanhThuThang(mounth));
        txtdoanhthuthang.setText(doanhthuthang);
    }
    public void ngay(String datetime){
        String sodonhangngay= String.valueOf(dao.getSoHoaDonNgay(datetime));
        txtsodonhangngay.setText(sodonhangngay);
        String sosachdaban= String.valueOf(dao.getSoLuongSachDaBan(datetime));
        txtsosachdaban.setText(sosachdaban);
        String doanhthungay= String.valueOf(dao.getDoanhThuNgay(datetime));
        txtdoanhthungay.setText(doanhthungay);
    }
}