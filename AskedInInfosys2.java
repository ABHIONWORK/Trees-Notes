import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class AskedInInfosys2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int arr[] = new int[k];
        
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            hs.add(arr[i]); // Moved HashSet population here for performance
        }
        int n = sc.nextInt();
        
        ArrayList<Integer> valid = new ArrayList<>();
        
        int unique = 1;
        valid.add(1);
        int j = 2;

        while (unique != n) {
            // Pass the HashSet directly to avoid recreating it
            if (checkpossible(hs, j)) {
                valid.add(j);
                unique++;
            }
            j++; // Simplified incrementing logic
        }

        System.out.println(valid.get(n - 1));
    }

    public static boolean checkpossible(HashSet<Integer> hs, int val) {
        ArrayList<Integer> factors = new ArrayList<>();

        // Fixed logic: val % 2 == 0
        while (val % 2 == 0) {
            factors.add(2);
            val = val / 2;
        }
        
        for (int i = 3; i * i <= val; i += 2) {
            while (val % i == 0) {
                factors.add(i);
                val /= i;
            }
        }
        
        // Added missing logic: catch remaining prime factor > sqrt(val)
        if (val > 1) {
            factors.add(val);
        }

        int sz = factors.size();
        if (sz % 2 != 0) {
            return false;
        }

        // Replaced enhanced for-loop with a traditional for-loop
        for (int i = 0; i < factors.size(); i++) {
            if (!hs.contains(factors.get(i))) {
                return false;
            }
        }

        return true;
    }
}