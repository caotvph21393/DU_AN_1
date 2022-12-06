package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DTO.giohang;
import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;
import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.GioHang_Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GioHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GioHang extends Fragment {
    private Button btnMuaHang;
    private ListView mlistView;
    private ArrayList<giohang> arrayList = new ArrayList<>();
    private GioHang_Adapter adapter;

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
        return inflater.inflate(R.layout.fragment_gio_hang, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mlistView = view.findViewById(R.id.lv);
        btnMuaHang = view.findViewById(R.id.btnMuaHang);
        giohang user3 = new giohang();
        user3.setTenSach("Đắc Nhân Tâm");
        user3.setGiaSach("50000đ");
        user3.setAvataBook(R.drawable.dacnhantam);
        arrayList.add(user3);
        adapter= new GioHang_Adapter(getContext());
        adapter.setData(arrayList);
        mlistView.setAdapter(adapter);

    }
}