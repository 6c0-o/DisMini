package fr.sixczero.util;

public class timeUtils {

    private static final long MORNING_END = 6000;
    private static final long DAY_END = 12000;
    private static final long EVENING_END = 18000;
    private static final long NIGHT_END = 24000;

    public static timeType getTimeOfDay(long tick) {
        long time = tick % NIGHT_END;

        if (time < MORNING_END) {
            return timeType.MORNING;
        } else if (time < DAY_END) {
            return timeType.DAY;
        } else if (time < EVENING_END) {
            return timeType.EVENING;
        } else {
            return timeType.NIGHT;
        }
    }
}