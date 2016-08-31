package com.huangjie.drawable_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_width;
    private TextView tv_height;
    private TextView tv_density;
    private TextView tv_dpi;
    private TextView tv_ratio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        tv_width = (TextView) findViewById(R.id.tv_width);
        tv_height = (TextView) findViewById(R.id.tv_height);
        tv_density = (TextView) findViewById(R.id.tv_density);
        tv_dpi = (TextView) findViewById(R.id.tv_dpi);
        tv_ratio = (TextView) findViewById(R.id.tv_ratio);
    }

    /**
     * 获取数据
     */
    private void initData() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;//获取屏幕的宽度
        int heightPixels = metrics.heightPixels;//获取屏幕的宽度
        float density = metrics.density;//屏幕密度

        tv_width.setText("宽: " + widthPixels + "px      " + widthPixels / density + "dp");
        tv_height.setText("高: " + heightPixels + "px        " + heightPixels / density + "dp");
        tv_density.setText("density = px/dp = dpi/160 = " + density);
        tv_dpi.setText("densityDpi: "+metrics.densityDpi);
        int gongyue = getGongYue(widthPixels, heightPixels);
        int w = widthPixels / gongyue;
        int h = heightPixels / gongyue;
        if (w == 4 || h == 4) {
            w = w * 4;
            h = h * 4;
        }
        tv_ratio.setText("w:h = " + w + ":" + h);
    }

    /**
     * 求最大公约数
     *
     * @param m 一个数
     * @param n 另一个数
     * @return 他们的最大公约数
     */
    public static int getGongYue(int m, int n) {
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
}
