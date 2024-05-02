import java.util.*;
public class jobscheduling1 {
    static Scanner sc = new Scanner(System.in);
    static class Job {
        int slot;
        int profit;
        int id;
        Job(int id, int d, int p) {
            this.id = id;
            this.profit = p;
            this.slot = d;
        }
    }
   
    public static void sequencing() {
        System.out.println();
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        ArrayList<Job> jobs = new ArrayList<>();
        System.out.println("Enter each Job's Slot & profit : ");
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(i, sc.nextInt(), sc.nextInt()));
        }
        System.out.println("\nJobs : ");
        for (Job currJob : jobs) {
            System.out.println("J"+currJob.id+"  "+currJob.slot+"  "+currJob.profit);
        }
        Collections.sort(jobs, (a, b) -> b.profit-a.profit);
        System.out.print("\nJobs Scheduling Order : ");
        int prof =0;
        for (int i = 0; i < jobs.size(); i++) {
            int maxId = -1;
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < jobs.size(); j++) {
                Job curr = jobs.get(j);
                if(curr.slot == i && curr.profit > maxProfit) {
                    maxProfit = curr.profit;
                    maxId = curr.id;
                }
            }
            if(maxId != -1) {
                System.out.print("J"+maxId+"  ");
                prof = maxProfit+prof;

                
            }
        }
        System.out.println("Total Profit: "+prof);
    }
    public static void main(String[] args) {
        // selection();
        sequencing();
    }
}