package com.example.shortcutbadgersample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvLauncher)
    TextView tvLauncher;
    @BindView(R.id.etNumber)
    EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        SetListener();
    }

    private void initData() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        ResolveInfo resolveInfo = getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        String packageName = resolveInfo.activityInfo.packageName;
        tvLauncher.setText("launch:"+packageName);
    }

    private void SetListener() {
        findViewById(R.id.btnSetBadge).setOnClickListener(view->
        {
            int badgeNum=0;
            try {
                badgeNum = Integer.parseInt(etNumber.getText().toString());
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "输入非法", Toast.LENGTH_SHORT).show();
            }
            boolean isSuccess = ShortcutBadger.applyCount(MainActivity.this, badgeNum);
            Toast.makeText(getApplicationContext(), "设置个数=" + badgeNum + ", 设置是否成功=" + isSuccess, Toast.LENGTH_SHORT).show();

        });
        findViewById(R.id.btnRemoveBadge).setOnClickListener(view->{
            boolean isRemoveSuccess = ShortcutBadger.removeCount(this);
            Toast.makeText(getApplicationContext(), "移除是否成功=" + isRemoveSuccess, Toast.LENGTH_SHORT).show();
        });
    }
}
