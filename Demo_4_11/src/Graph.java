import java.util.Arrays;
import java.util.HashMap;

public class Graph {
    private HashMap<Character, Integer> map;
    private int[][] matrix;
    private boolean isDirect;
    private static final int MAX = Integer.MAX_VALUE;

    public Graph(int size, boolean isDirect) {
        this.map = new HashMap<>();
        this.matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], MAX);
        }
        this.isDirect = isDirect;
    }

    public void initVertex(char[] vertex) {
        for (int i = 0; i < vertex.length; i++) {
            map.put(vertex[i], i);
        }
    }

    public void addEdge(char vi, char vj, int weight) {
        int x = map.get(vi);
        int y = map.get(vj);
        if (isDirect) {
            matrix[x][y] = weight;
        } else {
            matrix[x][y] = matrix[y][x] = weight;
        }
    }

    public void printGraph() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == MAX) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] array = {'A', 'B', 'C', 'D'};
        Graph graph = new Graph(4, true);
        graph.initVertex(array);
        graph.addEdge('A', 'B', 1);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('C', 'D', 1);
        graph.addEdge('D', 'A', 1);
        graph.printGraph();
    }
}
