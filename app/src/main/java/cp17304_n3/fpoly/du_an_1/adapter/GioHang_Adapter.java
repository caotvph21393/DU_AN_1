package cp17304_n3.fpoly.du_an_1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.DTO.giohang;
import cp17304_n3.fpoly.du_an_1.R;

public class GioHang_Adapter extends RecyclerView.Adapter<GioHang_Adapter.ViewHolder>  {
    private ArrayList<Sach> list;
    private Context context;

    public GioHang_Adapter(ArrayList<Sach> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_gio_hang,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtten.setText(list.get(position).getTenSach());
        holder.txtgia.setText(String.valueOf(list.get(position).getGia())+"đ");
        Picasso.get().load(list.get(position).getLinkAnh()).into(holder.ivanh);
        holder.txtsoluong.setText("1");
        holder.ivcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dem=Integer.parseInt(String.valueOf(holder.txtsoluong.getText()));
                dem++;
                holder.txtsoluong.setText(String.valueOf(dem));
            }
        });
        holder.ivchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dem=Integer.parseInt(String.valueOf(holder.txtsoluong.getText()));
                dem--;
                holder.txtsoluong.setText(String.valueOf(dem));
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten,txtgia,txtsoluong;
        ImageView ivcong,ivchu,ivanh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten=itemView.findViewById(R.id.txttensachgiohang);
            txtgia=itemView.findViewById(R.id.txtgiagiohang);
            txtsoluong=itemView.findViewById(R.id.txtsoluonggiohang);
            ivanh=itemView.findViewById(R.id.ivitemgiohang);
            ivchu=itemView.findViewById(R.id.ivtrugiohang);
            ivcong=itemView.findViewById(R.id.ivcongsgiohang);
        }
    }

}
