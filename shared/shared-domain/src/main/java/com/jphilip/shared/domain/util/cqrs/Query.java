package com.jphilip.shared.domain.util.cqrs;

public interface Query<I,O>{
    O execute(I query);
}