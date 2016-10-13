package com.example.nagaiakiranari.recycler;

import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.util.Log;

public class RecyclerFragment extends Fragment implements OnRecyclerListener {

    private Context mContext = null;
    private View mView;
    private RecyclerFragmentListener mFragmentListener = null;

    // RecyclerViewとAdapter
    private RecyclerView mRecyclerView = null;
    private RecyclerAdapter mAdapter = null;

    public interface RecyclerFragmentListener {
        void onRecyclerEvent();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof RecyclerFragmentListener)) {
            throw new UnsupportedOperationException(
                    "Listener is not Implementation.");
        } else {
            mFragmentListener = (RecyclerFragmentListener) context;
        }
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("init", "initOnCreateView");
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(mAdapter);
        mView = inflater.inflate(R.layout.main_activity, container, false);

        // レイアウトマネージャを設定(ここで縦方向の標準リストであることを指定)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        // RecyclerViewの参照を取得
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_fragment);


        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("init", "initOnActivityCreated");
        super.onActivityCreated(savedInstanceState);

        // 適当にデータ作成
        ArrayList<String> array = new ArrayList<>();
        array.add("A");
        array.add("B");
        array.add("C");

        // この辺りはListViewと同じ
        // 今回は特に何もしないけど、一応クリック判定を取れる様にする
        mAdapter = new RecyclerAdapter(mContext, array, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerClicked(View v, int position) {
        // セルクリック処理
    }
}
