package com.news.today.todayinformation.main.shanghai.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.news.today.todayinformation.R;
import com.news.today.todayinformation.main.shanghai.dto.Md5Utils;
import com.news.today.todayinformation.main.shanghai.dto.ShanghaiBean;

import java.util.ArrayList;

/**
 * Created by anson on 2018/12/3.
 */
public class ShanghaiAdapter extends RecyclerView.Adapter{

    private final ArrayList<ShanghaiBean> mData;
    private final Context mContext;

    public ShanghaiAdapter(Context context,ArrayList<ShanghaiBean> data) {
        mContext = context;
        mData = data;
    }

    //  创建View 然后进行缓存
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ShanghaiBean.IShanghaiItemType.VERTICAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, parent,false);
            ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflate);
            return viewHolder;
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_re, null);
            ShanghaiViewHolderRv viewHolder = new ShanghaiViewHolderRv(inflate);
            return viewHolder;
        }
    }

    // 绑定数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ShanghaiBean shanghaiBean = mData.get(position);
        if (holder instanceof ShanghaiViewHolder) {
            ((ShanghaiViewHolder) holder).mTv.setText(shanghaiBean.getmDec());
            ((ShanghaiViewHolder) holder).mIv.setVisibility(shanghaiBean.isHaveImage() ? View.VISIBLE : View.GONE);
            ((ShanghaiViewHolder) holder).mIv.setTag(position);
            ((ShanghaiViewHolder) holder).itemView.setTag(position);
        } else if (holder instanceof ShanghaiViewHolderRv){
            ((ShanghaiViewHolderRv) holder).mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            ((ShanghaiViewHolderRv) holder).mRecyclerView.setAdapter(new ShanghaiAdapter(mContext,shanghaiBean.getmData()));
        }
    }

    // 条目的数量
    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmType();
    }

    // 缓存View  内存友好设计
    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {

        public TextView mTv;
        public ImageView mIv;

        public ShanghaiViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_iv);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    ShanghaiBean shanghaiBean = mData.get(position);
                    Toast.makeText(mContext,"被点击了 = " + position + " " + Md5Utils.md5("1"),Toast.LENGTH_LONG).show();
                    Log.e("ShanghaiViewHolder", Md5Utils.md5("1"));
                }
            });
            mIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    ShanghaiBean shanghaiBean = mData.get(position);
                    Toast.makeText(mContext,"被点击了 = " + position + " " + Md5Utils.md5("jishufanganlofterhhah"),Toast.LENGTH_LONG).show();
                    Log.e("ShanghaiViewHolderhaha", Md5Utils.md5("jishufanganlofterhhah"));
                }
            });
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder {

        public RecyclerView mRecyclerView;

        public ShanghaiViewHolderRv(View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_recyclerview);
        }
    }

}
