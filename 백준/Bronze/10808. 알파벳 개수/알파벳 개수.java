import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();

		int[] arr = new int[26];
		for (int i=0; i<arr.length; i++) {
			for (char ch : S.toCharArray()) {
				if ((int) ch == i + 97) {
					arr[i] += 1;
				}
			}
			bw.write(arr[i] + " ");
		}

		bw.flush();
		bw.close();
	}
}