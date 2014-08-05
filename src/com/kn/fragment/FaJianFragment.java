package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.kn.R;
import com.kn.utils.ListViewUtils;
import com.kn.utils.SaoMiaoUtils;

public class FaJianFragment extends Fragment implements View.OnClickListener {

	private static final String TAG = "发件Fragment";
	
	private int layoutId = R.layout.fa_jian;
	private static final String[] SPINNER_DATA = { "111", "119", "120", "110" };
	
	private EditText baoZhuangDai_id = null;
	private Button button_back = null;
	private Button button_commit = null;
	private Button button_saomiao = null;
	private View currentView;
	private ListView listView_yiSaoMiao = null;
	private ArrayAdapter<String> spinnerAdapter = null;
	private Spinner spinner_banCi = null;
	private TextView text_daiTiJiao = null;
	private TextView text_yiSaoMiao = null;
	private EditText xiYiWangDian_id = null;

	public FaJianFragment() {
	}

	public FaJianFragment(int layoutId) {
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
			Log.i(TAG, "返回键被点击了.");
			FragmentManager fm = getActivity().getSupportFragmentManager();
			Log.i(TAG, " fm : " + fm);
			FragmentTransaction ft = fm.beginTransaction();
			ft.remove(FaJianFragment.this);
			ft.addToBackStack(null);
			ft.commit();
		case R.id.button_commit:
		default:
			return;
		case R.id.button_saomiao:
			SaoMiaoUtils.startSaoMiao(this);
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId,
				container, false);
		this.currentView.setFocusable(true);
		this.baoZhuangDai_id = ((EditText) this.currentView
				.findViewById(R.id.edit_baoZhuangDai_id));
		this.spinner_banCi = ((Spinner) this.currentView
				.findViewById(R.id.spinner_banCi));
		this.xiYiWangDian_id = ((EditText) this.currentView
				.findViewById(R.id.edit_xiaYiWangDian_id));
		this.text_yiSaoMiao = ((TextView) this.currentView
				.findViewById(R.id.text_yiSaoMiao));
		this.text_daiTiJiao = ((TextView) this.currentView
				.findViewById(R.id.text_daiTiJiao));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(R.id.listView_yiSaoMiao));
		this.button_commit = ((Button) this.currentView
				.findViewById(R.id.button_commit));
		this.button_back = ((Button) this.currentView
				.findViewById(R.id.button_back));
		this.button_saomiao = ((Button) this.currentView
				.findViewById(R.id.button_saomiao));
		this.spinnerAdapter = new ArrayAdapter(getActivity(),
				android.R.layout.simple_spinner_item, SPINNER_DATA);
		this.spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.spinner_banCi.setAdapter(this.spinnerAdapter);
		this.spinner_banCi.setVisibility(0);
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		this.button_commit.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
		this.button_saomiao.setOnClickListener(this);
		return this.currentView;
	}
}
