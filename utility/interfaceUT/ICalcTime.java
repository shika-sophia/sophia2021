package utility.interfaceUT;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ICalcTime {
    TimeData timeData = new TimeData();

    //====== get startTime, lastTime / calc costTime ======
    public default TimeData calcTime(LocalDateTime startTime) {
        LocalDateTime lastTime;
        LocalDate startDay;
        Duration costTime;

        LocalDateTime ldtNow = LocalDateTime.now();


        if(startTime == null) {
            startTime = ldtNow;
            startDay = LocalDate.of(
                ldtNow.getYear(), ldtNow.getMonthValue(), ldtNow.getDayOfMonth());

            timeData.setStartTime(startTime);
            timeData.setStartDay(startDay);
            return timeData;

        } else {
            lastTime = ldtNow;
            costTime = Duration.between(startTime, lastTime);
        }

        String timeResult = buildTimeResult(startTime, lastTime, costTime);

        timeData.setLastTime(lastTime);
        timeData.setCostTime(costTime);
        timeData.setTimeResult(timeResult);

        return timeData;
    }//calcTime()

    public default String buildTimeResult(
        LocalDateTime startTime, LocalDateTime lastTime, Duration costTime) {
        var bld =new StringBuilder(64);

        String startTimeStr = formatTime(startTime);
        String lastTimeStr = formatTime(lastTime);
        bld.append("\n開始時刻 ").append(startTimeStr).append("\n");
        bld.append("終了時刻 ").append(lastTimeStr).append("\n");
        bld.append("所要時間 ").append(costTime.toMinutes()).append(" 分").append("\n");

        return bld.toString();
    }//buildTimeResult()

    //====== format startTime, lastTime ======
    public default String formatTime(LocalDateTime ldt) {
        String ldtStr = ldt.format(
            DateTimeFormatter.ofPattern("HH:mm"));

        return ldtStr;
    }//formatTime()
}//ICalcTime
