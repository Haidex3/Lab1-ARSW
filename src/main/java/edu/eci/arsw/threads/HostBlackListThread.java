package edu.eci.arsw.threads;

import java.util.LinkedList;
import java.util.List;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class HostBlackListThread extends Thread {
    public int startIdx;
    public int endIdx;
    private final String ip;
    private final HostBlacklistsDataSourceFacade skds;
    private final List<Integer> localOccurrences;

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
