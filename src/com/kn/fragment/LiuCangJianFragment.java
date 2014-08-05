package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.kn.R;
import com.kn.utils.ListViewUtils;
import com.kn.utils.SaoMiaoUtils;

public class LiuCangJianFragment extends Fragment implements
		View.OnClickListener {

	private static final String[] SPINNER_DATA = { "1", "2", "3", "4", "5" };
	private static final String TAG = "留仓件Fragment";
	private int layoutId = R.layout.liu_cang_jian;

	private Button button_alter = null;
	private Button button_back = null;
	private Button button_commit = null;
	private Button button_saomiao = null;
	private View currentView;
	private EditText edit_liuCangJian_description = null;
	private ListView listView_yiSaoMiao = null;
	private ArrayAdapter<String> spinnerAdapter = null;
	private Spinner spinner_liuCangJian_type = null;
	private TextView text_daiTiJiao = null;
	private TextView text_yiSaoMiao = null;

	public LiuCangJianFragment() {
	}

	public LiuCangJianFragment(int layoutId) {
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
		case R.id.button_alter:
			this.edit_liuCangJian_description.setFocusable(true);
			this.edit_liuCangJian_description.setFocusableInTouchMode(true);
			this.edit_liuCangJian_description.setCursorVisible(true);
			this.button_alter.setEnabled(false);
			return;
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.currentView = inflater.inflate(this.layoutId, container, false);
		this.currentView.setFocusable(true);
		this.spinner_liuCangJian_type = ((Spinner) this.currentView
				.findViewById(R.id.spinner_liuCangJian_type));
		this.edit_liuCangJian_description = ((EditText) this.currentView
				.findViewById(R.id.edit_liuCangJian_description));
		this.text_yiSaoMiao = ((TextView) this.currentView
				.findViewById(R.id.text_yiSaoMiao));
		this.text_daiTiJiao = ((TextView) this.currentView
				.findViewById(R.id.text_daiTiJiao));
		this.listView_yiSaoMiao = ((ListView) this.currentView
				.findViewById(R.id.listView_yiSaoMiao));
		this.button_alter = ((Button) this.currentView
				.findViewById(R.id.button_alter));
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
		this.spinner_liuCangJian_type.setAdapter(this.spinnerAdapter);
		this.spinner_liuCangJian_type.setVisibility(0);
		this.spinner_liuCangJian_type
				.setOnItemSelectedListener(new OnItemSelectedListenerImpl());
		this.button_saomiao.setOnClickListener(this);
		this.button_back.setOnClickListener(this);
		this.button_alter.setOnClickListener(this);
		ListViewUtils.listViewYiSaoMiao(this, this.listView_yiSaoMiao);
		return this.currentView;
	}

	private class OnItemSelectedListenerImpl implements
			AdapterView.OnItemSelectedListener {

		private OnItemSelectedListenerImpl() {

		}

		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			LiuCangJianFragment.this.edit_liuCangJian_description
					.setText(LiuCangJianFragment.SPINNER_DATA[position]);
		}

		public void onNothingSelected(AdapterView<?> parent) {

		}
	}
}
