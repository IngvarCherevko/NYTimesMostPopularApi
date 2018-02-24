package com.ingvar.just01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ingvar.just01.adapter.TabsFragmentAdapter;
import com.ingvar.just01.fragment.ExampleFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    TabsFragmentAdapter tabsFragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefaultTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationView();

        initToolbar();

        initTabs();

    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

    }


    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabsFragmentAdapter = new TabsFragmentAdapter(getSupportFragmentManager());
        ExampleFragment mailedFragment = new ExampleFragment();
        mailedFragment.addTitle("most emailed");
        tabsFragmentAdapter.addFragment(mailedFragment, mailedFragment.getNameTab());
        ExampleFragment sharedFragment = new ExampleFragment();
        sharedFragment.addTitle("most shared");
        tabsFragmentAdapter.addFragment(sharedFragment, sharedFragment.getNameTab());
        ExampleFragment viewedFragment = new ExampleFragment();
        viewedFragment.addTitle("most viewed");
        tabsFragmentAdapter.addFragment(viewedFragment, viewedFragment.getNameTab());
        viewPager.setAdapter(tabsFragmentAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.most_emailed:
                        showNotification(Constant.TAB_ONE);
                        break;
                    case R.id.most_shared:
                        showNotification(Constant.TAB_TWO);
                        break;
                    case R.id.most_viewed:
                        showNotification(Constant.TAB_THREE);
                        break;
                }
                return true;
            }
        });
    }

    private void showNotification(int constant) {
        viewPager.setCurrentItem(constant);
    }

}
