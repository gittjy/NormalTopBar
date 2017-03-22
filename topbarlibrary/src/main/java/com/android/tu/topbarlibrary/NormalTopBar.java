package com.android.tu.topbarlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by TracyTu on 2017/3/20.
 */
public class NormalTopBar extends RelativeLayout{

    private String leftText,titleText,rightText;

    private int leftImageId,rightImageId;

    private int leftTextColor,titleTextColor,rightTextColor;

    private float leftTextSize,titleTextSize,rightTextSize;

    private TextView leftTextView, rightTextView;

    private ImageView leftImage,rightImage;

    private TextView titleTextView;

    private LayoutParams leftImageParams, leftTextParams,titleParams, rightTextParams,rightImageParams;

    private boolean isLeftVisible,isRightVisible;

    private normalTopClickListener mClickListener;


    public NormalTopBar(Context context) {
        this(context,null);
    }

    public NormalTopBar(Context context, AttributeSet attrs) {
        this(context,attrs,0);

    }

    public NormalTopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getTypeArray(context,attrs);
        addAllView(context);
        addOnClick();
    }

    private void addOnClick() {

        leftTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onLeftClick(view);
            }
        });

        leftImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onLeftClick(view);
            }
        });

        rightTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onRightClick(view);
            }
        });

        rightImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onRightClick(view);
            }
        });

    }

    private void addAllView(Context context) {
        leftTextView =new TextView(context);
        rightTextView =new TextView(context);
        titleTextView=new TextView(context);
        leftImage=new ImageView(context);
        rightImage=new ImageView(context);

        leftImage.setId(R.id.leftimageid);
        leftImage.setImageResource(leftImageId);
        //leftImage.setAdjustViewBounds(true);

        leftTextView.setText(leftText);
        leftTextView.setTextSize(leftTextSize);
        leftTextView.setTextColor(leftTextColor);

        titleTextView.setText(titleText);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);
        titleTextView.setGravity(Gravity.CENTER);//一定要设置textview内容的位置

        rightTextView.setText(rightText);
        rightTextView.setTextSize(rightTextSize);
        rightTextView.setTextColor(rightTextColor);

        rightImage.setId(R.id.rightimageid);
        rightImage.setImageResource(rightImageId);




        //为组建设置相应的布局

        if(leftImageId!=0&&leftText!=null){
            leftImageParams=new LayoutParams(dpToPx(context,35), dpToPx(context,35));
            leftImageParams.addRule(ALIGN_PARENT_LEFT,TRUE);
            leftImageParams.addRule(CENTER_VERTICAL,TRUE);
            addView(leftImage,leftImageParams);

            leftTextParams =new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            leftTextParams.addRule(RelativeLayout.RIGHT_OF,R.id.leftimageid);
            leftTextParams.addRule(CENTER_VERTICAL,TRUE);
            leftTextView.setGravity(Gravity.LEFT);
            addView(leftTextView, leftTextParams);
        }else if(leftImageId!=0&&leftText==null){
            leftImageParams=new LayoutParams(dpToPx(context,35), dpToPx(context,35));
            leftImageParams.addRule(ALIGN_PARENT_LEFT,TRUE);
            leftImageParams.addRule(CENTER_VERTICAL,TRUE);
            addView(leftImage,leftImageParams);
        }else{
            leftTextParams =new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            leftTextParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
            leftTextParams.addRule(CENTER_VERTICAL,TRUE);
            addView(leftTextView, leftTextParams);
        }


        titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(CENTER_IN_PARENT,TRUE);
        titleParams.addRule(TEXT_ALIGNMENT_CENTER);
        addView(titleTextView,titleParams);

        if(rightImageId!=0&&rightText!=null){
            rightTextParams =new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rightTextParams.addRule(RelativeLayout.LEFT_OF,R.id.rightimageid);
            rightTextParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
            rightTextView.setGravity(Gravity.RIGHT);
            addView(rightTextView, rightTextParams);
            rightImageParams=new LayoutParams(dpToPx(context,35), dpToPx(context,35));
            rightImageParams.addRule(CENTER_VERTICAL,TRUE);
            rightImageParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
            addView(rightImage,rightImageParams);
        }else if(rightImageId!=0&&rightText==null){
            rightImageParams=new LayoutParams(dpToPx(context,35), dpToPx(context,35));
            rightImageParams.addRule(CENTER_VERTICAL,TRUE);
            rightImageParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
            addView(rightImage,rightImageParams);
        }else{
            rightTextParams =new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rightTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
            rightTextParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
            addView(rightTextView, rightTextParams);
        }

    }

    private void getTypeArray(Context context, AttributeSet attrs) {
        //将attrs.xml中定义的属性存储到TypeArray中
        TypedArray typeArray=context.obtainStyledAttributes(attrs,R.styleable.NormalTopBar);

        leftText=typeArray.getString(R.styleable.NormalTopBar_leftText);
        leftTextColor=typeArray.getColor(R.styleable.NormalTopBar_leftTextColor, Color.BLACK);
        leftTextSize=typeArray.getDimension(R.styleable.NormalTopBar_leftTextSize,12);
        leftImageId=typeArray.getResourceId(R.styleable.NormalTopBar_leftImageSrc,0);
        titleText=typeArray.getString(R.styleable.NormalTopBar_top_titleText);
        titleTextColor=typeArray.getColor(R.styleable.NormalTopBar_top_titleTextColor,Color.BLACK);
        titleTextSize=typeArray.getDimension(R.styleable.NormalTopBar_top_titleTextSize,20);
        rightText=typeArray.getString(R.styleable.NormalTopBar_rightText);
        rightTextColor=typeArray.getColor(R.styleable.NormalTopBar_rightTextColor,Color.BLACK);
        rightTextSize=typeArray.getDimension(R.styleable.NormalTopBar_rightTextSize,12);
        rightImageId=typeArray.getResourceId(R.styleable.NormalTopBar_rightImageSrc,0);

        typeArray.recycle();//获取完所有属性后需要调用recycle来避免重新创建发生的错误

    }

    /**
     * 提供给调用者的点击事件接口
     */
    public interface normalTopClickListener{

        void onLeftClick(View view);

        void onRightClick(View view);

    }


    public void setTopClickListener(normalTopClickListener mListener){

        this.mClickListener =mListener;

    }


    /**
     * dp转为px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dpToPx(Context context,float dpValue){
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

}
