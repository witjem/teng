# Teng
[ ![Download](https://api.bintray.com/packages/witjem/teng/teng/images/download.svg?version=0.9) ](https://bintray.com/witjem/teng/teng/0.9/link)

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
