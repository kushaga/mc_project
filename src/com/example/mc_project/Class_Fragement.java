package com.example.mc_project;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class Class_Fragment extends Fragment {
	public static final String ARG_OS = "OS";
	private String string;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_layout, null);
		TextView textView = (TextView) view.findViewById(R.id.textView_fragment);
		textView.setText(string);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void setArguments(Bundle args) {
		string = args.getString(ARG_OS);
	}
}