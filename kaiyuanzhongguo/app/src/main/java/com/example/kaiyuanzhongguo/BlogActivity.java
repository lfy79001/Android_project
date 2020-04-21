package com.example.kaiyuanzhongguo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;

public class BlogActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ItheimaRecyclerView mItheimaRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mItheimaRecyclerView = findViewById(R.id.recycler_view);

        RadioGroup mRadioGroup =findViewById(R.id.rg_blog_head_layout);
        RecyclerViewHeader header = (RecyclerViewHeader) findViewById(R.id.recycler_header);
        header.attachTo(mItheimaRecyclerView);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt_blog_head_recommend:
                        url = "/action/apiv2/blog?catalog=3& pageToken=";
                        break;
                    case R.id.bt_blog_head_hot:
                        url = "/action/apiv2/blog?catalog=2&nextPageToken=";
                        break;
                    case R.id.bt_blog_new_blog:
                        url = "/action/apiv2/blog?catalog=1&nextPageToken=";
                        break;
                }
                initData();
            }
        });

        initData();
    }

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    String url = "action/apiv2/blog?catalog=3& pageToken=";

    private void initData() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<BlogBean>(mSwipeRefreshLayout, mItheimaRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_news;
            }

            @Override
            public String getApi() {
                //接口
                return url;
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<BlogBean.ResultBean.ItemsBean> {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        @BindView(R.id.ll_title)
        LinearLayout llTitle;


        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            tvTitle.setText(mData.getTitle());
            tvDescription.setText(mData.getBody());
            tvTime.setText(mData.getAuthor()+"   "+mData.getPubDate());
            tvComment.setText(mData.getCommentCount()+"");
        }

    }
}
