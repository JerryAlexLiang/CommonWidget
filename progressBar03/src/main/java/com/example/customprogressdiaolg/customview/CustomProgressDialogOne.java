package com.example.customprogressdiaolg.customview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customprogressdiaolg.R;

/**
 * 创建日期：2017/5/25 on 上午9:06
 * 描述:自定义ProgressDialog
 * 作者:yangliang
 */
public class CustomProgressDialogOne {
    private final Dialog dialog;
    private final TextView textView;

    public CustomProgressDialogOne(Context context, String content) {
        this(context, content, false);
    }

    public CustomProgressDialogOne(Context context, String content, boolean cancelable) {
        //自定义Dialog样式
        dialog = new Dialog(context, R.style.CustomProgressDialog);
        dialog.setCancelable(false); // 设置弹窗外围不可点击取消
        //得到加载布局
        View view = LayoutInflater.from(context).inflate(R.layout.progress_dialog_one, null);
        //布局文字
        textView = (TextView) view.findViewById(R.id.progressDialog_text);
        //布局图片
        ImageView imageView = (ImageView) view.findViewById(R.id.progressDialog_img);
//        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressDialog_img);
        textView.setText(content);
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.load_animation_anticlockwise);
        // 使用ImageView显示动画
        imageView.startAnimation(hyperspaceJumpAnimation);
//        progressBar.startAnimation(hyperspaceJumpAnimation);
        // 设置布局
        dialog.setContentView(view);
    }


    public void show() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public boolean isShow() {
        if (dialog != null) {
            return dialog.isShowing();
        } else {
            return false;
        }
    }
}
