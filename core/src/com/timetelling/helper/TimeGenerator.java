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

}
