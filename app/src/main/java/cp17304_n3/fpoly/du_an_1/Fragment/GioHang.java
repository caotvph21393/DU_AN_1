package cp17304_n3.fpoly.du_an_1.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import cp17304_n3.fpoly.du_an_1.DAO.GioHangDAO;
import cp17304_n3.fpoly.du_an_1.DAO.KhachHangDAO;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.DTO.User;
import cp17304_n3.fpoly.du_an_1.DTO.giohang;
import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.GioHang_Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GioHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GioHang extends Fragment {
    GioHangDAO gioHangDAO;
    RecyclerView recyclerGioHang;
    ArrayList<Sach> list;
    User user= new User();


    public GioHang() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GioHang newInstance() {
        GioHang fragment = new GioHang();

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
        View view= inflater.inflate(R.layout.fragment_gio_hang, container, false);
        recyclerGioHang=view.findViewById(R.id.rvgiohang);
        //loadData();
        return view;
    }

    private void loadData() {

        KhachHangDAO khachHangDAO=new KhachHangDAO(getContext());
        user=khachHangDAO.getThongTin();

        gioHangDAO= new GioHangDAO();
        int idKH=user.getIdUser();
        list=gioHangDAO.getAllSachGioHang(String.valueOf(idKH));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerGioHang.setLayoutManager(linearLayoutManager);
        GioHang_Adapter adapter=new GioHang_Adapter(list,getContext());
        recyclerGioHang.setAdapter(adapter);

    }
    public void  receiveIdKH(int idKH){
        gioHangDAO= new GioHangDAO();

        list=gioHangDAO.getAllSachGioHang(String.valueOf(idKH));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerGioHang.setLayoutManager(linearLayoutManager);
        GioHang_Adapter adapter=new GioHang_Adapter(list,getContext());
        recyclerGioHang.setAdapter(adapter);

    }


}