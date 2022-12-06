package cp17304_n3.fpoly.du_an_1.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cp17304_n3.fpoly.du_an_1.ChiTietSachActivity;
import cp17304_n3.fpoly.du_an_1.DAO.SachDao;
import cp17304_n3.fpoly.du_an_1.DTO.Sach;
import cp17304_n3.fpoly.du_an_1.MainActivity;
import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.Photo_Adapter;
import cp17304_n3.fpoly.du_an_1.adapter.danhsachsp_adapter;
import cp17304_n3.fpoly.du_an_1.DTO.Photo;
import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DanhSachSP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DanhSachSP extends Fragment {
    GridView gridViewtrangchu;
    private List<Sach> list=new ArrayList<>();


    public DanhSachSP() {
        // Required empty public constructor
    }

    public static DanhSachSP newInstance() {
        DanhSachSP fragment = new DanhSachSP();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    private danhsachsp_adapter adapter ;

    private ViewPager id_viewpager;
    private CircleIndicator circle_indiacator;
    private Photo_Adapter photo_adapter;
    private List<Photo> list_photo;
    private Timer timer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_sach_s_p, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridViewtrangchu=view.findViewById(R.id.gvtrangchu);


        id_viewpager = view.findViewById(R.id.id_viewpager);
       circle_indiacator = view.findViewById(R.id.circle_indiacator);

        SachDao sachDao=new SachDao();
         list = sachDao.getAll();

        danhsachsp_adapter adapter=new danhsachsp_adapter(list,getContext());
        gridViewtrangchu.setAdapter(adapter);
        registerForContextMenu(gridViewtrangchu);
        gridViewtrangchu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sach sach=list.get(position);
                Intent intent=new Intent(getContext(), ChiTietSachActivity.class);
                intent.putExtra("chitietsanpham",sach);
                startActivity(intent);
            }
        });

        list_photo = getListPhoto();
        photo_adapter = new Photo_Adapter(getActivity(),list_photo);
        id_viewpager.setAdapter(photo_adapter);

        circle_indiacator.setViewPager(id_viewpager);
        photo_adapter.registerDataSetObserver(circle_indiacator.getDataSetObserver());

        autoSLideImages();
//        SachDao sachDao=new SachDao();
//        List<Sach> list = sachDao.getAll(); // lấy danh sách cho vào biến

//        // duyệt mảng in ra danh sách
//        for(int i = 0; i<listCat.size(); i++){
//            Sach objCat = listCat.get(i);
//
//            Log.d("zzzzz", "onCreate: phần tử thứ " + i + ":  id = " + objCat.getIdSach() + ", name = " + objCat.getTenSach());
//
//        }




    }

    private List<Photo> getListPhoto() {
        List<Photo> photo_list = new ArrayList<>();

        photo_list.add(new Photo(R.drawable.ngon_tinh_1));
        photo_list.add(new Photo(R.drawable.ngon_tinh_2));
        photo_list.add(new Photo(R.drawable.doraemon_1));
        photo_list.add(new Photo(R.drawable.bachuloncon));

        return photo_list;
    }

    private void Themsp(){

    }
    private void autoSLideImages(){

        if(list_photo == null || list_photo.isEmpty() || id_viewpager == null){
                return;
        }

        //khoi tao timer
        if(timer == null){
            timer = new Timer();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            int currentItem = id_viewpager.getCurrentItem();
                            int totalItem = list_photo.size() - 1;
                            if(currentItem < totalItem){
                                    currentItem ++;
                                    id_viewpager.setCurrentItem(currentItem);
                            }
                            else{
                                id_viewpager.setCurrentItem(0);
                            }
                        }
                    });
            }
        }, 500, 2222); // prriod : thời gian chuyển ảnh
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
}