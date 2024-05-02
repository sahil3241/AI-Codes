import java.util.*;
public class JobSequencing {
    static Scanner sc = new Scanner(System.in);
    static class Job {
        int id;
        int deadLine;
        int profit;
        Job(int id, int d, int p) {
            this.id = id;
            deadLine = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.print("Enter the no. of Jobs : ");
        int n = sc.nextInt();
        ArrayList<Job> jobs = new ArrayList<>();
        System.out.println("\nEnter Job's Deadline and Profit : ");
        for(int i = 0; i < n; i++) {
            int dead = sc.nextInt();
            int prof = sc.nextInt();
            jobs.add(new Job(i, dead, prof));
            System.out.println();
        }
        System.out.println("Jobs : ");
        for(int i = 0; i<jobs.size(); i++) {
            Job elem = jobs.get(i);
            System.out.println("J"+elem.id+"  "+elem.deadLine+"  "+elem.profit);
        }
        
        Collections.sort(jobs, (a,b) -> b.profit-a.profit);

        ArrayList<Integer> seq = new ArrayList<>();

        for(int i=0; i<jobs.size();i++)
        {
            seq.add(-1);
        }
        // int x=1;
        for(int i = 0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            
            for(int j=1; j<jobs.size();j++)
            {
                if (j==curr.deadLine && (seq.get(j)==-1 || curr.profit<seq.get(j)) ) {
                    seq.remove(j);
                    seq.add(j, curr.id);
                    // x++;
                }
            }
        }
    
        System.out.print("\nNo. of  Jobs Sequenced : "+seq.size()+"\nThe Jobs Sequenced are : ");
        int profit = 0;
        
        for(int i = 0; i<jobs.size(); i++) {
            if (seq.get(i)!=-1) {
                Job curr = jobs.get(seq.get(i));
                profit += curr.profit;
                System.out.print("J"+curr.id+"  ");
                
            }
        }
        System.out.println("\nTotal Profit : "+profit);
    }
}