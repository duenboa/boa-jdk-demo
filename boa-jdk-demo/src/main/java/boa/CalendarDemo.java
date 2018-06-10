package boa;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试JDK原生的Calender类
 *
 * @author DuenBoa
 * @date 2018/6/10
 */
public class CalendarDemo {

    enum PeriodEnum {
        DAY("2") {
            @Override
            boolean isSamePeriod(Calendar a, Calendar b) {
                return a.get(Calendar.YEAR) == b.get(Calendar.YEAR)
                        && a.get(Calendar.MONTH) == b.get(Calendar.MONTH)
                        && a.get(Calendar.DAY_OF_YEAR) == b.get(Calendar.DAY_OF_YEAR);
            }
        },
        WEEK("1") {
            @Override
            boolean isSamePeriod(Calendar a, Calendar b) {
                return a.get(Calendar.YEAR) == b.get(Calendar.YEAR)
                        && a.get(Calendar.WEEK_OF_YEAR) == b.get(Calendar.WEEK_OF_YEAR);
            }
        },
        MONTH("0") {
            @Override
            boolean isSamePeriod(Calendar a, Calendar b) {
                return a.get(Calendar.YEAR) == b.get(Calendar.YEAR)
                        && a.get(Calendar.MONTH) == b.get(Calendar.WEEK_OF_YEAR);
            }
        };


        private String period;
        private static Map<String, PeriodEnum> dataMap = new HashMap<>();

        PeriodEnum(String period) {
            this.period = period;
        }

        static {
            for (PeriodEnum e : PeriodEnum.values()) {
                dataMap.put(e.period, e);
            }
        }

        public static PeriodEnum ofPeriod(String period) {
            return dataMap.get(period);
        }

        abstract boolean isSamePeriod(Calendar a, Calendar b);

        public boolean isSamePeriodAndDesc(String dataAStr, String dataBStr, String dataPattern) {
            Calendar c1 = DateUtils.String2Calendar(dataAStr, dataPattern);
            Calendar c2 = DateUtils.String2Calendar(dataBStr, dataPattern);
            return isSamePeriod(c1, c2) && c1 != null && c1.compareTo(c2) >= 0;
        }

    }


    public static void main(String[] args) {
        String p = "yyyy-MM-dd";
        String period = "1";

        String a = "2018-06-08";
        String b = "2018-06-11";
        PeriodEnum periodEnum = PeriodEnum.ofPeriod(period);
        System.out.println(periodEnum.isSamePeriodAndDesc(a, b, p));     //false

        a = "2018-06-10";
        b = "2018-06-11";
        periodEnum = PeriodEnum.ofPeriod(period);
        System.out.println(periodEnum.isSamePeriodAndDesc(a, b, p));     //false

        a = "2018-06-11";
        b = "2018-06-11";
        periodEnum = PeriodEnum.ofPeriod(period);
        System.out.println(periodEnum.isSamePeriodAndDesc(a, b, p)); //true

        a = "2018-06-12";
        b = "2018-06-11";
        periodEnum = PeriodEnum.ofPeriod(period);
        System.out.println(periodEnum.isSamePeriodAndDesc(a, b, p));  //true

        a = "2018-06-12";
        b = "2018-06-11";
        periodEnum = PeriodEnum.ofPeriod(period);
        System.out.println(periodEnum.isSamePeriodAndDesc(a, b, p));   //true

        a = "2018-06-19";
        b = "2018-06-11";
        periodEnum = PeriodEnum.ofPeriod(period);
        System.out.println(periodEnum.isSamePeriodAndDesc(a, b, p));    //false
    }


}

    