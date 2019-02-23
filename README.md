# Teng

Teng is lightweight library that can be used for testing your code.

### Example

```java
@Test
public void some_test() {
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
```
