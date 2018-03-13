package net.xinglian.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import net.xinglian.myapplication.R;

/**
 * Created by Administrator on 2018/3/12.
 */

public class FragmentActivity extends Activity {

    public int aaa = 9;
    FragmentTest fragmentTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_container);

        fragmentTest = new FragmentTest();

        getFragmentManager().beginTransaction().replace(R.id.layout_empty, fragmentTest).commit();

        (findViewById(R.id.getArguement)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = fragmentTest.getArguments();
                String aa = bundle.getString("yy");
            }
        });

    }
}
