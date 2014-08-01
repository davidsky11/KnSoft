package com.kn.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.kn.R;
import com.kn.utils.ListViewUtils;
import com.kn.utils.SaoMiaoUtils;

@SuppressLint("ValidFragment")
public class ShouJianFragment extends Fragment implements View.OnClickListener {
	
	private static final String TAG = "收件Fragment";
	private Button button_alter = null;
	private Button button_back = null;
	private Button button_commit = null;
	private Button button_confirm = null;
	private Button button_saomiao = null;
	private Button button_useCurrentUser = null;
	private View currentView;
	private EditText edit_yeWuYuanId = null;
	private int layoutId = R.layout.shou_jian;
	private ListView listView_yiSaoMiao = null;

	public ShouJianFragment() {
	}

	public ShouJianFragment(int paramInt) {
		this.layoutId = paramInt;
	}

	public void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
		Log.e(TAG, "ShouJianFragment >>> onActivityResult");
//		if (paramInt1 != 0)
//			Log.e(TAG, "未找到调用者");
//		do {
//			// if (paramInt2 != -1)
//			// continue;
//			String str1 = paramIntent.getStringExtra("SCAN_RESULT");
//			String str2 = paramIntent.getStringExtra("SCAN_RESULT_FORMAT");
//			Log.e(TAG, "内容：" + str1 + ",格式：" + str2);
//			return;
//		} while (paramInt2 != 0);
//		 Log.e("收件Fragment", "操作取消");
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		
		case R.id.button_back:
			return;
		case R.id.button_commit:
		case R.id.button_useCurrentUser:
		case R.id.button_confirm:
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

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		this.edit_yeWuYuanId = ((EditText) this.currentView
				.findViewById(R.id.edit_yeWuYuanId));
		this.button_useCurrentUser = ((Button) this.currentView
				.findViewById(R.id.button_useCurrentUser));
		this.button_confirm = ((Button) this.currentView
				.findViewById(R.id.button_confirm));
		this.button_alter = ((Button) this.currentView.findViewById(R.id.button_alter));
		this.button_saomiao = ((Button) this.currentView
				.findViewById(R.id.button_saomiao));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(R.id.listView_yiSaoMiao));
		this.button_commit = ((Button) this.currentView
				.findViewById(R.id.button_commit));
		this.button_back = ((Button) this.currentView.findViewById(R.id.button_back));
		this.button_alter.setOnClickListener(this);
		this.button_saomiao.setOnClickListener(this);
		this.button_commit.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		return this.currentView;
	}
}
