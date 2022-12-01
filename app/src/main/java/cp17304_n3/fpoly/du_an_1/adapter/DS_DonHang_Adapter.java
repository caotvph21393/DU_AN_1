package cp17304_n3.fpoly.du_an_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cp17304_n3.fpoly.du_an_1.DTO.HoaDon;
import cp17304_n3.fpoly.du_an_1.R;

public class DS_DonHang_Adapter extends BaseAdapter {
    private Context context;
private ArrayList<HoaDon> arrayList=new ArrayList<>();
private int layout;

    public DS_DonHang_Adapter(Context context, ArrayList<HoaDon> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        LayoutInflater inflate=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
if (convertView==null){
convertView=inflate.inflate(layout,null);
    ImageView imageView=convertView.findViewById(R.id.item_img);
    TextView tvTg=convertView.findViewById(R.id.item_thoiGian);
    TextView tvTt=convertView.findViewById(R.id.item_TrangThai);

    //imageViewi.setImageResource(arrayList.get(position).getImg());
    tvTg.setText((CharSequence) arrayList.get(position).getThoiGian());
    tvTt.setText(arrayList.get(position).getTrangThai());
}
        return convertView;
    }
}
