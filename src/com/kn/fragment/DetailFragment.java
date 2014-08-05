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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kn.R;
import com.kn.client.DetailClient;
import com.kn.entity.Detail;
import com.kn.utils.FragmentUtils;

public class DetailFragment extends Fragment implements View.OnClickListener {
	
	private static final String TAG = "站点明细Fragment";
	private int grade_3_id;
	private int layoutId = R.layout.detail;
	
	private Button button_back;
	private Button button_shangYiCeng;
	private View currentView;
	private EditText edit_bu_pai_song_fan_wei;
	private EditText edit_fu_ze_ren;
	private EditText edit_pai_song_fan_wei;
	private EditText edit_telephone;
	private EditText edit_wang_dian_id;
	private EditText edit_wang_dian_ming_cheng;
	private ProgressDialog dataProgress = null;

	private Handler dataHandler = new Handler() {
		public void handleMessage(Message message) {
			super.handleMessage(message);
			Detail detail = (Detail) message.getData()
					.getSerializable("detail");
			if (detail != null) {
				DetailFragment.this.edit_wang_dian_ming_cheng
						.setText(detail.getDetail_name());
				DetailFragment.this.edit_wang_dian_id.setText(detail
						.getDetail_number());
				DetailFragment.this.edit_fu_ze_ren.setText(detail
						.getFu_ze_ren());
				DetailFragment.this.edit_pai_song_fan_wei.setText(detail
						.getPai_song_fan_wei());
				DetailFragment.this.edit_bu_pai_song_fan_wei
						.setText(detail.getBu_pai_song_fan_wei());
				DetailFragment.this.edit_telephone.setText(detail
						.getTelephone());
			}
			DetailFragment.this.dataProgress.dismiss();
		}
	};
	
	public DetailFragment() {
		Log.d(TAG, "空构造方法");
	}

	public DetailFragment(int layoutId) {
		Log.d(TAG, "有参构造方法");
		this.grade_3_id = layoutId;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated方法");
		new Thread(new LoadDataRunnable(this.grade_3_id)).start();
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
			return;
		}
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
			Message message = Message.obtain();
			Bundle bundle = new Bundle();
			int i = DetailClient.detailList(this.key).size();
			Detail detail = null;
			if (i > 0)
				detail = (Detail) DetailClient.detailList(this.key).get(0);
			bundle.putSerializable("detail", detail);
			message.setData(bundle);
			DetailFragment.this.dataHandler.sendMessage(message);
		}
	}
}
