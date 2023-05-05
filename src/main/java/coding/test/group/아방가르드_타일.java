package coding.test.group;

public class 아방가르드_타일 {
    int mod = 1000000007;

    public int[][] matrixProduct(int[][] arr1, int[][] arr2) {
        int l = arr1.length;
        int[][] new_arr = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < l; k++) {
                    new_arr[i][j] += arr1[i][k] * arr2[k][j];
                }
                new_arr[i][j] %= mod;
            }
        }
        return new_arr;
    }

    public int[] matrixProduct2(int[][] arr, int[] lst) {
        int l = arr.length;
        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                result[i] += arr[i][j] * lst[l - j - 1];
                result[i] %= mod;
            }
        }
        return result;
    }

    public int solution(int n) {
        int[] A = {1, 3, 10, 23, 62, 170};

        if (n <= 6) {
            return A[n-1];
        }

        int[][] arr = {{1, 2, 6, 1, 0, -1}};
        for (int i = 0; i < 5; i++) {
            int[] lst = new int[6];
            lst[i] = 1;
            arr = append(arr, lst);
        }

        int[][] mat = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            mat[i] = arr[i].clone();
        }

        int[][] r_matrix = new int[6][6];
        for (int i = 0; i < 6; i++) {
            r_matrix[i][i] = 1;
        }

        int cnt = n - 3;
        while (cnt > 0) {
            if (cnt % 2 == 1) {
                r_matrix = matrixProduct(r_matrix, mat);
            }
            mat = matrixProduct(mat, mat);
            cnt /= 2;
        }

        int[] result = matrixProduct2(r_matrix, A);
        return result[3];
    }

    public int[][] append(int[][] arr, int[] lst) {
        int[][] new_arr = new int[arr.length + 1][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i].clone();
        }
        new_arr[new_arr.length - 1] = lst;
        return new_arr;
    }
}
