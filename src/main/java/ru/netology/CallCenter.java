package ru.netology;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private Queue<Call> callQueue = new ConcurrentLinkedQueue<>();

    public void add(Call call) {
        callQueue.add(call);
    }

    public Call get() {
        return callQueue.poll();
    }
}
