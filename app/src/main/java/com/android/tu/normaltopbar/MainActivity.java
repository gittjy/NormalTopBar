package com.android.tu.normaltopbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.android.tu.loadingdialog.LoadingDialog;
import com.android.tu.topbarlibrary.NormalTopBar;

public class MainActivity extends AppCompatActivity {

    private NormalTopBar normalTopBar;
    private NormalTopBar normalTopBar1;
    private NormalTopBar normalTopBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadingDialog.Builder loadBuilder=new LoadingDialog.Builder(this)
                .setMessage("嘿嘿...")
                .setShowMessage(true)
                .setCancelable(true)
                .setCancelOutside(true);
        final LoadingDialog dialog=loadBuilder.create();
        dialog.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        },2000);

        normalTopBar= (NormalTopBar) findViewById(R.id.normal_top);
        normalTopBar1= (NormalTopBar) findViewById(R.id.normal_top_1);
        normalTopBar2= (NormalTopBar) findViewById(R.id.normal_top_2);

        normalTopBar.setTopClickListener(new NormalTopBar.normalTopClickListener() {
            @Override
            public void onLeftClick(View view) {
                Snackbar.make(view,"哎哟，不错哦!",Snackbar.LENGTH_SHORT)
                        .setAction("Do", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }

            @Override
            public void onRightClick(View view) {
                Snackbar.make(view,"666!",Snackbar.LENGTH_SHORT)
                        .setAction("Do", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }

            @Override
            public void onTitleClick(View view) {
                Toast.makeText(MainActivity.this,"标题也可以",Toast.LENGTH_SHORT).show();
            }
        });
        normalTopBar1.setTopClickListener(new NormalTopBar.normalTopClickListener() {
            @Override
            public void onLeftClick(View view) {
            }

            @Override
            public void onRightClick(View view) {
                normalTopBar1.setTitleText("更改后的标题");
            }

            @Override
            public void onTitleClick(View view) {

            }
        });
        normalTopBar2.setTopClickListener(new NormalTopBar.normalTopClickListener() {
            @Override
            public void onLeftClick(View view) {
                Toast.makeText(MainActivity.this,"这也可以",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick(View view) {
                Toast.makeText(MainActivity.this,"提交",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTitleClick(View view) {

            }
        });

    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
