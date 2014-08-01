package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.kn.R;
import com.kn.utils.ListViewUtils;
import com.kn.utils.SaoMiaoUtils;

public class QianShouFragment extends Fragment implements View.OnClickListener {
	private static final String[] SPINNER_DATA = { "1", "2", "33" };
	private static final String TAG = "签收Fragment";
	private Button button_alter = null;
	private Button button_back = null;
	private Button button_commit = null;
	private Button button_saomiao = null;
	private View currentView;
	private EditText edit_qianShouRen_name = null;
	private int layoutId = R.layout.qian_shou;
	private ListView listView_yiSaoMiao = null;
	private ArrayAdapter<String> spinnerAdapter = null;
	private Spinner spinner_qianShou_type = null;
	private TextView text_daiTiJiao = null;
	private TextView text_yiSaoMiao = null;

	public QianShouFragment() {

	}

	public QianShouFragment(int paramInt) {
		this.layoutId = paramInt;
	}

	public void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		case R.id.button_back:
		case R.id.button_commit:
		default:
			return;
		case R.id.button_saomiao:
			SaoMiaoUtils.startSaoMiao(this);
			return;
		case R.id.button_alter:
			this.edit_qianShouRen_name.setFocusable(true);
			this.edit_qianShouRen_name.setFocusableInTouchMode(true);
			this.edit_qianShouRen_name.setCursorVisible(true);
			this.button_alter.setEnabled(false);
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
		this.spinner_qianShou_type = ((Spinner) this.currentView
				.findViewById(R.id.spinner_qianShou_type));
		this.edit_qianShouRen_name = ((EditText) this.currentView
				.findViewById(R.id.edit_qianShouRen_name));
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
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // 17367049
		this.spinner_qianShou_type.setAdapter(this.spinnerAdapter);
		this.spinner_qianShou_type.setVisibility(0);
		this.spinner_qianShou_type
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

		public void onItemSelected(AdapterView<?> paramAdapterView,
				View paramView, int paramInt, long paramLong) {
			QianShouFragment.this.edit_qianShouRen_name
					.setText(QianShouFragment.SPINNER_DATA[paramInt]);
		}

		public void onNothingSelected(AdapterView<?> paramAdapterView) {
			
		}
	}
}
