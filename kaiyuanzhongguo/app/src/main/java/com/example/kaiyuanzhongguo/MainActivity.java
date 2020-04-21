package com.example.kaiyuanzhongguo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.itheima.loopviewpager.LoopViewPager;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.L;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
//    @BindView(R.id.recycler_view)
//    ItheimaRecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private ItheimaRecyclerView mRecyclerView;
    LoopViewPager mLoopViewPager;
    private Button button;

    private int state=0;
    private static final int STATE_PEFRESH =1;
    private static final int STATE_MORE =2;

    private String nextPageToken = "";
    ArrayList<NewsBean.ResultBean.ItemsBean> itemEntities = new ArrayList<>();
    private NewsBean mNewsBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RecyclerViewHeader header = (RecyclerViewHeader) findViewById(R.id.recycler_header);
        mRecyclerView = (ItheimaRecyclerView)findViewById(R.id.recyclerview);
        header.attachTo(mRecyclerView);

        mLoopViewPager = (LoopViewPager) findViewById(R.id.lvp_pager);
//        mLoopViewPager.setImgData(DataFactory.imgListString());
//        mLoopViewPager.setTitleData(DataFactory.titleListString());
//        mLoopViewPager.start();
        Button button1=findViewById(R.id.my_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,BlogActivity.class);
                startActivity(intent);
            }
        });



        initialBanner();

        ItemClickSupport itemClickSupport = new ItemClickSupport(mRecyclerView);

        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                Toast.makeText(recyclerView.getContext(), "我被点击了", Toast.LENGTH_SHORT).show();
                int id=itemEntities.get(position).getId();
                Intent intent=new Intent(MainActivity.this,DeatailActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(mSwipeRefreshLayout, mRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_news;
            }

            @Override
            public String getApi() {
                String url="action/apiv2/news?pageToken=";
                switch (state){
                    case STATE_PEFRESH:
                        break;
                    case STATE_MORE:
                        nextPageToken = mNewsBean.getResult().getNextPageToken();
                        url += MainActivity.this.nextPageToken;
                        break;
                }
                //接口
                return url;
            }

           // 是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);
                state=STATE_MORE;
                return true;
            }
        };


        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<NewsBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onRefresh");

                state=STATE_PEFRESH;
            }

            @Override
            public void onSuccess(NewsBean newsBean ,Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onSuccess: " + newsBean);

                mNewsBean = newsBean;

                List<NewsBean.ResultBean.ItemsBean> itemDatas = newsBean.getItemDatas();
                for(NewsBean.ResultBean.ItemsBean itemData : itemDatas){
                    itemEntities.add(itemData);
                }
            }

        });

        //开始请求
        pullToLoadMoreRecyclerView.requestData();
    }


    List<String>imageLists=new ArrayList<>();
    List<String>textLists=new ArrayList<>();
    private void initialBanner() {
        Request request = ItheimaHttp.newGetRequest("action/apiv2/banner?catalog=1");//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<BannerBean>() {
            @Override
            public void onResponse(BannerBean bean, Headers headers) {

                List<BannerBean.ResultBean.ItemsBean> itemDatas=bean.getItemDatas();
                for(int i=0;i<itemDatas.size();i++){
                    textLists.add(itemDatas.get(i).getName());
                    imageLists.add(itemDatas.get(i).getImg());
                }
                mLoopViewPager.setImgData(imageLists);
                mLoopViewPager.setTitleData(textLists);
                mLoopViewPager.start();
            }
        });
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.ResultBean.ItemsBean> {

        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_description)
        TextView mTvDescription;
        @BindView(R.id.tv_time)
        TextView mTvTime;
        @BindView(R.id.tv_comment)
        TextView mTvComment;
        @BindView(R.id.ll_title)
        LinearLayout mLlTitle;


        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            mTvTitle.setText(mData.getTitle());
            mTvDescription.setText(mData.getBody());
            mTvTime.setText(mData.getPubDate());
            mTvComment.setText(mData.getCommentCount()+"");
        }

    }
}
