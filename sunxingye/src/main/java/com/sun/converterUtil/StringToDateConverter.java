package com.sun.converterUtil;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: Sun Xingye
 * @Date: 8:49 2020/7/27
 * @Version: 1.0
 */
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        System.out.println(s);
        if (s != null && !s.equals("")) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("生日不能为空");

    }
}
