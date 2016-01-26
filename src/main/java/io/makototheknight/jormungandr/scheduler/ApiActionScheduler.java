package io.makototheknight.jormungandr.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiActionScheduler {

    @Scheduled(fixedRate = 5000)
    public void printHello() {
        System.out.println("Hello");
    }

}
