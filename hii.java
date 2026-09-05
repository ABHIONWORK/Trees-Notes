import java.util.HashMap;
import java.util.Scanner;
public class hii {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer , Integer> hm =new HashMap<>();
        for(int num : arr){
            hm.put(num , hm.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for(int key : hm.keySet()){
            if(hm.get(key)  == 2){
                res+=key;
            }
        }
        System.out.println(res);
    }
}