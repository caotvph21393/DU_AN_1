package cp17304_n3.fpoly.du_an_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cp17304_n3.fpoly.du_an_1.DTO.giohang;
import cp17304_n3.fpoly.du_an_1.R;

public class GioHang_Adapter extends BaseAdapter {
    private ArrayList<giohang>arrayList = new ArrayList<giohang>();
    private Context context;

    public GioHang_Adapter(Context context) {
    this.context = context;
    }
    public void setData(ArrayList<giohang>arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
    public static class ViewHolder{
        private ImageView imgDelete,imgAvataBook;
        private TextView tvTenSach,tvMoTaSach;
    }

    @Override
    public int getCount() {
        if (arrayList!=null)

            return arrayList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView==null){
            convertView = inflater.inflate(R.layout.giohang_listview_custom,null);
            viewHolder =new ViewHolder();
            viewHolder.imgAvataBook = convertView.findViewById(R.id.imgAvataBook);
            viewHolder.imgDelete = convertView.findViewById(R.id.imgDelete);
            viewHolder.tvTenSach = convertView.findViewById(R.id.tvTenSach);
            viewHolder.tvMoTaSach = convertView.findViewById(R.id.tvMoTaSach);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.tvTenSach.setText(arrayList.get(position).getTenSach());
        viewHolder.tvMoTaSach.setText(arrayList.get(position).getMoTaSach());
        viewHolder.imgAvataBook.setImageResource(arrayList.get(position).getAvataBook());

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "đã xóa", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
