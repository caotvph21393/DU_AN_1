package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cp17304_n3.fpoly.du_an_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GioHang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GioHang extends Fragment {


    public GioHang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GioHang.
     */
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
}