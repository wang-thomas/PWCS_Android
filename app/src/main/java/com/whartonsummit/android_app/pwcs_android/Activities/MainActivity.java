package com.whartonsummit.android_app.pwcs_android.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.whartonsummit.android_app.pwcs_android.Fragments.EventsFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.PanelsFragment;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Fragments.TestBlankFragment;

public class MainActivity extends AppCompatActivity implements TestBlankFragment.OnFragmentInteractionListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PWCS · Agenda");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        FragmentPagerItemAdapter myAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Panels", PanelsFragment.class)
                .add("Events", EventsFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(myAdapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_agenda);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // !important! smooth animation:
                        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(MainActivity.this,
                                android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                        Intent intent;
                        // navigation choices:
                        switch (menuItem.getItemId()) {
                            case R.id.nav_speakers:
                                intent = new Intent(MainActivity.this, SpeakersActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent, bundle);
                                break;
                            case R.id.nav_more:
                                intent = new Intent(MainActivity.this, MoreActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent, bundle);
                                break;
                            case R.id.nav_schedule:
                                intent = new Intent(MainActivity.this, ScheduleActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent,bundle);
                                break;
                            default:
                                break;
                        }

                        finish();

                        return true;
                    }
                });
    }

    @Override
    public void onTestFragmentInteraction(Uri string) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
