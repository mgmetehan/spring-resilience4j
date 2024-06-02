package com.mgmetehan.springresilience4j.retry.service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class MyService {

    @Retry(name = "customRetry", fallbackMethod = "fallbackMethod")
    public String doSomething() throws IOException {
        if (someTemporaryErrorCondition()) {
            log.info("Temporary error occurred");
            throw new IOException("Temporary error occurred");
        }
        return "Success";
    }

    public String fallbackMethod(IOException e) {
        log.info("Fallback response due to " + e.getMessage());
        return "Fallback response due to " + e.getMessage();
    }

    private boolean someTemporaryErrorCondition() {
        return true;
    }
}
