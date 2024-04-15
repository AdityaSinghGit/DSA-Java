package heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoder {
    // STEP 1 : Create HashMaps
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    // STEP 2 : Create Node
    private class Node implements Comparable<Node> {
        Character data;
        int cost; // Frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    // STEP 3 : Pass the feeder you want to compress.
    public HuffmanCoder(String feeder) throws Exception {
        // STEP 4 : Make Frequency map.
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            if (fmap.containsKey(cc)) {
                int ov = fmap.get(cc);
                ov += 1;
                fmap.put(cc, ov);
            } else {
                fmap.put(cc, 1);
            }
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();
        // STEP 5 : For every key in fmap, create a node.
        // And insert that node in a minHeap.
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        // STEP 6 : Remove min elements from heap and combine.
        while (minHeap.size() > 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);

            newNode.left = first;
            newNode.right = second;

            minHeap.add(newNode);
        }

        Node ft = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft, "");
    }

    // STEP 7 : Put values in encoder and decoder using the heap.
    private void initEncoderDecoder(Node node, String osf) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, osf);
            this.decoder.put(osf, node.data);
        }

        initEncoderDecoder(node.left, osf + "0");
        initEncoderDecoder(node.right, osf + "1");
    }

    // STEP 8 : Create Encode and Decode methods.
    public String encode(String source) {
        String ans = "";

        for (int i = 0; i < source.length(); i++) {
            ans += encoder.get(source.charAt(i));
        }

        return ans;
    }

    public String decode(String codeString) {
        String key = "";
        String ans = "";

        for (int i = 0; i < codeString.length(); i++) {
            key += codeString.charAt(i);
            if (decoder.containsKey(key)) {
                ans += decoder.get(key);
                key = "";
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        String str = "abcd";
        HuffmanCoder hc = new HuffmanCoder(str);

        String cs = hc.encode(str);
        System.out.println(cs);
        String ds = hc.decode(cs);
        System.out.println(ds);
    }
}
