package cp17304_n3.fpoly.du_an_1.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cp17304_n3.fpoly.du_an_1.DAO.KhachHangDAO;
import cp17304_n3.fpoly.du_an_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DangNhap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DangNhap extends Fragment {
    EditText edtusername, edtpass;
    Button btndangnhap;
    private ISendData mISendData;


    public interface ISendData{
        void sendIdKH (int idKH);
    }

    

    public static DangNhap newInstance() {
        DangNhap fragment = new DangNhap();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mISendData= (ISendData) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dang_nhap, container, false);
        edtusername=view.findViewById(R.id.id_edt_login);
        edtpass=view.findViewById(R.id.edtPassword);
        btndangnhap=view.findViewById(R.id.btndangnhap);
        KhachHangDAO dao=new KhachHangDAO(getContext());

        FragmentManager fm = getFragmentManager();
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edtusername.getText().toString().trim();
                String pass=edtpass.getText().toString().trim();
                int check=dao.checkdangnhap(username,pass);
                if(check !=0){
                    FragmentTransaction ft_rep = fm.beginTransaction();
                    ft_rep.replace(R.id.id_frameLayout, new DanhSachSP());
                    ft_rep.commit();
                    Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                    sendIdKH(check);
                }else {
                    Toast.makeText(getContext(), "tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });

      return view;
    }

    private void sendIdKH(int check) {

        mISendData.sendIdKH(check);
    }

}


