package cp17304_n3.fpoly.du_an_1.Datbase;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbSqlServer {
    Connection connection;
    final String TAG = "zzzzzz";
    public Connection openConnect(){
        String ip = "10.0.0.101", port = "1433", user = "sa", pass = "111111", db = "demo_bh";
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectUrl = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db +";user=" + user +";password=" + pass +";";
            this.connection = DriverManager.getConnection(connectUrl);
            Log.d(TAG, "openConnect: OK");
        } catch (Exception e) {
            Log.e(TAG, "getCollection: Loi ket noi CSDL" );
            e.printStackTrace();
        }
        return connection;
    }
}
