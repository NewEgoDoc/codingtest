package coding.test.summary.combination;

public class Combination {
    private int[] array;
    private int n;
    private int r;
    private boolean[] visited;

    private int[] result;

    private int index = 0;
    private int start = 0;

    public Combination(int[] array, int r) {
        this.array = array;
        this.n = array.length;
        visited = new boolean[n];
        this.r = r;
        this.result = new int[r];
    }

    void execute(){
        if(index == r) {
            System.out.print("[");
            for (int i = 0; i < r; i++) {
                if (i == (r - 1)) {
                    System.out.print(result[i]);
                    break;
                }
                System.out.print(result[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        for (int i = start; i < n; i++) {
            result[index] = array[i];
            start = i + 1;
            index++;
            execute();
            index--;
        }
    }
}
