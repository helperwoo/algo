import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Node[] tree = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char cur = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[cur - 'A'] == null) {
                tree[cur - 'A'] = new Node(cur);
            }

            if (left != '.') {
                tree[cur - 'A'].left = tree[left - 'A'] = new Node(left);
            }


            if (right != '.') {
                tree[cur - 'A'].right = tree[right - 'A'] = new Node(right);
            }
        }

        bw.write(preorder(tree[0], "") + "\n");
        bw.write(inorder(tree[0], "") + "\n");
        bw.write(postorder(tree[0], ""));

        bw.flush();
        bw.close();
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    // 전위 순회
    public static String preorder(Node node, String order) {
        if (node != null) {
            order += node.value;
            order = preorder(node.left, order);
            order = preorder(node.right, order);
        }
        return order;
    }

    // 중위 순회
    public static String inorder(Node node, String order) {
        if (node != null) {
            order = inorder(node.left, order);
            order += node.value;
            order = inorder(node.right, order);
        }
        return order;
    }

    // 후위 순회
    public static String postorder(Node node, String order) {
        if (node != null) {
            order = postorder(node.left, order);
            order = postorder(node.right, order);
            order += node.value;
        }
        return order;
    }
}

