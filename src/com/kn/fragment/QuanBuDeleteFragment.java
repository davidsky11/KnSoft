package com.kn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class QuanBuDeleteFragment extends Fragment
  implements View.OnClickListener
{
  private static final String TAG = "全部删除Fragment";
  private Button button_delete = null;
  private Button button_fanHuiZhuJieMian = null;
  private View currentView;
  private EditText edit_password = null;
  private int layoutId = 2130903060;

  public QuanBuDeleteFragment()
  {
  }

//  public QuanBuDeleteFragment(int paramInt)
//  {
//    this.layoutId = paramInt;
//  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131099726:
    case 2131099727:
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.currentView = paramLayoutInflater.inflate(this.layoutId, paramViewGroup, false);
    this.currentView.setFocusable(true);
    this.edit_password = ((EditText)this.currentView.findViewById(2131099709));
    this.button_delete = ((Button)this.currentView.findViewById(2131099726));
    this.button_fanHuiZhuJieMian = ((Button)this.currentView.findViewById(2131099727));
    this.button_delete.setOnClickListener(this);
    this.button_fanHuiZhuJieMian.setOnClickListener(this);
    return this.currentView;
  }
}

/* Location:           C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name:     com.seuic.fragment.QuanBuDeleteFragment
 * JD-Core Version:    0.6.0
 */