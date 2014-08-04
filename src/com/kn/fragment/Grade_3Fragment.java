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
import com.kn.adapter.Grade_3Adapter;
import com.kn.client.Grade_3Client;
import com.kn.entity.Grade_3;
import com.kn.utils.FragmentUtils;
import java.io.Serializable;
import java.util.List;

public class Grade_3Fragment extends Fragment implements View.OnClickListener {
	private static final String TAG = "二级站点Fragment";
	private Button button_back;
	private Button button_shangYiCeng;
	private View currentView;
	private int grade_2_id;
	private List<Grade_3> grade_3List = null;
	private int layoutId = R.layout.grade_3;
	private ListView listView_grade_3 = null;
	private Handler loadDataHandler = new Handler() {
		public void handleMessage(Message paramMessage) {
			super.handleMessage(paramMessage);
			Grade_3Fragment.this.grade_3List = ((List) paramMessage.getData()
					.getSerializable("grade_3"));
			if (Grade_3Fragment.this.grade_3List != null) {
				Grade_3Adapter localGrade_3Adapter = new Grade_3Adapter(
						Grade_3Fragment.this, Grade_3Fragment.this.grade_3List);
				Grade_3Fragment.this.listView_grade_3
						.setAdapter(localGrade_3Adapter);
				localGrade_3Adapter.notifyDataSetChanged();
			}
			Grade_3Fragment.this.loadDataProgress.dismiss();
		}
	};
	private ProgressDialog loadDataProgress = null;

	public Grade_3Fragment() {
		Log.d(TAG, "空构造方法");
	}

	public Grade_3Fragment(int layoutId) {
		Log.d(TAG, "带参造方法");
		this.grade_2_id = layoutId;
	}

	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
		Log.d(TAG, "onActivityCreated方法");
		new Thread(new LoadDataRunnable(this.grade_2_id)).start();
	}

	public void onAttach(Activity paramActivity) {
		super.onAttach(paramActivity);
		Log.d(TAG, "onAttach方法");
		this.loadDataProgress = ProgressDialog.show(paramActivity, "正在加载数据...",
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
			return;
		}
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		Log.d(TAG, "onCreate方法");
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		Log.d(TAG, "onCreateView方法");
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
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
		this.listView_grade_3 = ((ListView) paramView
				.findViewById(R.id.listView_grade_3));
		this.listView_grade_3
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
			localBundle.putSerializable("grade_3",
					(Serializable) Grade_3Client.grade_3List(this.key));
			localMessage.setData(localBundle);
			Grade_3Fragment.this.loadDataHandler.sendMessage(localMessage);
		}
	}

	private class OnItemClickListenerImpl implements
			AdapterView.OnItemClickListener {
		private OnItemClickListenerImpl() {
		}

		public void onItemClick(AdapterView<?> paramAdapterView,
				View paramView, int paramInt, long paramLong) {
			Log.d(TAG, "parent:"
					+ paramAdapterView.getClass().getName() + ",view:"
					+ paramView.getClass().getName() + ",position:" + paramInt
					+ ",id:" + paramLong);
			DetailFragment localDetailFragment = new DetailFragment(
					((Grade_3) Grade_3Fragment.this.grade_3List.get(paramInt))
							.getId());
			FragmentUtils.popFragment(
					Grade_3Fragment.this.getFragmentManager(), R.id.tab_changYongGongJu, localDetailFragment, "站点明细");
		}
	}
}
