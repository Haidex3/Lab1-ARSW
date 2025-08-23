/*
 * File: CountThreadsMain.java
 * Author: Haider Rodriguez and Emily Noreña (original author: hcadavid)
 * Date: 22-Aug-2025
 * Description: Main class to demonstrate the use of multiple CountThread instances.
 *              Creates three threads, each counting a specific numeric range,
 *              and starts them concurrently to show multi-threaded execution.
 */
package edu.eci.arsw.threads;

/*
 * CountThreadsMain class.
 * Responsible for creating and starting multiple CountThread instances.
 */
public class CountThreadsMain {

    /*
     * Main method to execute the program.
     * @param a Array of command-line arguments (not used in this program).
     * 
     * Creates three threads with different ranges:
     * - Thread 1: counts from 0 to 99
     * - Thread 2: counts from 99 to 199
     * - Thread 3: counts from 200 to 299
     * 
     * Starts all threads concurrently using start().
     */    
    public static void main(String a[]){
        Thread t1 = new Thread(new CountThread(0,99));
        Thread t2 = new Thread(new CountThread(99,199));
        Thread t3 = new Thread(new CountThread(200,299));

        t1.start();
        t2.start();
        t3.start();
        
    }
    
}
