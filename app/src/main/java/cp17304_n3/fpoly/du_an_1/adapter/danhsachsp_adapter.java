package cp17304_n3.fpoly.du_an_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.DTO.danh_sach_san_pham;

public class danhsachsp_adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<danh_sach_san_pham> danhsach_list;

    public danhsachsp_adapter(Context context, int layout, List<danh_sach_san_pham> danhsach_list) {
        this.context = context;
        this.layout = layout;
        this.danhsach_list = danhsach_list;
    }

    @Override
    public int getCount() {
        return danhsach_list.size();
    }

    @Override
    public Object getItem(int position) {return null;}

    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout,null);

        // ánh xạ
        ImageView img_danhsachsp_item = convertView.findViewById(R.id.img_danhsachsp_item);
        TextView  tv_item_danhsach_name = convertView.findViewById(R.id.tv_item_danhsach_name);
        TextView tv_danhsachsp_gia = convertView.findViewById(R.id.tv_danhsachsp_gia);

        danh_sach_san_pham danh_sach_san_pham = danhsach_list.get(position);

        img_danhsachsp_item.setImageResource(danh_sach_san_pham.getImg());
        tv_item_danhsach_name.setText(danh_sach_san_pham.getName());
        tv_danhsachsp_gia.setText(danh_sach_san_pham.getGia()+ "");

        return convertView;
    }
}
