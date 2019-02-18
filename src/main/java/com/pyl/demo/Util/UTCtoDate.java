package com.pyl.demo.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UTCtoDate {

    private final static Logger logger = LoggerFactory.getLogger(UTCtoDate.class);

    public static Date toDate(String date) throws ParseException {
        date = date.replace("Z", " UTC");
        logger.info("date:"+date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date d = format.parse(date);
        logger.info("d:"+d);
        return d;
    }

    public static Date GMTtoDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z");
        Date date1 = sdf.parse(date);
        return  date1;
    }

    /**
     * @param datdString Thu May 18 2017 00:00:00 GMT+0800 (中国标准时间)
     * @return 年月日;
     */
    public static String parseTime(String datdString) {
        datdString = datdString.replace("GMT", "").replaceAll("\\(.*\\)", "");
        //将字符串转化为date类型，格式2016-10-12
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
        Date dateTrans = null;
        try {
            dateTrans = format.parse(datdString);
            return new SimpleDateFormat("yyyy-MM-dd").format(dateTrans).replace("-","/");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return datdString;

    }

}
