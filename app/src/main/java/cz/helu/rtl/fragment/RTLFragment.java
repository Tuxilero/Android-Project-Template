package cz.helu.rtl.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cz.helu.rtl.R;
import cz.helu.rtl.utility.RTLHelper;


public class RTLFragment extends Fragment
{
	public static final String TAG = RTLFragment.class.getSimpleName();

	private View mRootView;


	public static RTLFragment newInstance()
	{
		return new RTLFragment();
	}


	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setHasOptionsMenu(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		mRootView = inflater.inflate(R.layout.fragment_rtl, container, false);
		return mRootView;
	}


	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		renderView();
	}


	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		// action bar menu
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu_main, menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// action bar menu behaviour
		switch(item.getItemId())
		{
			case android.R.id.home:
				getActivity().finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


	private void renderView()
	{
		TextView rtlOrientationTextView = (TextView) mRootView.findViewById(R.id.fragment_rtl_textview_orientation);

		if(RTLHelper.isDefaultLocaleRTL())
			rtlOrientationTextView.setText("RTL");
		else
			rtlOrientationTextView.setText("LTR");
	}
}
