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

    public TimeData() { }

    public TimeData(
        LocalDate startDay,LocalDateTime startTime) {
        this.startDay = startDay;
        this.startTime = startTime;
    }

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

    //====== getter, setter ======
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

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    public void setCostTime(Duration costTime) {
        this.costTime = costTime;
    }

    public void setTimeResult(String timeResult) {
        this.timeResult = timeResult;
    }
}//class TimeData



