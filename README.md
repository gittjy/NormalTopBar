#效果图
<center>![图图图](http://img.blog.csdn.net/20170323202335712?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvVE1BQ0FEQUk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)</center>


#使用方法
##引入控件
项目gradle文件中
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
模块gradle文件中
```
compile 'com.github.gittjy:NormalTopBar:v1.0.1'
```

##使用控件
在需要使用的布局layout中
```
<com.android.tu.topbarlibrary.NormalTopBar
        android:id="@+id/normal_top"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="@color/colorPrimary"
        app:leftText="return"
        app:leftTextColor="@android:color/white"
        app:leftImageSrc="@drawable/ic_chevron_left"
        app:top_titleText="mytitle"
        app:top_titleTextColor="@android:color/white"
        app:rightImageSrc="@drawable/ic_check_white">
    </com.android.tu.topbarlibrary.NormalTopBar>
```
定义左右点击事件
```
normalTopBar.setTopClickListener(new NormalTopBar.normalTopClickListener() {
            @Override
            public void onLeftClick(View view) {
            
            }

            @Override
            public void onRightClick(View view) {
                
            }
        });
```

如果您觉得值得鼓励，欢迎star和建议
