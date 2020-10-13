package com.example.applicationtravel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class report extends AppCompatActivity {

    /*ImageView im;
    TextView tv;*/

    ViewPager v;
    TabLayout t;
    //TabItem f1,f2,f3;
    PagerAdapter pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        v = findViewById(R.id.vp);
        t = findViewById(R.id.tb);


        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Today");
        arrayList.add("Tomorrow");
        arrayList.add("Later");

        prepareViewPager(v, arrayList);

        t.setupWithViewPager(v);
    }
       /*
        im = findViewById(R.id.imageView3);
        tv = findViewById(R.id.textView7);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(report.this,home.class));
                finish();
            }
        });



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(report.this,login.class));
                finish();
            }
        });
        */
/*

        pa = new PagerAdapter(getSupportFragmentManager(),t.getTabCount());
        v.setAdapter(pa);

        t.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                v.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        v.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(t));
    }
*/
    private void prepareViewPager(ViewPager v, ArrayList<String> arrayList) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        today todd = new today();
        tomorrow tomm = new tomorrow();
        later latt = new later();

        for (int i=0;i<arrayList.size();i++){
           if(i == 0){
               Bundle bundle = new Bundle();
               bundle.putString("title",arrayList.get(i));
               todd.setArguments(bundle);
               adapter.addFragment(todd,arrayList.get(i));
               todd = new today();
           }
           else if(i == 1){
               Bundle bundle = new Bundle();
               bundle.putString("title",arrayList.get(i));
               tomm.setArguments(bundle);
               adapter.addFragment(tomm,arrayList.get(i));
               tomm = new tomorrow();
           }
           else{
               Bundle bundle = new Bundle();
               bundle.putString("title",arrayList.get(i));
               latt.setArguments(bundle);
               adapter.addFragment(latt,arrayList.get(i));
               latt = new later();
           }
        }
        v.setAdapter(adapter);
    }


    private class MainAdapter extends  FragmentPagerAdapter{
        ArrayList<String> arrayList = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();
        public void addFragment(Fragment fragment,String title){

            arrayList.add(title);
            fragmentList.add(fragment);

        }
        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return arrayList.get(position);
        }
    }
}