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
import com.kn.adapter.Grade_2Adapter;
import com.kn.client.Grade_2Client;
import com.kn.entity.Grade_2;
import com.kn.utils.FragmentUtils;

public class Grade_2Fragment extends Fragment implements View.OnClickListener {
	
	private static final String TAG = "二级站点Fragment";
	private int layoutId = R.layout.grade_2;
	private int grade_1_id;
	
	private Button button_back;
	private Button button_shangYiCeng;
	private View currentView;
	private List<Grade_2> grade_2List = null;
	private ListView listView_grade_2 = null;
	private ProgressDialog dataProgress = null;
	
	private Handler dataHandler = new Handler() {
		public void handleMessage(Message message) {
			super.handleMessage(message);
			Grade_2Fragment.this.grade_2List = ((List) message.getData()
					.getSerializable("grade_2"));
			if (Grade_2Fragment.this.grade_2List != null) {
				Grade_2Adapter grade_2Adapter = new Grade_2Adapter(
						Grade_2Fragment.this, Grade_2Fragment.this.grade_2List);
				Grade_2Fragment.this.listView_grade_2
						.setAdapter(grade_2Adapter);
				grade_2Adapter.notifyDataSetChanged();
			}
			Grade_2Fragment.this.dataProgress.dismiss();
		}
	};

	public Grade_2Fragment() {
		Log.d(TAG, "空构造方法");
	}

	public Grade_2Fragment(int layoutId) {
		Log.d(TAG, "带参造方法");
		this.grade_1_id = layoutId;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("二级站点Fragment", "onActivityCreated方法");
		new Thread(new LoadDataRunnable(this.grade_1_id)).start();
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
		case R.id.button_shangYiCeng:
			Log.d(TAG, "button_shangYiCeng");
			FragmentUtils.popBackStack(getFragmentManager());
			return;
		case R.id.button_back:
			FragmentUtils.popBackStack(getFragmentManager(), "一级站点");
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate方法");
	}

	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView方法");
		this.currentView = inflater.inflate(this.layoutId,
				container, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}

	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated方法");
		this.button_shangYiCeng = ((Button) view
				.findViewById(R.id.button_shangYiCeng));
		this.button_shangYiCeng.setOnClickListener(this);
		this.button_back = ((Button) view.findViewById(R.id.button_back));
		this.button_back.setOnClickListener(this);
		this.listView_grade_2 = ((ListView) view
				.findViewById(R.id.listView_grade_2));
		this.listView_grade_2
				.setOnItemClickListener(new OnItemClickListenerImpl());
	}

	private class LoadDataRunnable implements Runnable {
		private int key;

		public LoadDataRunnable(int key) {
			this.key = key;
		}

		public void run() {
			Message message = Message.obtain();
			Bundle bundle = new Bundle();
			bundle.putSerializable("grade_2",
					(Serializable) Grade_2Client.grade_2List(this.key));
			message.setData(bundle);
			Grade_2Fragment.this.dataHandler.sendMessage(message);
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
			Grade_3Fragment localGrade_3Fragment = new Grade_3Fragment(
					((Grade_2) Grade_2Fragment.this.grade_2List.get(position))
							.getId());
			FragmentUtils.popFragment(
					Grade_2Fragment.this.getFragmentManager(), R.id.tab_changYongGongJu,
					localGrade_3Fragment, "三级站点");
		}
	}
}
