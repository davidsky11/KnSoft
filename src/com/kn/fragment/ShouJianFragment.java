package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.kn.R;
import com.kn.utils.FragmentUtils;
import com.kn.utils.ListViewUtils;
import com.kn.utils.SaoMiaoUtils;

public class ShouJianFragment extends Fragment implements View.OnClickListener {

	private static final String TAG = "收件Fragment";

	private int layoutId = R.layout.shou_jian;

	private Button button_alter = null;
	private Button button_back = null;
	private Button button_commit = null;
	private Button button_confirm = null;
	private Button button_saomiao = null;
	private Button button_useCurrentUser = null;
	private View currentView;
	private EditText edit_yeWuYuanId = null;
	private ListView listView_yiSaoMiao = null;

	public ShouJianFragment() {
	}

	public ShouJianFragment(int layoutId) {
		this.layoutId = layoutId;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode != 0) {
			Log.e(TAG, "未找到调用者");
			if (resultCode == 0) {
				String str1 = data.getStringExtra("SCAN_RESULT");
				String str2 = data.getStringExtra("SCAN_RESULT_FORMAT");
				Log.e(TAG, "内容：" + str1 + ",格式：" + str2);
				Log.e(TAG, "操作取消");
			}
			return;
		}
	}

	public void onClick(View view) {
		switch (view.getId()) {

		case R.id.button_back:
			FragmentUtils.popBackStack(getFragmentManager());
			return;
		case R.id.button_commit:
			
			return;
		case R.id.button_useCurrentUser:
			
			return;
		case R.id.button_confirm:
			
			return;
		default:
			return;
		case R.id.button_alter:
			this.edit_yeWuYuanId.setEnabled(true);
			this.edit_yeWuYuanId.setFocusableInTouchMode(true);
			this.button_confirm.setEnabled(true);
			this.button_useCurrentUser.setEnabled(true);
			this.button_alter.setEnabled(false);
			return;
		case R.id.button_saomiao:
			Log.e(TAG, "ShouJianFragment >>> 扫描");
			SaoMiaoUtils.startSaoMiao(this);
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId, container, false);
		this.currentView.setFocusable(true);
		this.edit_yeWuYuanId = ((EditText) this.currentView
				.findViewById(R.id.edit_yeWuYuanId));
		this.button_useCurrentUser = ((Button) this.currentView
				.findViewById(R.id.button_useCurrentUser));
		this.button_confirm = ((Button) this.currentView
				.findViewById(R.id.button_confirm));
		this.button_alter = ((Button) this.currentView
				.findViewById(R.id.button_alter));
		this.button_saomiao = ((Button) this.currentView
				.findViewById(R.id.button_saomiao));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(R.id.listView_yiSaoMiao));
		this.button_commit = ((Button) this.currentView
				.findViewById(R.id.button_commit));
		this.button_back = ((Button) this.currentView
				.findViewById(R.id.button_back));
		this.button_alter.setOnClickListener(this);
		this.button_saomiao.setOnClickListener(this);
		this.button_commit.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		return this.currentView;
	}
}
