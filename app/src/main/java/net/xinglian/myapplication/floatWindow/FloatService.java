package net.xinglian.myapplication.floatWindow;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * description：通过Service来开启FloatView
 * 作者：ldm
 * 时间：20162016/8/17 14:03
 * 邮箱：1786911211@qq.com
 */
public class FloatService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        CustomViewManager.getInstance(this).showFloatViewOnWindow();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}