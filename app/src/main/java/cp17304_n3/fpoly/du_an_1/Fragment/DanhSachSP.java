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
import java.util.List;

import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.danhsachsp_adapter;
import cp17304_n3.fpoly.du_an_1.model.danh_sach_san_pham;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DanhSachSP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DanhSachSP extends Fragment {



    public DanhSachSP() {
        // Required empty public constructor
    }

    public static DanhSachSP newInstance() {
        DanhSachSP fragment = new DanhSachSP();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private ListView id_lv_danhsachsp;
    private ArrayList<danh_sach_san_pham> list = new ArrayList<>();
    private danhsachsp_adapter adapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_sach_s_p, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        id_lv_danhsachsp = view.findViewById(R.id.id_lv_danhsachsp);

        Themsp();

        adapter = new danhsachsp_adapter(getActivity(),R.layout.layout_item_danhsachsp, list);
        id_lv_danhsachsp.setAdapter(adapter);
    }

    private void Themsp(){
        list.add(new danh_sach_san_pham("sóng", R.drawable.song, 20000));
        list.add(new danh_sach_san_pham("chân trọng chính mính", R.drawable.sach_hay_tran_trong_chinh_minh, 30000));
        list.add(new danh_sach_san_pham("sự kỳ diệu của nước sóng", R.drawable.su_ky_dieu_cua_nuoc_song, 40000));
        list.add(new danh_sach_san_pham("đắc nhân tâm", R.drawable.dacnhantam, 50000));
        list.add(new danh_sach_san_pham("sóng", R.drawable.song, 60000));
        list.add(new danh_sach_san_pham("cuộc sống không giới hạn", R.drawable.cuoc_song_khong_gioi_han, 100000));
    }
}