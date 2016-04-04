package com.igpink.android.app.igpink.utils;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.EditText;

/**
 * Created by Zhiqiang on 2016/3/31.
 */
public class Utils {
    public static boolean isDebug = true;

    public static void log(String key, String values){
        if (isDebug) {
            if (!key.equals("") && !values.equals("")) {
                android.util.Log.e(key, values);
            }
        }
    }

    public static void transaction(FragmentManager fragmentManager,Fragment targetFragment, int container){
        fragmentManager.beginTransaction().replace(container,targetFragment).commit();
    }

    public static void transaction(FragmentManager fragmentManager,Fragment targetFragment, int container,String name){
        fragmentManager.beginTransaction().addToBackStack(name).add(container, targetFragment).commit();
    }

    public static void dismiss(ProgressDialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    public static boolean isNull(EditText editText) {
        if (editText != null){
            if (editText.getText().toString().trim().equals("")){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
