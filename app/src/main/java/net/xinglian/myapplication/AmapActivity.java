package net.xinglian.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.navi.AMapNaviView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2018/2/10.
 */

public class AmapActivity extends BaseAmapActivity {

    private String provider;//位置提供器
    private LocationManager locationManager;//位置服务
    private Location location;
    private Button btn_show;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.amap_activity);
        mAMapNaviView = (AMapNaviView) findViewById(R.id.amapView);
        mAMapNaviView.onCreate(savedInstanceState);
        mAMapNaviView.setAMapNaviViewListener(this);
    }
}
