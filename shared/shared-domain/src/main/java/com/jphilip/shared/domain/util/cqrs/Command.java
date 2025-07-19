package com.jphilip.shared.domain.util.cqrs;

public interface Command<I,O>{
    O execute(I command);
}
