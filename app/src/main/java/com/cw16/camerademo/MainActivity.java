package com.cw16.camerademo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnStartCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();

    }


    public void initViews() {
        btnStartCamera = (Button) findViewById(R.id.btnstartcamera);
        btnStartCamera.setOnClickListener(this);
    }

    /**
     * 检查手机是否存在摄像机
     *
     * @param context
     * @return
     */
    public boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            return true;
        return false;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnstartcamera:
                boolean isTrue = checkCameraHardware(this);
                if (isTrue)
                    Toast.makeText(this, "存在", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "不存在", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
