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
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.ClosingSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.FashionSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.FinanceSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.IRSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.OpeningSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.RealEstatesSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.SocialSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.SpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.Fragments.Speakers.TechSpeakersFragment;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Fragments.TestBlankFragment;

public class SpeakersActivity extends AppCompatActivity implements TestBlankFragment.OnFragmentInteractionListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);
        setTitle("PWCS · Speakers");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        FragmentPagerItemAdapter myAdapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Opening Ceremony", OpeningSpeakersFragment.class)
                .add("Finance", FinanceSpeakersFragment.class)
                .add("International Relations", IRSpeakersFragment.class)
                .add("Technology", TechSpeakersFragment.class)
                .add("Social Responsibility", SocialSpeakersFragment.class)
                .add("Fashion", FashionSpeakersFragment.class)
                .add("Real Estate", RealEstatesSpeakersFragment.class)
                .add("Closing Ceremony", ClosingSpeakersFragment.class)
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
        navigationView.setCheckedItem(R.id.nav_speakers);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(SpeakersActivity.this,
                                android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                        // choices:
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case R.id.nav_more:
                                intent = new Intent(SpeakersActivity.this, MoreActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent,bundle);
                                break;
                            case R.id.nav_agenda:
                                intent = new Intent(SpeakersActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent,bundle);
                                break;
                            case R.id.nav_schedule:
                                intent = new Intent(SpeakersActivity.this, ScheduleActivity.class);
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
