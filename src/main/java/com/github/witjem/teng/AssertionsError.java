package com.github.witjem.teng;

import java.util.Collection;
import java.util.stream.Collectors;

public class AssertionsError extends AssertionError {
    public AssertionsError(Collection<Throwable> list) {
        super(list.stream()
            .map(Throwable::toString)
            .collect(Collectors.joining("\n________________________________________\n\n"))
        );
    }
}
