import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        
        for (int i=0; i<arr.length; i++) {
            if (i==0 || i==1) {
                System.out.print(1 - Integer.parseInt(arr[i]) + " ");
            } else if (i==5) {
                System.out.print(8 - Integer.parseInt(arr[i]));
            } else {
                System.out.print(2 - Integer.parseInt(arr[i]) + " ");
            }
        }
    }
}