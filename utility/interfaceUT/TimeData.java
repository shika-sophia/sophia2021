package utility.interfaceUT;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeData {
    protected LocalDate startDay;
    protected LocalDateTime startTime;
    protected LocalDateTime lastTime;
    protected Duration costTime;
    protected String timeResult;

    public TimeData(
        LocalDate startDay,
        LocalDateTime startTime,
        LocalDateTime lastTime,
        Duration costTime,
        String timeResult){

        this.startDay = startDay;
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.costTime = costTime;
        this.timeResult = timeResult;
    }

    //====== getter ======
    public LocalDate getStartDay() {
        return startDay;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public Duration getCostTime() {
        return costTime;
    }

    public String getTimeResult() {
        return timeResult;
    }
}//class TimeData



