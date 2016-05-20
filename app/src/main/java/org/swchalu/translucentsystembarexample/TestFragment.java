package org.swchalu.translucentsystembarexample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swc12 on 2016/5/18 0018.
 */
public class TestFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private View rootView;

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<StatuesBean> statuesList;
    private RecyclerView.LayoutManager mLayoutManager;

    private SwipeRefreshLayout mSwipeLayout;
    private final int REFRESH_COMPLETE = 0;

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mSwipeLayout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment, container, false);
        }

        mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        statuesList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StatuesBean bean = new StatuesBean();
            bean.setUserName("item" + i);
            bean.setHasMulitPics(false);
            bean.setContent("item content " + i);
            bean.setTimestamp("20160518");
            statuesList.add(bean);
        }
        recyclerAdapter = new RecyclerAdapter(statuesList, this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mSwipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeColors(R.color.toolbarColor);

        return rootView;
    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }
}
