package cp17304_n3.fpoly.du_an_1.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cp17304_n3.fpoly.du_an_1.DTO.giohang;
import cp17304_n3.fpoly.du_an_1.R;

public class GioHang_Adapter  extends BaseAdapter{
    private ArrayList<giohang>arrayList ;
    private Context mContext;
    public GioHang_Adapter(Context mContext) {
        this.mContext = mContext;

    }
    public void setData(ArrayList<giohang>array){

        this.arrayList  = array;
        notifyDataSetChanged();//mỗi khi truyền arr khác sẽ refresh lại
    }
    public static class myViewHoder{
        //chứa tất cả các view có trong layout_item
        private ImageView imgAvata;
        private TextView tvTenSp,tvGiaSp;

    }
    @Override
    public int getCount() {
        if (arrayList!=null)
            //trả về độ dài của mảng dữ liệu
            return arrayList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {

        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myViewHoder hoder=null;
        //
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView==null){
            //gom layout_item thành 1 view để gắn cho convertView
            convertView=inflater.inflate(R.layout.giohang_listview_custom,null);
            hoder=new myViewHoder();
            //
            hoder.imgAvata = convertView.findViewById(R.id.item_giohang_image);
            hoder.tvTenSp = convertView.findViewById(R.id.item_giohang_tensp);
            hoder.tvGiaSp = convertView.findViewById(R.id.item_giohang_giasp);

            convertView.setTag(hoder);//túi

        }else {
            hoder = (myViewHoder) convertView.getTag();
        }
        hoder.imgAvata.setImageResource(arrayList.get(position).getAvataBook());
        hoder.tvTenSp.setText(arrayList.get(position).getTenSach());
        hoder.tvGiaSp.setText(arrayList.get(position).getGiaSach());


        return convertView;
    }
}
