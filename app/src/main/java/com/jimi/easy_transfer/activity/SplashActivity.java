package com.jimi.easy_transfer.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import com.jimi.easy_transfer.MainActivity;
import com.fatcat.easy_transfer.R;
import com.jimi.easy_transfer.base.BaseActivity;
import com.jimi.easy_transfer.utils.LogUtils;
import com.tbruyelle.rxpermissions3.RxPermissions;

public class SplashActivity extends BaseActivity {


    @Override
    protected void initView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void onStart() {
        super.onStart();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Toast.makeText(this, "请先打开文件权限", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivity(intent);
                return;
            } else {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        } else {
            final RxPermissions rxPermissions = new RxPermissions(this);
            rxPermissions.setLogging(true);
            rxPermissions
                    .request(Manifest.permission.MANAGE_EXTERNAL_STORAGE)
                    .subscribe(granted -> {
                        if (granted) { // Always true pre-M
                            startActivity(new Intent(this, MainActivity.class));
                            finish();
                        } else {
                            // Oups permission denied
                            LogUtils.e("未获取权限");
                            finish();
                        }
                    });
        }


    }
}