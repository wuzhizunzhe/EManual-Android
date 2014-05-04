package io.github.emanual.java.app.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

public class BaseFragment extends Fragment {

	public void toast(String content){
		Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
	}
}