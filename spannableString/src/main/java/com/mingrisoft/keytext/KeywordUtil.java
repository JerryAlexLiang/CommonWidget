package com.mingrisoft.keytext;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KeywordUtil {

    /**
     * 多个关键字高亮变色
     *
     * @param color   变化的色值
     * @param text    文字
     * @param keyword 文字中的关键字数组
     * @return 处理后的文本内容
     */
//    public static SpannableString matcherSearchTitle(int color, String text,
//                                                     String[] keyword) {
//        //转换要处理的文本内容为SpannableString对象
//        SpannableString s = new SpannableString(text);
//        //循环关键字
//        for (int i = 0; i < keyword.length; i++) {
//            //获取匹配规则
//            Pattern p = Pattern.compile(keyword[i]);
//            //进行匹配返回Matcher对象
//            Matcher m = p.matcher(s);
//            //循环匹配结果匹配成功
//            while (m.find()) {
//                //获取匹配开始位置
//                int start = m.start();
//                //获取匹配结束位置
//                int end = m.end();
//                //设置字符中相应位置变色
//                s.setSpan(new ForegroundColorSpan(color), start, end,
//                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
//        return s;
//    }
    public static SpannableString matcherSearchTitle(int color, String text,
                                                     List<String> keyword) {
        //转换要处理的文本内容为SpannableString对象
        SpannableString s = new SpannableString(text);
        //循环关键字
        for (int i = 0; i < keyword.size(); i++) {
            //获取匹配规则
            Pattern p = Pattern.compile(keyword.get(i));
            //进行匹配返回Matcher对象
            Matcher m = p.matcher(s);
            //循环匹配结果匹配成功
            while (m.find()) {
                //获取匹配开始位置
                int start = m.start();
                //获取匹配结束位置
                int end = m.end();
                //设置字符中相应位置变色
                s.setSpan(new ForegroundColorSpan(color), start, end,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return s;
    }
}
