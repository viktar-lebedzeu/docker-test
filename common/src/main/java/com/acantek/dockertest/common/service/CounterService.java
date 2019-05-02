package com.acantek.dockertest.common.service;

import lombok.Synchronized;
import org.springframework.stereotype.Service;

/**
 * Count service
 * @author Viktar Lebedzeu
 */
@Service
public class CounterService {
    /** Read lock object */
    private final Object readLock = new Object();
    /** Static counter */
    private Integer counter = 0;

    @Synchronized("readLock")
    public Integer getCounter() {
        return counter;
    }

    @Synchronized
    public Integer increment() {
        return ++counter;
    }

    @Synchronized
    public Integer decrement() {
        return --counter;
    }

    @Synchronized
    public void reset() {
        counter = 0;
    }
}
