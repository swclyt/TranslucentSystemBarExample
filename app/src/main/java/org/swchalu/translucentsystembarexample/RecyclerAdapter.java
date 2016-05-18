package org.swchalu.translucentsystembarexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swc12 on 2016/5/18 0018.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getName();
    private Context context;
    private LayoutInflater inflater;
    private List<StatuesBean> items = new ArrayList<>();

    public RecyclerAdapter(List<StatuesBean> items, Context context) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder : entering...");
        if (viewType == Constants.TYPE_SINGLEPIC) {
            View view = inflater.inflate(R.layout.item_singlepic, parent, false);
            SinglePicHolder singlePicHolder = new SinglePicHolder(view);
            Log.e(TAG, "viewType :" + Constants.TYPE_SINGLEPIC);
            return singlePicHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder : entering...");
        if (holder instanceof SinglePicHolder) {
            SinglePicHolder singlePicHolder = (SinglePicHolder) holder;
            Log.e(TAG, "holder instanceof SinglePicHolder...");
            if (items != null) {
                singlePicHolder.tv_username.setText(items.get(position).getUserName());
                singlePicHolder.imageView.setImageResource(R.drawable.env);
                singlePicHolder.tv_content.setText(items.get(position).getContent());
                singlePicHolder.ci_header.setImageResource(R.drawable.header);
                Log.e(TAG, "SinglePicHolder setting...");
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    public class SinglePicHolder extends RecyclerView.ViewHolder {
        private TextView tv_username;
        private ImageView imageView;
        private TextView tv_content;
        private ImageView ci_header;

        public SinglePicHolder(View itemView) {
            super(itemView);
            this.tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            ci_header = (ImageView) itemView.findViewById(R.id.ci_header);
        }
    }
}
