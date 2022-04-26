package com.example.demo.utilities;

public class TimeToStringUtil {
    public String convert(int time) {

        if (time < 0) {
            throw new IllegalArgumentException("cannot convert for negative int: " + time);
        }

        if (time < 5 || time >= 22) {
            return "night";
        } else if ( time < 12) {
            return "morning";
        } else if ( time < 16) {
            return "afternoon";
        }else if ( time < 22) {
            return "evening";
        }
        return "not implemented";
    }
}
