package io.github.emanual.java.app.ui;

import io.github.emanual.java.app.R;
import io.github.emanual.java.app.adapter.MainFragmentPagerAdapter;
import io.github.emanual.java.app.fragment.LearnClub;
import io.github.emanual.java.app.fragment.NewFeeds;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

public class Main extends BaseActivity {
	ActionBar mActionBar;
	PagerSlidingTabStrip tabs;
	ViewPager viewPager;
	List<Fragment> fragments = new ArrayList<Fragment>();
	String[] titles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_main);
		initData();
		initLayout();
	}

	@Override
	protected void initData() {
		titles = getResources().getStringArray(R.array.title_main);
	}

	@Override
	protected void initLayout() {
		viewPager = (ViewPager) _getView(R.id.viewpager);
		tabs = (PagerSlidingTabStrip) _getView(R.id.tabs);

		mActionBar = getActionBar();

		viewPager = (ViewPager) _getView(R.id.viewpager);
		fragments.add(new NewFeeds());
		fragments.add(new LearnClub());
		viewPager.setAdapter(new MainFragmentPagerAdapter(
				getSupportFragmentManager(), fragments, titles));
		tabs.setViewPager(viewPager);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
//		case R.id.action_share:
//			toast("share");
//			return true;
		case R.id.action_about:
			startActivity(new Intent(getContext(), About.class));
			return true;
		case R.id.action_favourite:
			startActivity(new Intent(getContext(), FavouriteList.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}