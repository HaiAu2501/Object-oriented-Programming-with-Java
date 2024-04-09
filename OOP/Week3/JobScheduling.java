import java.util.Arrays;
import java.util.Scanner;

class Job implements Comparable<Job> {
    int deadline, profit;

    Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    public int compareTo(Job other) {
        return other.profit - this.profit;
    }
}

public class JobScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            int deadline = scanner.nextInt();
            int profit = scanner.nextInt();
            jobs[i] = new Job(deadline, profit);
        }

        scanner.close();

        Arrays.sort(jobs);

        int maxDeadline = Arrays.stream(jobs).mapToInt(job -> job.deadline).max().orElse(0);
        boolean[] timeSlots = new boolean[maxDeadline];
        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job.deadline - 1); j >= 0; j--) {
                if (!timeSlots[j]) {
                    timeSlots[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println(totalProfit);
    }
}
