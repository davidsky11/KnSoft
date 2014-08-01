package com.kn.activity;

import com.kn.R;
import com.kn.fragment.BaseFragment;
import com.kn.fragment.ChaKanPeiZhiFragment;
import com.kn.fragment.DaoJianFragment;
import com.kn.fragment.FaJianFragment;
import com.kn.fragment.LiuCangJianFragment;
import com.kn.fragment.PaiJianFragment;
import com.kn.fragment.QianShouFragment;
import com.kn.fragment.ShouJianFragment;
import com.kn.fragment.WenTiJianFragment;
import com.kn.utils.FragmentUtils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends FragmentActivity {

	private static final String TAG = "MainActivity";
	private static final String CHANG_YONG_GONG_JU = "常用工具";
	private static final int CHECK_APP_FLAG_FALSE = 2;
	private static final int CHECK_APP_FLAG_TRUE = 1;
	private static final String CHONG_XIN_DENG_LU = "重新登录";
	private static final int DOWN_APP_FLAG_FALIURE = 4;
	private static final int DOWN_APP_FLAG_SUCCESS = 3;
	private static final String GUAN_LI_GONG_JU = "管理工具";
	private static final String[] ITEMS_GENG_XIN_SHU_JU = { "同步用户", "同步数据",
			"退出" };
	private static final String SHAN_CHU_SHU_JU = "删除数据";
	private static final String SHU_JU_SHANG_CHUAN = "数据上传";
	private static final String TIAO_MA_SAO_MIAO = "条码扫描";

	private Button button_back_cygj = null;
	private Button button_back_glgj = null;
	private Button button_back_scsj = null;
	private Button button_back_tmsm = null;
	private Button button_chaKanPeiZhi = null;
	private Button button_chengXuGengXin = null;
	private Button button_danBi_delete = null;
	private Button button_daoJian = null;
	private Button button_faJian = null;
	private Button button_gengXinShuJu = null;
	private Button button_liuCangJian = null;
	private Button button_paiJian = null;
	private Button button_paiSongFanWei = null;
	private Button button_qianShou = null;
	private Button button_quanBu_delete = null;
	private Button button_shangChuang_begin = null;
	private Button button_shangChuang_stop = null;
	private Button button_sheBeiPeiZhi = null;
	private Button button_shiJianTongBu = null;
	private Button button_shouJian = null;
	private Button button_wangLuoCeShi = null;
	private Button button_wenTiJian = null;
	private Button button_yunDanZhuiZong = null;
	private ProgressDialog checkAppProgress = null;
	private Fragment fragment;
	private FragmentTransaction fragmentTransaction;
	private AlertDialog.Builder gengXinShuJuDialog;
	private GestureDetector gestureDetector = null;
	private int index = 0;
	private boolean isShow = false;
	private AlertDialog.Builder loginOffDialog;

	private PopupWindow popupWindow;
	private Resources resources;
	private TabHost tabHost;
	private TabWidget tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.main);

		this.resources = getResources();
		this.tabHost = ((TabHost) findViewById(android.R.id.tabhost));
		this.tabs = ((TabWidget) findViewById(android.R.id.tabs));
		this.tabHost.setup();
		this.tabHost.addTab(this.tabHost
				.newTabSpec(TIAO_MA_SAO_MIAO)
				.setIndicator(TIAO_MA_SAO_MIAO,
						this.resources.getDrawable(R.drawable.ic_tmsm))
				.setContent(R.id.tab_tiaoMaSaoMiao));
		this.tabHost.addTab(this.tabHost
				.newTabSpec(SHAN_CHU_SHU_JU)
				.setIndicator(SHAN_CHU_SHU_JU,
						this.resources.getDrawable(R.drawable.ic_scsj))
				.setContent(R.id.tab_shanChuShuJu));
		this.tabHost.addTab(this.tabHost
				.newTabSpec(SHU_JU_SHANG_CHUAN)
				.setIndicator(SHU_JU_SHANG_CHUAN,
						this.resources.getDrawable(R.drawable.ic_sjsc))
				.setContent(R.id.tab_shuJuShangChuan));
		this.tabHost.addTab(this.tabHost
				.newTabSpec(CHANG_YONG_GONG_JU)
				.setIndicator(CHANG_YONG_GONG_JU,
						this.resources.getDrawable(R.drawable.ic_cygj))
				.setContent(R.id.tab_changYongGongJu));
		this.tabHost.addTab(this.tabHost
				.newTabSpec(GUAN_LI_GONG_JU)
				.setIndicator(GUAN_LI_GONG_JU,
						this.resources.getDrawable(R.drawable.ic_glgj))
				.setContent(R.id.tab_guanLiGongJu));
		this.tabHost.addTab(this.tabHost
				.newTabSpec(CHONG_XIN_DENG_LU)
				.setIndicator(CHONG_XIN_DENG_LU,
						this.resources.getDrawable(R.drawable.ic_cxdl))
				.setContent(R.id.tab_chongXinDengLu));
		setTabsText(this.tabHost);
		DisplayMetrics localDisplayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
		int i = localDisplayMetrics.widthPixels;
		this.tabHost.setCurrentTab(0);
		for (int j = 0;; j++) {
			if (j >= this.tabs.getChildCount()) {
				this.gestureDetector = new GestureDetector(
						getApplicationContext(), new OnGestureDetectorImpl());
				return;
			}
			this.tabs.getChildTabViewAt(j).setMinimumWidth(
					i / this.tabs.getChildCount());
			this.tabs.getChildTabViewAt(j).getBackground().setAlpha(0);
			this.tabs.getChildTabViewAt(j).setOnClickListener(
					new OnTabViewClickListenerImpl(j));
		}
	}

	private void setTabsText(View view) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class OnGestureDetectorImpl implements
			GestureDetector.OnGestureListener {

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (e2.getRawX() - e1.getRawX() > 80.0F) {
				MainActivity.this.showNext();
				return true;
			}
			if (e1.getRawX() - e2.getRawX() > 80.0F) {
				MainActivity.this.showNext();
				return true;
			}
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	private class OnButtonClickListenerImpl implements View.OnClickListener {

		private OnButtonClickListenerImpl() {

		}

		@Override
		public void onClick(View view) {
			switch (view.getId()) {
			default:
				return;

			case R.id.button_shouJian:
				Log.d(TAG, "收件被点击");
				MainActivity.this.fragment = new ShouJianFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "收件");
				return;
			case R.id.button_faJian:
				Log.d(TAG, "发件被点击");
				MainActivity.this.fragment = new FaJianFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "发件");
				return;
			case R.id.button_daoJian:
				Log.d(TAG, "到件被点击");
				MainActivity.this.fragment = new DaoJianFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "到件");
				return;
			case R.id.button_paiJian:
				Log.d(TAG, "派件被点击");
				MainActivity.this.fragment = new PaiJianFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "派件");
				return;
			case R.id.button_qianShou:
				Log.d(TAG, "签收被点击");
				MainActivity.this.fragment = new QianShouFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "签收");
				return;
			case R.id.button_wenTiJian:
				Log.d(TAG, "问题件被点击");
				MainActivity.this.fragment = new WenTiJianFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "问题收");
				return;
			case R.id.button_liuCangJian:
				Log.d(TAG, "留仓件被点击");
				MainActivity.this.fragment = new LiuCangJianFragment();
				MainActivity.this.popFragment(R.id.tab_tiaoMaSaoMiao,
						MainActivity.this.fragment, "留仓收");
				return;
			case R.id.button_back_tmsm:
				Log.d(TAG, "返回被点击");
				MainActivity.this.replaceFragment(R.id.tab_tiaoMaSaoMiao,
						R.layout.excels);
				return;
				
			case R.id.button_danBi_delete:
				
				return;
			case R.id.button_quanBu_delete:
				
				return;
			case R.id.button_back_scsj:
				Log.d(TAG, "返回被点击");
				MainActivity.this.replaceFragment(R.id.tab_shanChuShuJu,
						R.layout.details);
				return;
			case R.id.button_paiSongFanWei:
				
				return;
			case R.id.button_yunDanZhuiZong:
				
				return;
			case R.id.button_chengXuGengXin:
				
				return;
			case R.id.button_shiJianTongBu:
				
				return;
			case R.id.button_gengXinShuJu:
				
				return;
			case R.id.button_wangLuoCeShi:
				
				return;
			case R.id.button_back_cygj:
				Log.d(TAG, "返回被点击");
				MainActivity.this.replaceFragment(R.id.tab_changYongGongJu,
						R.layout.budgets);
				return;
			case R.id.button_chaKanPeiZhi:
				Log.d(TAG, "查看配置被点击");
				MainActivity.this.fragment = new ChaKanPeiZhiFragment();
				MainActivity.this.popFragment(R.id.tab_guanLiGongJu,
						MainActivity.this.fragment, "查看配置");
			case R.id.button_sheBeiPeiZhi:
				Log.d(TAG, "设备配置被点击");
				
				return;
			case R.id.button_back_glgj:
				Log.d(TAG, "返回被点击");
				return;

			}
		}
	}

	protected void replaceFragment(int id, int layoutId) {
		this.fragment = new BaseFragment(layoutId);
		this.fragmentTransaction = getSupportFragmentManager()
				.beginTransaction();
		this.fragmentTransaction.replace(id, this.fragment);
		this.fragmentTransaction
				.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); // 4099
		this.fragmentTransaction.commit();
		closePopupWindow();
	}

	private class OnTabViewClickListenerImpl implements View.OnClickListener {

		private int position;

		public OnTabViewClickListenerImpl(int clickId) {
			this.position = clickId;
		}

		@Override
		public void onClick(View v) {
			MainActivity.this.index = this.position;
			switch (this.position) {
			default:
				return;
			case 0:
				Log.e(TAG, "*条码扫描#" + this.position);
				MainActivity.this.popupWindowShow(R.layout.tiao_ma_sao_miao,
						R.id.tab_tiaoMaSaoMiao);
				MainActivity.this.tabHost.setCurrentTab(this.position);
				return;
			case 1:
				Log.e(TAG, "*删除数据#" + this.position);
				MainActivity.this.popupWindowShow(R.layout.shan_chu_shu_ju,
						R.id.tab_shanChuShuJu);
				MainActivity.this.tabHost.setCurrentTab(this.position);
				return;
			case 2:
				Log.e(TAG, "*数据上传#" + this.position);
				MainActivity.this.tabHost.setCurrentTab(this.position);
				return;
			case 3:
				Log.e(TAG, "*常用工具#" + this.position);
				MainActivity.this.popupWindowShow(R.layout.chang_yong_gong_ju,
						R.id.tab_changYongGongJu);
				MainActivity.this.tabHost.setCurrentTab(this.position);
				return;
			case 4:
				Log.e(TAG, "*管理工具#" + this.position);
				MainActivity.this.popupWindowShow(R.layout.guan_li_gong_ju,
						R.id.tab_guanLiGongJu);
				MainActivity.this.tabHost.setCurrentTab(this.position);
				return;
			case 5:
				Log.e(TAG, "*重新登录#" + this.position);
				if ((MainActivity.this.popupWindow != null)
						&& (MainActivity.this.popupWindow.isShowing())) {
					MainActivity.this.popupWindow.dismiss();
					MainActivity.this.popupWindow = null;
				}
				MainActivity.this.finish();
				MainActivity.this.tabHost.setCurrentTab(this.position);
			}
		}

	}

	public void popupWindowShow(int layout, int id) {
		Log.e(TAG, "layout : " + layout + "\tid : " + id);
		if (!closePopupWindow()) {
			Log.e(TAG, "initPopWindow");
			initPopWindow(layout);
			this.popupWindow.showAtLocation(this.tabHost.findViewById(id), 80,
					0, this.tabs.getHeight());
			setShow(true);
		}
	}

	public void popFragment(int param, Fragment fragment, String str) {
		FragmentUtils.popFragment(getSupportFragmentManager(), param, fragment,
				str);
		closePopupWindow();
	}

	public void showNext() {
		closePopupWindow();
		Log.i(TAG, "before next touch:" + this.index);
		TabHost localTabHost = this.tabHost;
		int i = 0;
		if (this.index == -1 + this.tabs.getChildCount())
			i = 0;
		while (true) {
			this.index = i;
			localTabHost.setCurrentTab(i);
			this.tabs.setCurrentTab(this.index);
			Log.i(TAG, "next:" + this.index);
			i = 1 + this.index;
			this.index = i;
			return;
		}
	}

	private void initPopWindow(int layoutId) {
		View localView = ((LayoutInflater) getSystemService("layout_inflater"))
				.inflate(layoutId, null);
		this.popupWindow = new PopupWindow(localView, -2, -2, true);
		this.popupWindow.setFocusable(false);
		this.popupWindow.setOutsideTouchable(true);
		this.popupWindow.setTouchable(true);
		this.popupWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY)); // -7829368
		this.popupWindow.update();

		localView.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
				if ((MainActivity.this.popupWindow != null)
						&& (MainActivity.this.popupWindow.isShowing())) {
					MainActivity.this.popupWindow.dismiss();
					MainActivity.this.popupWindow = null;
				}
				return true;
			}
		});

		switch (layoutId) {
		default:
			return;
		case R.layout.tiao_ma_sao_miao:
			Log.e(TAG, "button tiaomasaomiao has been pressed!");
			this.button_shouJian = ((Button) localView
					.findViewById(R.id.button_shouJian));
			this.button_faJian = ((Button) localView
					.findViewById(R.id.button_faJian));
			this.button_daoJian = ((Button) localView
					.findViewById(R.id.button_daoJian));
			this.button_paiJian = ((Button) localView
					.findViewById(R.id.button_paiJian));
			this.button_qianShou = ((Button) localView
					.findViewById(R.id.button_qianShou));
			this.button_wenTiJian = ((Button) localView
					.findViewById(R.id.button_wenTiJian));
			this.button_liuCangJian = ((Button) localView
					.findViewById(R.id.button_liuCangJian));
			this.button_back_tmsm = ((Button) localView
					.findViewById(R.id.button_back_tmsm));
			this.button_shouJian
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_faJian
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_daoJian
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_paiJian
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_qianShou
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_wenTiJian
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_liuCangJian
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_back_tmsm
					.setOnClickListener(new OnButtonClickListenerImpl());
			return;
		case R.layout.shan_chu_shu_ju:
			this.button_danBi_delete = ((Button) localView
					.findViewById(R.id.button_danBi_delete));
			this.button_quanBu_delete = ((Button) localView
					.findViewById(R.id.button_quanBu_delete));
			this.button_back_scsj = ((Button) localView
					.findViewById(R.id.button_back_scsj));
			this.button_danBi_delete
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_quanBu_delete
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_back_scsj
			.setOnClickListener(new OnButtonClickListenerImpl());
			return;
//		case 数据上传：
//		case R.layout.shu_ju_shang_chuan:
//			this.button_shangChuang_begin = ((Button) localView
//					.findViewById(R.id.button_shangChuan));
//			this.button_shangChuang_stop = ((Button) localView.findViewById(R.id.button_shan))
//			return;
		case R.layout.chang_yong_gong_ju:
			this.button_paiSongFanWei = ((Button) localView
					.findViewById(R.id.button_paiSongFanWei));
			this.button_yunDanZhuiZong = ((Button) localView
					.findViewById(R.id.button_yunDanZhuiZong));
			this.button_chengXuGengXin = ((Button) localView
					.findViewById(R.id.button_chengXuGengXin));
			this.button_shiJianTongBu = ((Button) localView
					.findViewById(R.id.button_shiJianTongBu));
			this.button_gengXinShuJu = ((Button) localView
					.findViewById(R.id.button_gengXinShuJu));
			this.button_wangLuoCeShi = ((Button) localView
					.findViewById(R.id.button_wangLuoCeShi));
			this.button_back_cygj = ((Button) localView
					.findViewById(R.id.button_back_cygj));
			this.button_paiSongFanWei
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_yunDanZhuiZong
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_chengXuGengXin
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_shiJianTongBu
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_gengXinShuJu
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_wangLuoCeShi
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_back_cygj
					.setOnClickListener(new OnButtonClickListenerImpl());
			return;
		case R.layout.guan_li_gong_ju:
			this.button_chaKanPeiZhi = ((Button) localView
					.findViewById(R.id.button_chaKanPeiZhi));
			this.button_sheBeiPeiZhi = ((Button) localView
					.findViewById(R.id.button_sheBeiPeiZhi));
			this.button_back_glgj = ((Button) localView
					.findViewById(R.id.button_back_glgj));
			this.button_chaKanPeiZhi
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_sheBeiPeiZhi
					.setOnClickListener(new OnButtonClickListenerImpl());
			this.button_back_glgj
					.setOnClickListener(new OnButtonClickListenerImpl());
		// case 重新登录：
		}
	}

	private boolean closePopupWindow() {
		boolean bool = isShow();
		Log.e(TAG, "closePopupWindow " + bool);
		boolean flag = false;
		if (bool) {
			if (this.popupWindow != null) {
				this.popupWindow.dismiss();
				this.popupWindow = null;
			}
			setShow(false);
			flag = true;
		}
		return flag;
	}

	private boolean isShow() {
		return this.isShow;
	}

	private void setShow(boolean flag) {
		this.isShow = flag;
	}
}
