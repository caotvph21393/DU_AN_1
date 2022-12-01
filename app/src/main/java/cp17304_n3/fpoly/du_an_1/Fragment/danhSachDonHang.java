package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


import cp17304_n3.fpoly.du_an_1.DAO.HoaDonDao;

import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;

import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.DS_DonHang_Adapter;


public class danhSachDonHang extends Fragment {
    private ListView lv;
    private ArrayList<HoaDon> arrayList=new ArrayList<>();
    private DS_DonHang_Adapter adapter;


    HoaDonDao hoaDonDao=new HoaDonDao();

    List<HoaDon> list =new ArrayList<>();

    public danhSachDonHang() {
        // Required empty public constructor
    }


    public static danhSachDonHang newInstance() {
        danhSachDonHang fragment = new danhSachDonHang();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_sach_don_hang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv=view.findViewById(R.id.lvHoaDon);
        //arrayList.add(new HoaDon(R.drawable.ic_android_black_24dp,null,"đã thanh toán"));
        adapter=new DS_DonHang_Adapter(getContext(),arrayList,R.layout.item_danhsachdonhang);
        lv.setAdapter(adapter);



        list=hoaDonDao.getAll();
        for(int i = 0; i<list.size(); i++){
            HoaDon objCat = list.get(i);

            Log.d("aaa", "onCreate: phần tử thứ " + i + ":  id = " + objCat.getIdHoaDon() + ", name = " + objCat.getTrangThai());

        }


    }
}