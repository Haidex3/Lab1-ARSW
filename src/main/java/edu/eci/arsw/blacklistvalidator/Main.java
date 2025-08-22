/*
 * File: Main.java
 * Author: Haider Rodriguez
 * Date: 22-Aug-2025
 * Description: Main class of the Blacklist Validator program.
 *              Checks whether a host IP (user-specified) appears 
 *              in blacklists, using a threshold of 3 occurrences, and prints
 *              the results to the console.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

//import edu.eci.arsw.threads.CountThread;

/*
 * Main class of the program.
 * Responsible for initializing the HostBlackListsValidator and checking
 * a host IP against blacklists.
 */
public class Main {

    /*
     * Main method to execute the program.
     * @param a Array of command-line arguments (not used in this program).
     */
    public static void main(String a[]){
        HostBlackListsValidator hblv=new HostBlackListsValidator();
        List<Integer> blackListOccurrences = hblv.checkHost("200.24.34.55", 3);

        System.out.println("The host was found in the following blacklists:" + blackListOccurrences);
        
    }
    
}