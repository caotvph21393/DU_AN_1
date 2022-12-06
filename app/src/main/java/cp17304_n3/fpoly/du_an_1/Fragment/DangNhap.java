package cp17304_n3.fpoly.du_an_1.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;
import cp17304_n3.fpoly.du_an_1.ManHinhChao;
import cp17304_n3.fpoly.du_an_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DangNhap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DangNhap extends Fragment {

    public static DangNhap newInstance() {
        DangNhap fragment = new DangNhap();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private EditText id_edt_login;
    private TextInputEditText etPasswordLayout;
    private CheckBox chk_login;
    private Button btn_login;

    DbSqlServer db = new DbSqlServer();
    Connection connection = db.openConnect();
    Statement stmt;
    ResultSet rs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dang_nhap, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        id_edt_login = view.findViewById(R.id.id_edt_login);
        etPasswordLayout = view.findViewById(R.id.etPassword_login);
        chk_login = view.findViewById(R.id.chk_login);
        btn_login= view.findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_edt_login.getText().toString().isEmpty() || etPasswordLayout.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Bạn chưa nhập username hoặc password", Toast.LENGTH_SHORT).show();
                }
                else {
                    checkLogin checkLogin = new checkLogin();
                    checkLogin.execute("");
                }
                
            }
        });


    }
    public class checkLogin extends AsyncTask<String, String, String>{

        String z = "";
        Boolean inSucces = false;

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String s) {
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                String sql = "select * from KhachHang where username like '"+id_edt_login.getText().toString()+"' and pass like '"+etPasswordLayout.getText().toString()+"' ";
                 stmt = connection.createStatement();// khởi tạo cấu trúc truy vấn
                 rs = stmt.executeQuery(sql);// thực thi câu lệnh truy vấn

                if(rs.next()){
                    Toast.makeText(getActivity(), "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), ManHinhChao.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Bạn nhâp sai email hoặc password", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                inSucces = false;
                Log.d("SQL error : ", e.getMessage());
            }

            return z;
        }
    }
    
}