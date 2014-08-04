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
import android.widget.Button;
import android.widget.EditText;

import com.kn.R;
import com.kn.client.DetailClient;
import com.kn.entity.Detail;
import com.kn.utils.FragmentUtils;
import java.util.List;

public class DetailFragment extends Fragment implements View.OnClickListener {
	private static final String TAG = "站点明细Fragment";
	private Button button_back;
	private Button button_shangYiCeng;
	private View currentView;
	private EditText edit_bu_pai_song_fan_wei;
	private EditText edit_fu_ze_ren;
	private EditText edit_pai_song_fan_wei;
	private EditText edit_telephone;
	private EditText edit_wang_dian_id;
	private EditText edit_wang_dian_ming_cheng;
	private int grade_3_id;
	private int layoutId = R.layout.detail;
	private Handler loadDataHandler = new Handler() {
		public void handleMessage(Message paramMessage) {
			super.handleMessage(paramMessage);
			Detail localDetail = (Detail) paramMessage.getData()
					.getSerializable("detail");
			if (localDetail != null) {
				DetailFragment.this.edit_wang_dian_ming_cheng
						.setText(localDetail.getDetail_name());
				DetailFragment.this.edit_wang_dian_id.setText(localDetail
						.getDetail_number());
				DetailFragment.this.edit_fu_ze_ren.setText(localDetail
						.getFu_ze_ren());
				DetailFragment.this.edit_pai_song_fan_wei.setText(localDetail
						.getPai_song_fan_wei());
				DetailFragment.this.edit_bu_pai_song_fan_wei
						.setText(localDetail.getBu_pai_song_fan_wei());
				DetailFragment.this.edit_telephone.setText(localDetail
						.getTelephone());
			}
			DetailFragment.this.loadDataProgress.dismiss();
		}
	};
	private ProgressDialog loadDataProgress = null;

	public DetailFragment() {
		Log.d(TAG, "空构造方法");
	}

	public DetailFragment(int paramInt) {
		Log.d(TAG, "有参构造方法");
		this.grade_3_id = paramInt;
	}

	public void onActivityCreated(Bundle paramBundle) {
		super.onActivityCreated(paramBundle);
		Log.d(TAG, "onActivityCreated方法");
		new Thread(new LoadDataRunnable(this.grade_3_id)).start();
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

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		Log.d(TAG, "onCreateView方法");
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		return this.currentView;
	}

	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.d(TAG, "onViewCreated方法");
		this.edit_wang_dian_ming_cheng = ((EditText) view
				.findViewById(R.id.edit_wang_dian_ming_cheng));
		this.edit_wang_dian_id = ((EditText) view.findViewById(R.id.edit_wang_dian_id));
		this.edit_fu_ze_ren = ((EditText) view.findViewById(R.id.edit_fu_ze_ren));
		this.edit_telephone = ((EditText) view.findViewById(R.id.edit_telephone));
		this.edit_pai_song_fan_wei = ((EditText) view
				.findViewById(R.id.edit_pai_song_fan_wei));
		this.edit_bu_pai_song_fan_wei = ((EditText) view
				.findViewById(R.id.edit_bu_pai_song_fan_wei));
		this.button_shangYiCeng = ((Button) view.findViewById(R.id.button_shangYiCeng));
		this.button_shangYiCeng.setOnClickListener(this);
		this.button_back = ((Button) view.findViewById(R.id.button_back));
		this.button_back.setOnClickListener(this);
	}

	private class LoadDataRunnable implements Runnable {
		private int key;

		public LoadDataRunnable(int key) {
			this.key = key;
		}

		public void run() {
			Message localMessage = Message.obtain();
			Bundle localBundle = new Bundle();
			int i = DetailClient.detailList(this.key).size();
			Detail localDetail = null;
			if (i > 0)
				localDetail = (Detail) DetailClient.detailList(this.key).get(0);
			localBundle.putSerializable("detail", localDetail);
			localMessage.setData(localBundle);
			DetailFragment.this.loadDataHandler.sendMessage(localMessage);
		}
	}
}
