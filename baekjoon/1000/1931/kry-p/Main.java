import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            int[] currentMeeting = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meetings[i] = new Meeting(currentMeeting[0], currentMeeting[1]);
        }
        Arrays.sort(meetings);
        int currentTime = 0, maximumMeetingCount = 0;
        for (int i = 0; i < n; i++) {
            Meeting currentMeeting = meetings[i];
            if (currentMeeting.startTime >= currentTime) {
                maximumMeetingCount += 1;
                currentTime = currentMeeting.endTime;
            }
        }
        System.out.print(maximumMeetingCount);
    }
}

class Meeting implements Comparable<Meeting> {
    public int startTime, endTime;
    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    @Override
    public int compareTo(Meeting o) {
        if (this.endTime != o.endTime) return this.endTime - o.endTime;
        return this.startTime - o.startTime;
    }
}