package com.news.today.todayinformation.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;

import com.news.today.todayinformation.R;
import com.news.today.todayinformation.base.BaseActivity;
import com.news.today.todayinformation.base.ViewInject;

import butterknife.BindView;

/**
 * Created by anson on 2018/12/12.
 */
@ViewInject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShangHaiDetailActivity extends BaseActivity {
    private static String IMG_TRANSITION = "IMG_TRANSITION";
    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition();
            ViewCompat.setTransitionName(ivShanghaiDetail, IMG_TRANSITION);
            startPostponedEnterTransition();
        } else {
            // 处理你自己的逻辑
        }
    }

    public static void start(Activity context, View view) {
        Intent intent = new Intent(context, ShangHaiDetailActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //属性动画的标志
            Pair pair = new Pair<>(view, IMG_TRANSITION);
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(context, pair);
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
            context.overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }
}
