package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cp17304_n3.fpoly.du_an_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThemSP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThemSP extends Fragment {

    private EditText TenSach,TenNhaXuatBan,GiaTien ;
    private Button DangSanPham,Huy,UpdateSanPham;
    private TextView ChiTietSanPham;

    public ThemSP() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ThemSP newInstance() {
        ThemSP fragment = new ThemSP();

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
        return inflater.inflate(R.layout.fragment_them_s_p, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TenSach=view.findViewById(R.id.TenSach);
        TenNhaXuatBan=view.findViewById(R.id.TenNhaXuatBan);
        GiaTien=view.findViewById(R.id.GiaTien);
        DangSanPham=view.findViewById(R.id.DangSanPham);
        Huy=view.findViewById(R.id.Huy);
        UpdateSanPham=view.findViewById(R.id.UpdateSanPham);

        DangSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Đãng Hoàn Tất", Toast.LENGTH_SHORT).show();
            }
        });

        Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Đang Về Trang Chủ", Toast.LENGTH_SHORT).show();

            }
        });

        UpdateSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Update Hoàn Tất", Toast.LENGTH_SHORT).show();
            }
        });
    }
}