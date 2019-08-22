package com.imooc.sm.global;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {

    public static Date formatDate(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateStr);

        return date;
    }


}
