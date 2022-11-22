package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import cp17304_n3.fpoly.du_an_1.Adapter.DS_DonHang_Adapter;
import cp17304_n3.fpoly.du_an_1.DTO.DanhSachDonHang;
import cp17304_n3.fpoly.du_an_1.R;


public class danhSachDonHang extends Fragment {
    private ListView lv;
    private ArrayList<DanhSachDonHang> arrayList=new ArrayList<>();
    private DS_DonHang_Adapter adapter;


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
        lv=view.findViewById(R.id.lv_DanhSachDonHang);
        arrayList.add(new DanhSachDonHang(R.drawable.ic_android_black_24dp,null,"đã thanh toán"));
        adapter=new DS_DonHang_Adapter(getContext(),arrayList,R.layout.item_danhsachdonhang);
        lv.setAdapter(adapter);


    }
}