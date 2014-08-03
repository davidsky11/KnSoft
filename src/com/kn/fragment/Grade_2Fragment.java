package com.kn.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.kn.R;
import com.kn.adapter.Grade_2Adapter;
import com.kn.client.Grade_2Client;
import com.kn.entity.Grade_2;
import com.kn.utils.FragmentUtils;
import java.io.Serializable;
import java.util.List;

public class Grade_2Fragment extends Fragment implements View.OnClickListener {
	private static final String TAG = "二级站点Fragment";
	private Button button_back;
	private Button button_shangYiCeng;
	private View currentView;
	private int grade_1_id;
	private List<Grade_2> grade_2List = null;
	private int layoutId = R.layout.grade_2;
	private ListView listView_grade_2 = null;
	private Handler loadDataHandler = new Handler() {
		public void handleMessage(Message paramMessage) {
			super.handleMessage(paramMessage);
			Grade_2Fragment.this.grade_2List = ((List) paramMessage.getData()
					.getSerializable("grade_2"));
			if (Grade_2Fragment.this.grade_2List != null) {
				Grade_2Adapter localGrade_2Adapter = new Grade_2Adapter(
						Grade_2Fragment.this, Grade_2Fragment.this.grade_2List);
				Grade_2Fragment.this.listView_grade_2
						.setAdapter(localGrade_2Adapter);
				localGrade_2Adapter.notifyDataSetChanged();
			}
			Grade_2Fragment.this.loadDataProgress.dismiss();
		}
	};
	private ProgressDialog loadDataProgress = null;

	public Grade_2Fragment() {
		Log.d(TAG, "空构造方法");
	}

	public Grade_2Fragment(int layoutId) {
		Log.d(TAG, "带参造方法");
		this.grade_1_id = layoutId;
	}

	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
		Log.d("二级站点Fragment", "onActivityCreated方法");
		new Thread(new LoadDataRunnable(this.grade_1_id)).start();
	}

	public void onAttach(Activity paramActivity) {
		super.onAttach(paramActivity);
		Log.d(TAG, "onAttach方法");
		this.loadDataProgress = ProgressDialog.show(paramActivity, "正在加载数据...",
				null, true, false);
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		default:
			return;
		case 2131099693:
			Log.d(TAG, "button_shangYiCeng");
			FragmentUtils.popBackStack(getFragmentManager());
			return;
		case 2131099681:
			FragmentUtils.popBackStack(getFragmentManager(), "一级站点");
		}
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		Log.d(TAG, "onCreate方法");
	}

	public View onCreateView(LayoutInflater layoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		Log.d(TAG, "onCreateView方法");
		this.currentView = layoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}

	public void onViewCreated(View paramView, Bundle paramBundle) {
		super.onViewCreated(paramView, paramBundle);
		Log.d(TAG, "onViewCreated方法");
		this.button_shangYiCeng = ((Button) paramView
				.findViewById(R.id.button_shangYiCeng));
		this.button_shangYiCeng.setOnClickListener(this);
		this.button_back = ((Button) paramView.findViewById(R.id.button_back));
		this.button_back.setOnClickListener(this);
		this.listView_grade_2 = ((ListView) paramView
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
			Message localMessage = Message.obtain();
			Bundle localBundle = new Bundle();
			localBundle.putSerializable("grade_2",
					(Serializable) Grade_2Client.grade_2List(this.key));
			localMessage.setData(localBundle);
			Grade_2Fragment.this.loadDataHandler.sendMessage(localMessage);
		}
	}

	private class OnItemClickListenerImpl implements
			AdapterView.OnItemClickListener {
		private OnItemClickListenerImpl() {
		}

		public void onItemClick(AdapterView<?> paramAdapterView,
				View paramView, int paramInt, long paramLong) {
			Log.d(TAG, "parent:" + paramAdapterView.getClass().getName()
					+ ",view:" + paramView.getClass().getName() + ",position:"
					+ paramInt + ",id:" + paramLong);
			Grade_3Fragment localGrade_3Fragment = new Grade_3Fragment(
					((Grade_2) Grade_2Fragment.this.grade_2List.get(paramInt))
							.getId());
			FragmentUtils.popFragment(
					Grade_2Fragment.this.getFragmentManager(), 2131099717,
					localGrade_3Fragment, "三级站点");
		}
	}
}
