/*
 * File: CountThread.java
 * Author: Haider Rodriguez and Emily Noreña(original author: hcadavid)
 * Date: 22-Aug-2025
 * Description: Thread class that counts numbers within a specified range [A, B]
 *              and prints each number to the console along with the thread's name.
 *              Can be used to demonstrate multi-threading or concurrent execution.
 */
package edu.eci.arsw.threads;
/*
 * CountThread extends Thread to perform counting in a separate thread.
 * Each thread prints numbers from A to B inclusive.
 */
public class CountThread extends Thread{
    private final int A;
    private final int B;

    /*
     * Constructor to initialize the counting range.
     * @param A Start of the range (inclusive)
     * @param B End of the range (inclusive)
     */
    public CountThread(int A, int B){
        this.A = A;
        this.B = B;
    }

    /*
     * Override the run() method from Thread.
     * Counts from A to B inclusive and prints each value with the thread's name.
     */
    @Override
    public void run() {
        for (int i=A; i<= B; i++){
            System.out.println("[i" +getName() + "]" + i);
        }
    }
}
