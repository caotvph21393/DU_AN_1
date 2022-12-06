package cp17304_n3.fpoly.du_an_1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.R;

public class danhsachsp_adapter extends BaseAdapter {
    private List<Sach> list;
    private Context context;

    public danhsachsp_adapter(List<Sach> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public static class viewHolder{
        TextView txttensach,txtgiasach;
        ImageView ivsach;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        viewHolder holder;
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        if(view==null){
            view=inflater.inflate(R.layout.layout_item_danhsachsp,null);
            holder=new viewHolder();
            holder.txtgiasach= view.findViewById(R.id.txtgiasach);
            holder.txttensach= view.findViewById(R.id.txttensaxh);
            holder.ivsach=view.findViewById(R.id.ivsach);
            view.setTag(holder);
        }else{
            holder=(viewHolder) view.getTag();
        }

        Picasso.get().load(list.get(position).getLinkAnh()).into(holder.ivsach);

        holder.txttensach.setText(list.get(position).getTenSach());
        holder.txtgiasach.setText(list.get(position).getGia()+"");


        return view;
    }
}
