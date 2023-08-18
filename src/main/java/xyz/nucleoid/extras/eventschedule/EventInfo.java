package xyz.nucleoid.extras.eventschedule;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class EventInfo {
    @SerializedName("name")
    public String name;
    @SerializedName("date")
    public long date;
    @SerializedName("duration")
    public int duration = 60 * 60;

    public EventInfo(String name, long date, int duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public EventInfo(String name, long date) {
        this.name = name;
        this.date = date;
    }

    public String name() {
        return this.name;
    }
}
