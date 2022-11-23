package cp17304_n3.fpoly.du_an_1.Fragment;

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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cp17304_n3.fpoly.du_an_1.R;
import cp17304_n3.fpoly.du_an_1.adapter.Photo_Adapter;
import cp17304_n3.fpoly.du_an_1.adapter.danhsachsp_adapter;
import cp17304_n3.fpoly.du_an_1.model.Photo;
import cp17304_n3.fpoly.du_an_1.model.danh_sach_san_pham;
import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DanhSachSP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DanhSachSP extends Fragment {



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

    private ListView id_lv_danhsachsp;
    private ArrayList<danh_sach_san_pham> list = new ArrayList<>();
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
        id_lv_danhsachsp = view.findViewById(R.id.id_lv_danhsachsp);
        id_viewpager = view.findViewById(R.id.id_viewpager);
        circle_indiacator = view.findViewById(R.id.circle_indiacator);

        Themsp();

        adapter = new danhsachsp_adapter(getActivity(),R.layout.layout_item_danhsachsp, list);
        id_lv_danhsachsp.setAdapter(adapter);

        list_photo = getListPhoto();
        photo_adapter = new Photo_Adapter(getActivity(),list_photo);
        id_viewpager.setAdapter(photo_adapter);

        circle_indiacator.setViewPager(id_viewpager);
        photo_adapter.registerDataSetObserver(circle_indiacator.getDataSetObserver());

        autoSLideImages();
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
        list.add(new danh_sach_san_pham("sóng", R.drawable.song, 20000));
        list.add(new danh_sach_san_pham("doraemon", R.drawable.doraemon_1, 30000));
        list.add(new danh_sach_san_pham("công tắc tình yêu", R.drawable.ngon_tinh_2, 40000));
        list.add(new danh_sach_san_pham("đắc nhân tâm", R.drawable.dacnhantam, 50000));
        list.add(new danh_sach_san_pham("sóng", R.drawable.song, 60000));
        list.add(new danh_sach_san_pham("vì em gặp anh", R.drawable.ngon_tinh_1, 88000));
        list.add(new danh_sach_san_pham("Cuộc sống 'đếch' giống cuộc đời", R.drawable.cuoc_song, 23000));
        list.add(new danh_sach_san_pham("Bạn mới là chủ nhân cuộc đời mình", R.drawable.ban_moi_la_chu_nhan_cua_doi_minh, 35000));
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