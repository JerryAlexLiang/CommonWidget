package com.example.customprogressdiaolg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.customprogressdiaolg.customview.CustomProgressDialogOne;
import com.example.customprogressdiaolg.customview.CustomProgressDialogThree;
import com.example.customprogressdiaolg.customview.CustomProgressDialogTwo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonOne = (Button) findViewById(R.id.dialog_one_btn);
        Button buttonTwo = (Button) findViewById(R.id.dialog_two_btn);
        Button buttonThree = (Button) findViewById(R.id.dialog_three_btn);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_one_btn:
                final CustomProgressDialogOne dialogOne = new CustomProgressDialogOne(MainActivity.this,"正在加载中...");
                dialogOne.show();
                //休眠5秒，模拟耗时操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            dialogOne.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;

            case R.id.dialog_two_btn:
                final CustomProgressDialogTwo dialogTwo = new CustomProgressDialogTwo(MainActivity.this, "正在加载中...");
                dialogTwo.show();
                //休眠5秒，模拟耗时操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            dialogTwo.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;

            case R.id.dialog_three_btn:
                final CustomProgressDialogThree dialogThree = new CustomProgressDialogThree(MainActivity.this,"正在加载中...",false);
                dialogThree.show();
                //休眠5秒，模拟耗时操作
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            dialogThree.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
        }
    }
}
