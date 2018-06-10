package boa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日期工具
 *
 * @author DuenBoa
 * @date 2018/6/10
 */
public abstract class DateUtils {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtils.class);

    private static final ConcurrentHashMap<String, SimpleDateFormat> formatFactory = new ConcurrentHashMap<>(16);

    private static SimpleDateFormat getDateFormat(String pattern) {
        Assert.hasText(pattern, "invalid param [pattern]");

        SimpleDateFormat simpleDateFormat = formatFactory.get(pattern);
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(pattern);
            formatFactory.putIfAbsent(pattern, simpleDateFormat);
            return simpleDateFormat;
        }
        return simpleDateFormat;
    }


    public static Calendar String2Calendar(String dataStr, String pattern) {
        SimpleDateFormat fmt = getDateFormat(pattern);
        try {
            Date d = fmt.parse(dataStr);
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            return c;
        } catch (ParseException e) {
            String msg = String.format("invalid data '%s' and pattern '%s'", dataStr, pattern);
            LOG.warn(msg);
            throw new IllegalArgumentException(msg);
        }
    }


}

    