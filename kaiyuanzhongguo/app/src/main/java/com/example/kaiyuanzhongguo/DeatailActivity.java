package com.example.kaiyuanzhongguo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;
import retrofit2.Call;

public class DeatailActivity extends AppCompatActivity {
    @BindView(R.id.tv__new_detail_name)
    TextView mTvNewDetailName;
    @BindView(R.id.tv__new_detail_pub_date)
    TextView mTvNewDetailPubDate;
    @BindView(R.id.ll_detail_about_softs)
    LinearLayout mLiDetailAboutSofts;
    @BindView(R.id.ll_detail_related_layout)
    LinearLayout mLiDetailRelated;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        setContentView(R.layout.new_detail_fragment);
        ButterKnife.bind(this);
        Request request = ItheimaHttp.newGetRequest("action/apiv2/news?id="+id);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<Deatail>() {
            @Override
            public void onResponse(Deatail bean, Headers headers) {
                mTvNewDetailName.setText(bean.getResult().getTitle());
                mTvNewDetailPubDate.setText(bean.getResult().getPubDate());


                List<Deatail.ResultBean.AboutsBean>abouts=bean.getResult().getAbouts();
                if(abouts.size()>0||abouts!=null){
                    for (int i = 0; i < abouts.size(); i++) {
                        View view=View.inflate(DeatailActivity.this,R.layout.item_about_safe,null);
                        TextView mTextView=view.findViewById(R.id.tv_item_about_safe_name);
                        mTextView.setText(abouts.get(i).getTitle());
                        mLiDetailAboutSofts.addView(view);
                    }
                }
            }
        });

    }
}
