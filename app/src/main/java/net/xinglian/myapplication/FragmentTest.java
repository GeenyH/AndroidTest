package net.xinglian.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/3/12.
 */

public class FragmentTest extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        int a = ((FragmentActivity)context).aaa;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test, null);

        (view.findViewById(R.id.setArgument)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle  bundle1 = new Bundle();
                bundle1.putString("yy","qqw");
                setArguments(bundle1);  // 存入数据
            }
        });

        return view;
    }
}
