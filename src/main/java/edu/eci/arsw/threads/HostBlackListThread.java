package edu.eci.arsw.threads;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;

public class HostBlackListThread extends Thread {
    private int startIdx;
    private int endIdx;
    private String ip;
    private HostBlacklistsDataSourceFacade skds;
    private List<Integer> localOccurrences;

    public HostBlackListThread(int startIdx, int endIdx, String ip, HostBlacklistsDataSourceFacade skds) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.ip = ip;
        this.skds = skds;
        this.localOccurrences = new LinkedList<>();
    }

    @Override
    public void run() {
        for (int i = startIdx; i < endIdx; i++) {
            if (skds.isInBlackListServer(i, ip)) {
                localOccurrences.add(i);
            }
        }
    }

    public List<Integer> getOccurrences() {
        return localOccurrences;
    }
}
