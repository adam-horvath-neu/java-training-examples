package hu.training.thread.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A little utility class encapsulating a static {@link DateTimeFormatter}
 * instance and providing a convenience method to represent an instance of
 * {@link LocalDateTime} as a well-formatted {@link String}.
 *
 * Notice how the class is made final and the constructor is private.
 */
public final class FormatUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;

    private FormatUtils() {}

    public static String date(final LocalDateTime date) {
        return formatter.format(date);
    }
}
