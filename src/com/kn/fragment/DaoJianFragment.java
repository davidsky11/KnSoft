package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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

public class DaoJianFragment extends Fragment implements View.OnClickListener {

	private static final String TAG = "到件Fragment";
	private Button button_back = null;
	private Button button_commit = null;
	private Button button_saomiao = null;
	private View currentView;
	private int layoutId = R.layout.dao_jian;
	private ListView listView_yiSaoMiao = null;
	private EditText shangYiWangDian_id = null;
	private EditText zhongLiang = null;

	public DaoJianFragment() {
	}

	public DaoJianFragment(int layoutId) {
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
		case R.id.button_commit:
		default:
			return;
		case R.id.button_saomiao:
			SaoMiaoUtils.startSaoMiao(this);
			return;
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater paramLayoutInflater,
			ViewGroup paramViewGroup, Bundle paramBundle) {
		this.currentView = paramLayoutInflater.inflate(this.layoutId,
				paramViewGroup, false);
		this.currentView.setFocusable(true);
		this.shangYiWangDian_id = ((EditText) this.currentView
				.findViewById(R.id.edit_shangYiWangDian_id));
		this.zhongLiang = ((EditText) this.currentView.findViewById(R.id.edit_zhongLiang));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(R.id.listView_yiSaoMiao));
		this.button_commit = ((Button) this.currentView
				.findViewById(R.id.button_commit));
		this.button_back = ((Button) this.currentView.findViewById(R.id.button_back));
		this.button_saomiao = ((Button) this.currentView
				.findViewById(R.id.button_back));
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		this.zhongLiang.addTextChangedListener(new TextWatcherImpl());
		this.button_back.setOnClickListener(this);
		this.button_saomiao.setOnClickListener(this);
		return this.currentView;
	}

	private class TextWatcherImpl implements TextWatcher {
		
		private TextWatcherImpl() {
			
		}

		public void afterTextChanged(Editable edit) {
		}

		public void beforeTextChanged(CharSequence paramCharSequence,
				int paramInt1, int paramInt2, int paramInt3) {
		}

		public void onTextChanged(CharSequence paramCharSequence,
				int paramInt1, int paramInt2, int paramInt3) {
			if ((paramCharSequence.length() > 0)
					&& (paramCharSequence.charAt(0) == '.'))
				DaoJianFragment.this.zhongLiang.setText("");
		}
	}
}
