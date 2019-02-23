package com.github.witjem;

import com.github.witjem.teng.Assert;
import com.github.witjem.teng.AssertionsError;
import org.junit.Test;

public class AssertTest {

    @Test
    public void happyPassTestAssertThrows() {
        Assert.assertThrows(
            RuntimeException.class, () -> {
                throw new RuntimeException();
            }
        );
    }

    @Test(expected = AssertionError.class)
    public void failPassTestAssertThrows() {
        Assert.assertThrows(
            RuntimeException.class, () -> {
                throw new Exception();
            }
        );
    }

    @Test
    public void happyPassTestAssertThrowsWithMessage() {
        Assert.assertThrows(
            RuntimeException.class, "some exception message", () -> {
                throw new RuntimeException("some exception message");
            }
        );
    }

    @Test(expected = AssertionError.class)
    public void failPassTestAssertThrowsWithMessage() {
        Assert.assertThrows(
            RuntimeException.class, "not actual exception message", () -> {
                throw new RuntimeException("some exception message");
            }
        );
    }

    @Test
    public void happyPassTestAssertAll() {
        Assert.assertAll(
            () -> {
            },
            () -> {
            }
        );
    }

    @Test(expected = AssertionsError.class)
    public void failPassTestAssertAll() {
        Assert.assertAll(
            () -> {
                throw new RuntimeException();
            },
            () -> {
                throw new Exception();
            }
        );
    }

    @Test
    public void happyPassTestAssertEq() {
        Assert.assertEq("some", "some");
    }

    @Test
    public void happyPassTestAssertEqIfActualAndExpectedIsNull() {
        Assert.assertEq(null, null);
    }

    @Test(expected = AssertionError.class)
    public void failPassTestAssertEqIfActualIsNull() {
        Assert.assertEq(null, "some");
    }

    @Test(expected = AssertionError.class)
    public void failPassTestAssertEqIfExpectedIsNull() {
        Assert.assertEq("actual", null);
    }

    @Test(expected = AssertionError.class)
    public void failPassTestAssertEq() {
        Assert.assertEq("some", "some1");
    }

    @Test
    public void testExample() {
        Assert.assertAll(
            () -> Assert.assertEq("Should be equal", "42", "42"),
            () -> Assert.assertEq("42", "42"),
            () -> Assert.assertThrows(RuntimeException.class, () -> {
                throw new RuntimeException();
            }),
            () -> Assert.assertThrows(RuntimeException.class, "error message", () -> {
                throw new RuntimeException("error message");
            })
        );
    }
}
