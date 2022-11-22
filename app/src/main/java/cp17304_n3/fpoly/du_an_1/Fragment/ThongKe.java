package cp17304_n3.fpoly.du_an_1.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

import cp17304_n3.fpoly.du_an_1.R;


public class ThongKe extends Fragment {
     ImageView ivngay;
     TextView txtngay;

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
        Calendar calendar=Calendar.getInstance();
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

                    }
                },calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        return view;

    }
}