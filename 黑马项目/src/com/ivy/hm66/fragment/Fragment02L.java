package com.ivy.hm66.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ivy.hm66.MainActivity;
import com.ivy.hm66.R;
import com.ivy.hm66.activity.FragmentDemo02Activity;
import com.ivy.hm66.log.L;

public class Fragment02L extends Fragment implements OnClickListener {
	private TextView tv;
	private EditText editText1;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_fragment02, null);
		tv = (TextView) view.findViewById(R.id.textView1);
		editText1 = (EditText) view.findViewById(R.id.editText1);
		view.findViewById(R.id.button1).setOnClickListener(this);
		L.v("--Fragment02L--onCreateView: "+(tv==null));
		return view;
	}
	
	
	public void setText(String text){
		if(tv==null){
			L.v("---null---"+text);
		}else{
			L.v("--no null--"+text);
			tv.setText(text);
			
		}
	}


	@Override
	public void onClick(View v) {
		String text = editText1.getText().toString();
		FragmentDemo02Activity activity = (FragmentDemo02Activity) getActivity();
		activity.setText(text);
	}
}
