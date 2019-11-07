package com.wx.retry.scheduler.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CronUtil {
    public static final String CRON_FORMATTER = "ss mm HH dd MM ? yyyy";
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CRON_FORMATTER);

    public static String dateToCron(Date date){
        return simpleDateFormat.format(date);
    }
    public static boolean isOverTime(String cron) {
        try{
            Date startTime = simpleDateFormat.parse(cron);
            return startTime.before(new Date());
        }catch (Exception e){
        e.printStackTrace();
        return false;
        }
    }
}
