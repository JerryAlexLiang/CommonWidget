package com.mingrisoft.keytext;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    String string = "     Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，" +
            "如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。尚未有统一中文名称，" +
            "中国大陆地区较多人使用“安卓”或“安致”。Android操作系统最初由Andy Rubin开发，" +
            "主要支持手机。2005年8月由Google收购注资。2007年11月，Google与84家硬件制造商、" +
            "软件开发商及电信营运商组建开放手机联盟共同研发改良Android系统。随后Google以Apache开源许可证的授权方式，" +
            "发布了Android的源代码。第一部Android智能手机发布于2008年10月。Android逐渐扩展到平板电脑及其他领域上，" +
            "如电视、数码相机、游戏机等。2011年第一季度，Android在全球的市场份额首次超过塞班系统，跃居全球第一。" +
            " 2013年的第四季度，Android平台手机的全球市场份额已经达到78.1%。 " +
            "2013年09月24日谷歌开发的操作系统Android在迎来了5岁生日，全世界采用这款系统的设备数量已经达到10亿台。";
    SpannableString msp = null;
//        String[] sy1 = {"Android", "安卓"};
    private List<String> sy = null;
    private EditText editText;
    private Button buttonAdd;
    private Button button;
    private TextView tvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initView();
        //加载数据
        initData();
        //检索关键字
        initListener();
    }

    private void initListener() {
        buttonAdd.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    private void initData() {
        tv.setText(string);
    }

    private void initView() {
        editText = (EditText) findViewById(R.id.ed_text);
        buttonAdd = (Button) findViewById(R.id.btn_add);
        button = (Button) findViewById(R.id.btn_check);
        tvAdd = (TextView) findViewById(R.id.tv_add);
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        String key = editText.getText().toString().trim();
        switch (v.getId()) {
            case R.id.btn_add:
                if (TextUtils.isEmpty(key)) {
                    Toast.makeText(MainActivity.this, "请先输入关键字！", Toast.LENGTH_SHORT).show();
                } else {
                    sy = new ArrayList<>();
                    sy.add(key);
                    for (int i = 0; i < sy.size(); i++) {
                        tvAdd.setText(sy.get(i));
                    }
                }
                break;

            case R.id.btn_check:
                if (sy == null) {
                    Toast.makeText(MainActivity.this, "请先输入关键字！", Toast.LENGTH_SHORT).show();
                } else {
                    msp = KeywordUtil.matcherSearchTitle(Color.BLUE, string, sy);
                    System.out.println("=====>   " + sy);
                    tv.setText(msp);
                }
                break;

            default:
                break;
        }
    }
}
