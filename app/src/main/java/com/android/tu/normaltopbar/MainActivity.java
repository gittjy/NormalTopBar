package com.android.tu.normaltopbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.tu.topbarlibrary.NormalTopBar;

public class MainActivity extends AppCompatActivity {

    private NormalTopBar normalTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normalTopBar= (NormalTopBar) findViewById(R.id.normal_top);
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
        });
    }
}
