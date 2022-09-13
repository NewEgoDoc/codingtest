package coding.test.summary.permutation;

import org.junit.Test;

import java.util.Arrays;


// public class Permutation {
//
//     private int[] array;
//     private boolean[] visited;
//     private int n;
//
//     private int r;
//
//     private int[] result;
//
//     private int index = 0;
//
//     public Permutation(int[] array, int r) {
//         this.array = array;
//         this.n = array.length;
//         this.visited = new boolean[n];
//         this.result = new int[n];
//         this.r = r;
//     }
//
//     void execute(){
//         if(index == r){
//             System.out.print("[");
//             for (int i = 0; i < r; i++) {
//                 if(i == (r - 1)){
//                     System.out.print(result[i]);
//                     break;
//                 }
//                 System.out.print(result[i] + ", ");
//             }
//             System.out.println("]");
//         }
//
//         for (int i = 0; i < n; i++) {
//             if(!visited[i]){
//                 visited[i] = true;
//                 result[index] = array[i];
//                 index++;
//                 execute();
//                 index--;
//                 visited[i] = false;
//             }
//         }
//     }
// }
public class Permutation {
	private int[] array;
	private boolean[] visited;
	private int n;

	private int r;

	private int[] result;
	private int num = 0;

	private int index = 0;

	public Permutation(int[] array, int r) {
		this.array = array;
		this.n = array.length;
		this.visited = new boolean[n];
		this.r = r;
		this.result = new int[n];
	}

	void execute(){
		if(index == r){
			num++;
			System.out.print("[");
			for (int i = 0; i < r; i++) {
				if(i == (r - 1)){
					System.out.print(result[i]);
					break;
				}
				System.out.print(result[i] + ", ");
			}
			System.out.println("]");
		}

		for (int i = 0; i < n; i++) {
			if(!visited[i]){
				visited[i] = true;
				result[index] = array[i];
				index++;
				execute();
				index--;
				visited[i] = false;
			}
		}
	}

	public int getNum() {
		return num;
	}
}