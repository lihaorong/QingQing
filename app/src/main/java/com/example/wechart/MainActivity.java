package com.example.wechart;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private LinearLayout LinOut_Msg;
    private LinearLayout LinOut_Contact;
    private LinearLayout LinOut_Friend;

    private ImageView ImageV_Msg;
    private ImageView ImageV_Contact;
    private ImageView ImageV_Friend;

    private TextView TextV_Msg;
    private TextView TextV_Contact;
    private TextView TextV_Friends;
    private ViewPager viewPager;
    private  ContentAdapter contentAdapter;

    private List<View> views;

    private List<Fruit> fruitList = new ArrayList<>();
    private ListView listView;
    private FruitAdapter fruitAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //隐藏标题栏
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        //状态栏透明
        if(Build.VERSION.SDK_INT>=21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initView();
        initFruits();
        initEvent();


    }

    private void initEvent(){
        LinOut_Msg.setOnClickListener(this);
        LinOut_Contact.setOnClickListener(this);
        LinOut_Friend.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    private void initView(){
        this.LinOut_Msg=(LinearLayout)findViewById(R.id.LinOut_msg);
        this.LinOut_Contact=(LinearLayout)findViewById(R.id.LinOut_contact);
        this.LinOut_Friend=(LinearLayout)findViewById(R.id.LinOut_friend);

        this.ImageV_Msg = (ImageView)findViewById(R.id.imgView_msg);
        this.ImageV_Contact=(ImageView)findViewById(R.id.imgView_contact);
        this.ImageV_Friend=(ImageView)findViewById(R.id.imgView_friend);

        this.TextV_Msg = (TextView)findViewById(R.id.bottom_Text_msg);
        this.TextV_Contact=(TextView)findViewById(R.id.bottom_Text_contact);
        this.TextV_Friends=(TextView)findViewById(R.id.bottom_Text_friend);

        this.viewPager = (ViewPager)findViewById(R.id.viewPager_main);
        View page_01 = View.inflate(MainActivity.this,R.layout.table01,null);
        View page_02 = View.inflate(MainActivity.this,R.layout.table02,null);
        View page_03 = View.inflate(MainActivity.this,R.layout.table03,null);

        listView=(ListView)page_02.findViewById(R.id.list_view);
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        listView.setAdapter(fruitAdapter);

        views = new ArrayList<View>();
        views.add(page_01);
        views.add(page_02);
        views.add(page_03);

        this.contentAdapter = new ContentAdapter(views);
        viewPager.setAdapter(contentAdapter);
    }

    private void restartButton(){
        ImageV_Msg .setImageResource(R.drawable.msg_btn);
        ImageV_Contact.setImageResource(R.drawable.contact_btn);
        ImageV_Friend.setImageResource(R.drawable.friend_btn);

        TextV_Msg.setTextColor(0xffcccccc);
        TextV_Contact.setTextColor(0xffcccccc);
        TextV_Friends.setTextColor(0xffcccccc);
    }
    @Override
    public void onClick(View v) {
        restartButton();

        switch (v.getId()){
            case R.id.LinOut_msg:
                ImageV_Msg.setImageResource(R.drawable.msg_btn_press);
                TextV_Msg.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(0);
                break;
            case R.id.LinOut_contact:
                ImageV_Contact.setImageResource(R.drawable.contact_btn_press);
                TextV_Contact.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(1);
                break;
            case R.id.LinOut_friend:
                ImageV_Friend.setImageResource(R.drawable.friend_btn_press);
                TextV_Friends.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(2);
                break;
            default:
                break;

        }
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        restartButton();
        switch (arg0){
            case 0:
                ImageV_Msg.setImageResource(R.drawable.msg_btn_press);
                TextV_Msg.setTextColor(0xff1B940A);
                break;
            case 1:
                ImageV_Contact.setImageResource(R.drawable.contact_btn_press);
                TextV_Contact.setTextColor(0xff1B940A);
                break;
            case 2:
                ImageV_Friend.setImageResource(R.drawable.friend_btn_press);
                TextV_Friends.setTextColor(0xff1B940A);
                break;
            default:
                break;
        }


    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }
    private void initFruits(){
        for (int i = 0;i<2;i++){
            Fruit apple = new Fruit("APPLE",R.mipmap.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.mipmap.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("orange",R.mipmap.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.mipmap.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.mipmap.pear_pic);
            fruitList.add(pear);
            Fruit grap = new Fruit("Grap",R.mipmap.grape_pic);
            fruitList.add(grap);
            Fruit pineapple = new Fruit("Prinapple",R.mipmap.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.mipmap.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.mipmap.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.mipmap.mango_pic);
            fruitList.add(mango);
        }
    }



}
