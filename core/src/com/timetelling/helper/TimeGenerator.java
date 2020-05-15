package com.timetelling.helper;

import com.timetelling.gameobjects.Time;

public class TimeGenerator {

    public static int level = 1;

    public static Time generateTime() {
        if (level==1) return new Time((int)(Math.random()*12+1), 0);
        else if (level==2) return new Time((int)(Math.random()*12+1), (int)(Math.random()*4)*15);
        else if (level==3) return new Time((int)(Math.random()*12+1), (int)(Math.random()*12)*5);
        else return new Time((int)(Math.random()*12+1), (int)(Math.random()*60));
    }

    public static Time[] generateTimes(int num) {
        Time[] times = new Time[num];
        times[0] = generateTime();
        for (int i = 1; i < num; i++) {
            Time temp;
            do {
                temp = generateTime();
            } while(contains(times, temp, i));
            times[i] = temp;
        }
        return times;
    }

    private static boolean contains(Time[] times, Time time, int stop) {
        for (int i = 0; i < stop; i++) {
            if (times[i].equals(time)) return true;
        }
        return false;
    }

}
