package ru.netology;

public class TelephoneOperator extends Thread {
    private static final int WORK_TIME_WITH_ONE_CALL = 2000;
    private CallCenter callCenter;

    public TelephoneOperator(ThreadGroup group, String name, CallCenter callCenter) {
        super(group, name);
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        while (true)
            try {
                Call call = callCenter.get();
                if (call != null) System.out.println(Thread.currentThread().getName() + " взял в работу звонок!");
                Thread.sleep(WORK_TIME_WITH_ONE_CALL);
            } catch (InterruptedException ex) {
                System.out.println("У " + Thread.currentThread().getName() + " закончен рабочий день!");
                return;
            }
    }
}

