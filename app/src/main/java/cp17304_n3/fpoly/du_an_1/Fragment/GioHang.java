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

import cp17304_n3.fpoly.du_an_1.DTO.giohang;
import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.GioHang_Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GioHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GioHang extends Fragment {
    private ListView lv_GioHang;
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
        lv_GioHang = view.findViewById(R.id.lv_GioHang);

        arrayList.add(new giohang("a","a",R.drawable.ic_baseline_menu_book_24));
        arrayList.add(new giohang("b","b",R.drawable.ic_baseline_menu_book_24));


        adapter = new GioHang_Adapter(getContext());
        adapter.setData(arrayList);
        lv_GioHang.setAdapter(adapter);
    }
}