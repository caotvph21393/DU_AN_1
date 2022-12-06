package cp17304_n3.fpoly.du_an_1.Fragment;

import android.os.AsyncTask;
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

import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.Statement;

import cp17304_n3.fpoly.du_an_1.Datbase.DbSqlServer;
import cp17304_n3.fpoly.du_an_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DangKi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DangKi extends Fragment {





    public DangKi() {
        // Required empty public constructor
    }



    public static DangKi newInstance() {
        DangKi fragment = new DangKi();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Button btn_signup, btn_signup_cancel;
    EditText edt_signup_username, edt_signup_email;
    TextInputEditText etPassword_signup, etPassword_re_signup;

    Statement stmt;
    DbSqlServer db = new DbSqlServer();
    Connection connection = db.openConnect();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dang_ki, container, false);
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_signup = view.findViewById(R.id.btn_signup);
        btn_signup_cancel = view.findViewById(R.id.btn_signup_cancel);
        edt_signup_username = view.findViewById(R.id.edt_signup_username);
        edt_signup_email = view.findViewById(R.id.edt_signup_email);
        etPassword_signup = view.findViewById(R.id.etPassword_signup);
        etPassword_re_signup = view.findViewById(R.id.etPassword_re_signup);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etPassword_signup.getText().toString().equals(etPassword_re_signup.getText().toString())){
                    Toast.makeText(getActivity(), "Bạn phải nhập đúng mật khẩu như trên", Toast.LENGTH_SHORT).show();
                }
                else if (etPassword_signup.getText().toString().isEmpty() || etPassword_re_signup.getText().toString().isEmpty()||
                        edt_signup_email.getText().toString().isEmpty() || edt_signup_username.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else{
                    new  registeruser().execute("");
                }

            }
        });

    }

    public class registeruser extends AsyncTask<String, String, String> {


        String z = "";
        Boolean isSucces = false;

        @Override
        protected void onPreExecute() {
            Toast.makeText(getActivity(), "lưu vào database", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getActivity(), "đăng ký thành công", Toast.LENGTH_SHORT).show();
            edt_signup_username.setText("");
            edt_signup_email.setText("");
            etPassword_signup.setText("");
            etPassword_re_signup.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                String sql = "insert into KhachHang (username,diaChi,pass) values ('" + edt_signup_username.getText() + "','" + edt_signup_email.getText() + "','" + etPassword_signup.getText() + "')";
                stmt = connection.createStatement();
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                isSucces = false;
                z = e.getMessage();
            }

            return z;
        }
    }
}

