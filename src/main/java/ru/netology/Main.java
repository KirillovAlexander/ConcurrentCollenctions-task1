package ru.netology;

public class Main {
    private static final int WORK_TIME = 20000;
    public static void main(String[] args) {

        CallCenter callCenter = new CallCenter();
        ThreadGroup threadGroup = new ThreadGroup("Operators");

        Thread telephoneSwitch = new TelephoneSwitch("АТС", callCenter);
        Thread operator1 = new TelephoneOperator(threadGroup, "Оператор 1", callCenter);
        Thread operator2 = new TelephoneOperator(threadGroup, "Оператор 2", callCenter);
        Thread operator3 = new TelephoneOperator(threadGroup, "Оператор 3", callCenter);

        telephoneSwitch.start();
        operator1.start();
        operator2.start();
        operator3.start();

        try {
            Thread.sleep(WORK_TIME);
            threadGroup.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
