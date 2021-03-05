package ru.netology;

public class TelephoneSwitch extends Thread {
    private static final int AMOUNT_OF_CALLS = 40;
    private static final int DELAY = 1000;
    private CallCenter callCenter;

    public TelephoneSwitch(String name, CallCenter callCenter) {
        super(name);
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < AMOUNT_OF_CALLS; i++) {
                callCenter.add(new Call());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
