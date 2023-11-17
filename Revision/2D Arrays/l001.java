import java.util.Scanner;


public class l001 {

    public static Scanner scr = new Scanner(System.in);

    public static void input(int[][] arr) { // set
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = scr.nextInt();
            }
        }
    }

    public static void output(int[][] arr) { // get
        for(int[] ar : arr) { // 2D array --to--> 1D array
            for(int ele : ar) { // 1D array --to--> each array element
                System.out.print(ele + "\t");
            } 
            System.out.println();
        }
    }

    // ---------------------------------------------------
    // Q1 Maximum Element in a 2D array -> O(n^2)
    public static int maximumElement(int[][] arr) {
        int maxEle = -(int)1e9;

        for(int[] ar : arr) {
            for(int ele : ar) {
                maxEle = Math.max(maxEle, ele);
            }
        }

        return maxEle;
    }

    // ---------------------------------------------------
    // Q2 Minimum Element in a 2D array -> O(n^2)
    public static int minimumElement(int[][] arr ) {
        int minEle = (int)1e9;

        for(int[] ar : arr ) {
            for(int ele : ar) {
                minEle = Math.min(minEle, ele);
            } 
        }

        return minEle;
    }

    // ---------------------------------------------------
    // Q3 Find Element in a 2D array -> O(n^2) 
    public static boolean findElement(int[][] arr, int data) {
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(arr[i][j] == data) {
                    return true; // arr[i][j] (to return element) OR return [i, j] (to return index of the element in the array) 
                }
            }
        }

        return false; // -1 (element not found in the 2D array) OR [-1, -1] (element not found in the 2D array so returning [-1, -1])
    }

    // ---------------------------------------------------
    // Q4 Wave Travesal(not on portal) -> O(n^2)
    // 1    2   3         1   2   3 
    // 4    5   6   ==>   6   5   4
    // 7    8   9         7   8   9
    // 6    2   7         7   2   6
    public static void waveTraversal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0 ; i < n ; i++) {
            if(i % 2 == 0) {
                for(int j = 0 ; j < m ; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
            } else {
                for(int j = m - 1 ; j >= 0 ; j--) {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------
    // Q5 The state of wakanda-1 -> O(n^2)
    // 1	2	3	        1   4   7
    // 4	5	6	==>     8   5   2
    // 7	8	9           3   6   9
    public static void stateOfWakandaOne(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int j = 0 ; j < m ; j++) {
            if(j % 2 == 0) {
                for(int i = 0 ; i < n ; i++) {
                    System.out.print(arr[i][j] + "\t");
                }
            } else {
                for(int i = n - 1 ; i >= 0 ; i--) {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    // ---------------------------------------------------
    // Q6 The State Of Wakanda - 2 (Diagonal Traversal) -> O( (m * n)/ 2 ), if(n == m) -> O(n^2)
    public static void diagonalTraversal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for(int gap = 0 ; gap < m ; gap++) {
            for(int i = 0, j = gap ; i < n && j < m ; i++, j++) {
                System.out.print(arr[i][j] + "\t");
            }
        }
    }

    // ---------------------------------------------------
    // Q7 Full Diagonal Traversal -> O(n * m) ==> O(n^2)
    public static void fullDiagonalTraversal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for(int gap = n - 1 ; gap >= 0 ; gap--) {
            for(int i = gap, j = 0 ; i < n && j < m ; i++, j++) {
                System.out.print(arr[i][j] + "\t");
            }
        }

        for(int gap = 0 ; gap < m ; gap++) {
            for(int i = 0, j = gap ; i < n && j < m ; i++, j++) {
                System.out.print(arr[i][j] + "\t");
            }
        }
    }

    // ---------------------------------------------------
    // Q8 Spiral Display -> O(n^2)
    public static void spiralDisplay(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int tne = n * m; // total number of elements
        int rmin = 0, cmin = 0, rmax = n - 1, cmax = m - 1;

        while(tne > 0) {
            // LW -> left wall
            for(int r = rmin ; r <= rmax && tne > 0 ; r++) {
                System.out.print(arr[r][cmin] + "\t");
                tne--;
            }
            cmin++;

            // BW -> bottom wall
            for(int c = cmin ; c <= cmax && tne > 0; c++) {
                System.out.print(arr[rmax][c] + "\t");
                tne--;
            }
            rmax--;

            // RW -> right wall
            for(int r = rmax ; r >= rmin && tne > 0; r--) {
                System.out.print(arr[r][cmax] + "\t");
                tne--;
            }
            cmax--;

            // TW -> top wall
            for(int c = cmax ; c >= cmin && tne > 0; c--) {
                System.out.print(arr[rmin][c] + "\t");
                tne--;
            }
            rmin++;
        }
    }

    // ---------------------------------------------------
    // Q9 Exit Point -> O(2 * n^2)
    public static void exitPoint(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int dir = 0, r = 0, c = 0;

        while(true) {
            dir = (dir + arr[r][c]) % 4;

            if(dir == 0) { // North 
                c++;
                if(c == m) {
                    System.out.println(r + "\t" + (c - 1));
                    break;
                }
            } else if(dir == 1) { // East
                r++;
                if(r == n) {
                    System.out.println((r - 1) + "\t" + c);
                    break;
                }
            } else if(dir == 2) { // South
                c--;
                if(c < 0) {
                    System.out.println(r + "\t" + (c + 1));
                    break;
                }
            } else if(dir == 3) { // West
                r--;
                if(r < 0) {
                    System.out.println((r + 1) + "\t" + c);
                    break;
                }
            }
        }
    }

    // --------------------------------------------------- 
    // Q10 Rotate by 90 Degree (No Extra Space) -> Time - O(n^2), Space - O(1)
    public static void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void rotateBy90(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        // Transpose matrix
        for(int i = 0 ; i < n ; i++) {
            for(int j = i ; j < m ; j++) {
                swap(arr, i, j, j, i);
            }
        }

        // Interchange column
        int si = 0, ei = m - 1;
        while(si < ei) {
            for(int i = 0 ; i < n ; i++) {
                swap(arr, i, si, i, ei);
            }
            // Always write these values first si and ei ( increment aur decrement vali value)
            si++;
            ei--;
        }
    }

    // Q10 Rotate by 90 Degree (With Extra Space) -> Time - O(n^2), Space - O(n^2)
    public static int[][] rotateBy90_01(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] res = new int[n][m];
        int ei = m - 1;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                res[j][ei] = arr[i][j];
            }
            ei--;
        }

        return res;
    }

    // --------------------------------------------------- 
    // Q11 Saddle Point -> Time - O(n^2)
    public static int maxInCol(int[][] arr, int j) {
        int row = -1;
        int maxVal = -(int)1e9;

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i][j] > maxVal) {
                maxVal = arr[i][j];
                row = i;
            }
        }
        return row;
    }

    public static void saddlePoint(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int col = -1;
        boolean flag = false;
        for(int i = 0 ; i < n ; i++) {
            int minVal = (int)1e9;
            for(int j = 0 ; j < m ; j++) {
                if(arr[i][j] < minVal) {
                    minVal = arr[i][j];
                    col = j;
                }
            }

            int row = maxInCol(arr, col);
            if(row == i) {
                System.out.println(arr[row][col]);
                flag = true;
            }
        }

        if(!flag) {
            System.out.println("Invalid input");
        }
    }

    // ---------------------------------------------------
    // Q12 Matrix Multiplication -> O((a*b)*(b*c))
    public static void matrixMultiplication(int[][] arr1, int[][] arr2){
        int n1 = arr1.length, m1 = arr1[0].length;
        int n2 = arr2.length, m2 = arr2[0].length;

        // 1st Matrix dimensions (n1 * m1)
        // 2nd Matrix dimensions (n2 * m2)
        if(m1 != n2) { // In order to multiply the matrix m1 must be equals to n2
            System.out.println("Invalid Input");
            return;
        }

        int[][] product = new int[n1][m2];

        for(int i = 0 ; i < product.length ; i++) {
            for(int j = 0 ; j < product[0].length ; j++) {
                for(int idx = 0 ; idx < m1 ; idx++) { // idx < m1 OR idx < n2 (idx -> j1 and i2)
                    product[i][j] += (arr1[i][idx] * arr2[idx][j]);
                }
            }
        }

        output(product);
    }

    // ---------------------------------------------------
    // Q13 Ring Rotate

    public static int[] fillOnedFromShell(int[][] arr, int s) {
        int n = arr.length, m = arr[0].length;
        int rmin = s - 1, cmin = s - 1;
        int rmax = n - s, cmax = m - s;

        // size = lw + bw + rw + tw - 4; // We have to do minus 4 to neglect the repeating corner elements
        // lw = rw = (rmax - rmin + 1); 
        // bw = tw = (cmax - cmin + 1);
        int size = 2 * (rmax - rmin + cmax - cmin);
        int[] oned = new int[size];

        int idx = 0;
        // lw - left wall
        for(int r = rmin, c = cmin; r <= rmax ; r++) {
            oned[idx] = arr[r][c];
            idx++;
        }
        cmin++;

        // bw - bottom wall
        for(int r = rmax, c = cmin; c <= cmax ; c++) {
            oned[idx] = arr[r][c];
            idx++;
        }
        rmax--;

        // rw - right wall
        for(int r = rmax, c = cmax; r >= rmin ; r--){
            oned[idx] = arr[r][c];
            idx++;
        }
        cmax--;

        // tw - top wall
        for(int r = rmin, c = cmax; c >= cmin; c--) {
            oned[idx] = arr[r][c];
            idx++;
        }
        rmin++;
        
        return oned;
    }

    public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

    public static void reverse(int[] arr, int si, int ei) {
        while(si < ei) {
            swap(arr, si, ei);
            si++;
            ei--;
        }
    }

    public static void rotate(int[] arr, int r) {
        int n = arr.length;
        r = r % n;
        if(r < 0) {
            r += n;
        }

        reverse(arr, 0, n - 1);
        reverse(arr, 0, r - 1);
        reverse(arr, r, n - 1);
    }

    public static void fillbackShellFromOned(int[][] arr, int[] oned, int s) {
        int n = arr.length, m = arr[0].length;
        int rmin = s - 1, cmin = s - 1;
        int rmax = n - s, cmax = m - s;

        int idx = 0;
        // lw - left wall
        for(int r = rmin, c = cmin; r <= rmax ; r++) {
            arr[r][c] = oned[idx];
            idx++;
        }
        cmin++;

        // bw - bottom wall
        for(int r = rmax, c = cmin; c <= cmax ; c++) {
            arr[r][c] = oned[idx];
            idx++;
        }
        rmax--;

        // rw - right wall
        for(int r = rmax, c = cmax; r >= rmin ; r--){
            arr[r][c] = oned[idx];
            idx++;
        }
        cmax--;

        // tw - top wall
        for(int r = rmin, c = cmax; c >= cmin; c--) {
            arr[r][c] = oned[idx];
            idx++;
        }
        rmin++;
    }

    public static void ringRotate(int[][] arr, int s, int r) {
        int oned[] = fillOnedFromShell(arr, s);
        rotate(oned, r);
        fillbackShellFromOned(arr, oned, s);

        output(arr);
    }

    public static void main(String[] args) {
        int[][] arr = new int[scr.nextInt()][scr.nextInt()];

        input(arr);
        output(arr);
        System.out.println();

        // int maxElement = maximumElement(arr);
        // System.out.println("Maximum Element in an 2D Array ==> " + maxElement);

        // int minElement = minimumElement(arr);
        // System.out.println("Minimum Element in an 2D Array ==> " + minElement);

        // ------------------------------
        // int data = scr.nextInt();
        // boolean foundElement = findElement(arr, data);
        // if(foundElement) {
        //     System.out.println(data + " Found Element");
        // } else {
        //     System.out.println(data + " Element not found");
        // }

        // waveTraversal(arr);
        // stateOfWakandaOne(arr);
        // diagonalTraversal(arr);
        // fullDiagonalTraversal(arr);
        // spiralDisplay(arr);
        // exitPoint(arr);
        
        // ------------------------------
        // rotateBy90(arr); // no extra space
        // output(arr);

        // int[][] res = rotateBy90_01(arr); // with extra space
        // output(res);

        // ------------------------------
        // int[][] arr2 = new int[scr.nextInt()][scr.nextInt()];
        // input(arr2);
        // output(arr2);
        // System.out.println();

        // matrixMultiplication(arr, arr2);

        // ------------------------------
        ringRotate(arr, scr.nextInt(), scr.nextInt()); // arr, shellNumber, rotateByANumber
    }
}

// javac l001.java && java l001 < input.txt > output.txt