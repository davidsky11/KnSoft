package com.kn.fragment;

import java.io.Serializable;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.kn.R;
import com.kn.adapter.Grade_1Adapter;
import com.kn.client.Grade_1Client;
import com.kn.entity.Grade_1;
import com.kn.utils.FragmentUtils;

public class Grade_1Fragment extends Fragment implements View.OnClickListener {
	
	private static final String TAG = "一级站点Fragment";
	
	private Button button_back = null;
	private View currentView;
	private List<Grade_1> grade_1List = null;
	private int layoutId = R.layout.grade_1;
	private ListView listView_grade_1 = null;
	private ProgressDialog dataProgress = null;
	
	private Handler dataHandler = new Handler() {
		public void handleMessage(Message message) {
			super.handleMessage(message);
			Grade_1Fragment.this.grade_1List = ((List) message.getData()
					.getSerializable("grade_1"));
			Grade_1Adapter grade_1Adapter = new Grade_1Adapter(
					Grade_1Fragment.this, Grade_1Fragment.this.grade_1List);
			Grade_1Fragment.this.listView_grade_1
					.setAdapter(grade_1Adapter);
			grade_1Adapter.notifyDataSetChanged();
			Grade_1Fragment.this.dataProgress.dismiss();
		}
	};

	public Grade_1Fragment() {
		Log.d(TAG, "空构造方法");
	}

	public Grade_1Fragment(int layoutId) {
		Log.d(TAG, "带参造方法");
		this.layoutId = layoutId;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated方法");
		new Thread(new LoadDataRunnable()).start();
	}

	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d(TAG, "onAttach方法");
		this.dataProgress = ProgressDialog.show(activity, "正在加载数据...",
				null, true, false);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		default:
			return;
		case R.id.button_back:
			FragmentUtils.popBackStack(getFragmentManager());
			return;
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate方法");
	}

	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle paramBundle) {
		Log.d(TAG, "onCreateView方法");
		this.currentView = inflater.inflate(this.layoutId,
				container, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}

	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy方法");
	}

	public void onDestroyView() {
		super.onDestroyView();
		Log.d(TAG, "onDestroyView方法");
	}

	public void onPause() {
		super.onPause();
		Log.d(TAG, "onPause方法");
	}

	public void onResume() {
		super.onResume();
		Log.d(TAG, "onResume方法");
	}

	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart方法");
	}

	public void onStop() {
		super.onStop();
		Log.d(TAG, "onStop方法");
	}

	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated方法");
		this.listView_grade_1 = ((ListView) view
				.findViewById(R.id.listView_grade_1));
		this.listView_grade_1
				.setOnItemClickListener(new OnItemClickListenerImpl());
		this.button_back = ((Button) view.findViewById(R.id.button_back));
		this.button_back.setOnClickListener(this);
	}

	private class LoadDataRunnable implements Runnable {
		private LoadDataRunnable() {
		}

		public void run() {
			Message message = Message.obtain();
			Bundle bundle = new Bundle();
			bundle.putSerializable("grade_1",
					(Serializable) Grade_1Client.grade_1List());
			message.setData(bundle);
			Grade_1Fragment.this.dataHandler.sendMessage(message);
		}
	}

	private class OnItemClickListenerImpl implements
			AdapterView.OnItemClickListener {
		private OnItemClickListenerImpl() {
		}

		public void onItemClick(AdapterView<?> parent,
				View view, int position, long id) {
			Log.d(TAG, "parent:" + parent.getClass().getName()
					+ ",view:" + view.getClass().getName() + ",position:"
					+ position + ",id:" + id);
			Grade_2Fragment localGrade_2Fragment = new Grade_2Fragment(
					((Grade_1) Grade_1Fragment.this.grade_1List.get(position))
							.getId());
			FragmentUtils.popFragment(
					Grade_1Fragment.this.getFragmentManager(), R.id.tab_changYongGongJu,
					localGrade_2Fragment, "二级站点");
		}
	}
}
