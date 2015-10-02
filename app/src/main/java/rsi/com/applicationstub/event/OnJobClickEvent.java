package rsi.com.applicationstub.event;

import rsi.com.applicationstub.domain.Job;

public class OnJobClickEvent {
    public Job job;

    public OnJobClickEvent(Job job) {
        this.job = job;
    }
}
