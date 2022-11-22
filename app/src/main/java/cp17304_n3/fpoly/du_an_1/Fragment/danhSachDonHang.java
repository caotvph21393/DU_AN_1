package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cp17304_n3.fpoly.du_an_1.R;


public class danhSachDonHang extends Fragment {


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
}