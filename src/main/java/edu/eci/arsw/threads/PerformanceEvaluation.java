/*
 * File: PerformanceEvaluation.java
 * Author: Haider Rodriguez and Emily Noreña
 * Date: 23-Aug-2025
 * Description: Performace evaluation using different thread pool sizes
 */
package edu.eci.arsw.threads;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import edu.eci.arsw.blacklistvalidator.HostBlackListsValidator;

/*
 * Class that evaluates the performance of validating IP addresses
 * against blacklists using different thread pool configurations.
 */

public class PerformanceEvaluation {

    public static final HostBlackListsValidator hblv=new HostBlackListsValidator();

    private static final List<String> ipList = List.of(
        "202.24.34.55", "8.8.8.8", "1.1.1.1", "93.184.216.34", "198.41.0.4", "208.67.222.222",
        "151.101.1.69", "104.16.249.249", "185.199.108.153", "172.217.3.110", "203.0.113.1",
        "192.0.2.1", "192.88.99.1", "198.51.100.1", "192.0.43.10", "129.6.15.28", "17.253.144.10"
    );

    /*
     * Main method that runs performance tests with different thread pool sizes.
     * @param args command-line arguments.
     * @throws InterruptedException if thread execution is interrupted.
     * @throws ExecutionException if an error occurs during task execution.
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors(); //Núcleos

        run("Un solo hilo", 1);
        run("Tantos hilos como núcleos (" + cores + ")", cores);
        run("Doble de núcleos (" + (cores * 2) + ")", cores * 2);
        run("50 hilos", 50);
        run("100 hilos", 100);
    }

    /*
     * Executes a validation test with a specific number of threads.
     *
     * @param label descriptive label of the test.
     * @param threadCount number of threads in the pool.
     * @throws InterruptedException if thread execution is interrupted.
     * @throws ExecutionException if an error occurs in a task.
     */

    private static void run(String label, int threadCount) throws InterruptedException, ExecutionException {
        System.out.println("\n");
        System.out.println(label);
        System.out.println("Número de hilos: " + threadCount);

        ExecutorService executor = Executors.newFixedThreadPool(threadCount); //Pool
        List<Future<String>> futures = new ArrayList<>();


        for (String ip : ipList) { //Enviar tareas al pool
            futures.add(executor.submit(() -> validateIP(ip)));
        }

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

    }

    /*
     * Validates an IP address by checking if it appears in blacklists.
     *
     * @param ip the IP address to validate.
     * @return a string with the validation result.
     */

    private static String validateIP(String ip) {
    try {
        InetAddress address = InetAddress.getByName(ip);

        List<Integer> blacklists = hblv.checkHost(ip, 3);
        //return ip + " " + blacklists;

        return "";

    } catch (IOException e) {
        return ip + "Error: " + e.getMessage();
    }
}

}