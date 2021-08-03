
public class l003_Queen_RecursionTree {

    // Queen_Set. ===========================================

    // --------------------------------------------------
    // tnb : total no. boxes, bno : box no., tnq : total No. queen, qpsf : queen
    // placed soo far, asf : answer soo far
    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int b = bno; b <= tnb; b++) { // b -> box
            // count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, asf + "b" + b + "q" + qpsf + " ");
            count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, asf + b + " "); // // asf + b -> yaa humara coin
                                                                                   // chain mai single combination jasa
                                                                                   // chala gaa
        }

        return count;
    }

    // --------------------------------------------------
    public static int queenCombination1D_subseq(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1; // ik ans mil gia huma
            }
            return 0; // huma comfirmation nahi hai ki kitni queens place hui hai & quuens place hui
                      // bhi hai ki nahi
        }
        int count = 0;
        count += queenCombination1D_subseq(tnb, bno + 1, tnq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ");
        count += queenCombination1D_subseq(tnb, bno + 1, tnq, qpsf, asf);

        return count;
    }

    // --------------------------------------------------
    public static int queenPermutation1D(int tnb, int tnq, int qpsf, boolean[] vis, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int b = 1; b <= tnb; b++) {
            if (!vis[b]) {
                vis[b] = true; // mark
                count += queenPermutation1D(tnb, tnq, qpsf + 1, vis, asf + "b" + b + "q" + qpsf + " ");
                vis[b] = false; // unmark
            }
        }

        return count;
    }

    // --------------------------------------------------
    public static int queenPermutation1D_subseq(int tnb, int bno, int tnq, int qpsf, boolean[] vis, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (!vis[bno]) {
            vis[bno] = true; // mark
            count += queenPermutation1D_subseq(tnb, 1, tnq, qpsf + 1, vis, asf + "b" + bno + "q" + qpsf + " ");
            vis[bno] = false; // unmark
        }

        count += queenPermutation1D_subseq(tnb, bno + 1, tnq, qpsf, vis, asf);

        return count;
    }

    // 2QueenSet. ====================================================

    // --------------------------------------------------
    public static int queenCombination2D(boolean[][] box, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            count += queenCombination2D(box, bno + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        }

        return count;
    }

    // --------------------------------------------------
    public static int queenCombination2D_subseq(boolean[][] box, int bno, int tnq, String asf) {
        int n = box.length, m = box[0].length;
        if (tnq == 0 || bno > n * m) {
            if (tnq == 0) {
                System.out.println(asf);
            }
            return 0;
        }

        int count = 0;

        int r = bno / m;
        int c = bno % m;
        count += queenCombination2D_subseq(box, bno + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        count += queenCombination2D_subseq(box, bno + 1, tnq, asf);

        return count;
    }

    // --------------------------------------------------
    public static int queenPermutation2D(boolean[][] box, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (r < n && c < m) {
                if (!box[r][c]) {
                    box[r][c] = true; // mark
                    count += queenPermutation2D(box, tnq - 1, asf + "(" + r + "," + c + ") ");
                    box[r][c] = false; // unmark
                }
            }
        }

        return count;
    }

    // --------------------------------------------------
    public static int queenPermutation2D_subseq(boolean[][] box, int bno, int tnq, String asf) {
        int n = box.length, m = box[0].length;
        if (tnq == 0 || bno > n * m) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        int r = bno / m;
        int c = bno % m;
        if (r < n && c < m) {
            if (!box[r][c]) {
                box[r][c] = true; // mark
                count += queenPermutation2D_subseq(box, 0, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false; // unmark
            }
        }

        count += queenPermutation2D_subseq(box, bno + 1, tnq, asf);

        return count;
    }

    public static void queen1D() {
        System.out.println(queenCombination1D(6, 0, 3, 0, "")); // in total we 35 arrangement of 4 queen in 7 boxes
                                                                // ->which is same as the arrangement of single
                                                                // combination in coin chain ( we have 1Rs 7 coins & we
                                                                // have 4 as target to achive with these 7 1Rs coins ->
                                                                // so the total no of combinations or arrangements are
                                                                // same as 35 of queenCombination1D).

    }

    public static void queen2D() {

    }

    public static void main(String[] args) {
        queen1D();
        queen2D();
    }
}

// javac l003_Queen_RecursionTree.java && java l003_Queen_RecursionTree >
// output.txt