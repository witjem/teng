package com.github.witjem.teng;

import java.util.ArrayList;
import java.util.List;

public final class Assert {

    public static void assertThrows(Class<? extends Throwable> clazz, Executable exec) {
        try {
            exec.execute();
            throw new AssertionError("error");
        } catch (Throwable e) {
            if (!e.getClass().equals(clazz)) {
                throwAssertionError(e.getClass().getName(), clazz.getName());
            }
        }
    }

    public static void assertThrows(Class<? extends Throwable> clazz, String expectErrorMessage, Executable exec) {
        try {
            exec.execute();
            throw new AssertionError("error");
        } catch (Throwable e) {
            if (!e.getClass().equals(clazz)) {
                throwAssertionError(e.getClass().getName(), clazz.getName());
            }
            assertEq("Incorrect error message", e.getMessage(), expectErrorMessage);
        }
    }

    public static void assertAll(Executable... execs) {
        final List<Throwable> errors = new ArrayList<>();
        for (Executable exec : execs) {
            try {
                exec.execute();
            } catch (Throwable e) {
                errors.add(e);
            }
        }
        if (errors.isEmpty()) {
            return;
        }

        throw new AssertionsError(errors);
    }

    public static void assertEq(String reason, Object actual, Object expected) {
        if (actual == null) {
            if (expected == null) {
                return;
            }
            throwAssertionError(reason, "null", expected);
        }

        if (actual.equals(expected)) {
            return;
        }

        throwAssertionError(reason, actual, expected);
    }

    public static void assertEq(Object actual, Object expected) {
        assertEq("", actual, expected);
    }

        private static void throwAssertionError(String reason, Object actual, Object expected) {
        throw new AssertionError(String.format("%s\nExpected: %s\nActual:   %s", reason, expected, actual));
    }

    private static void throwAssertionError(String actual, String expected) {
        throwAssertionError("", actual, expected);
    }
}
