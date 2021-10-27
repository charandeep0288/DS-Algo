public class l001 {
    
    // 26 oct 2021 tue 

    // ------------------------------------------------------
    // log(n)
    public static int binarySearch(int[] arr, int si, int ei, int data) {
        
        while(si <= ei) {
            int mid = (si + ei) / 2;
            
            if(arr[mid] == data) 
                return mid;
            else if(arr[mid] < data)
                si = mid + 1;
            else 
                ei = mid - 1;
        }

        return -1;
    }

    public static int firstIndex(int[] arr, int data) {
        if(arr[0] == data) 
            return 0;

        int si = 0, ei = arr.length - 1;
        while(si <= ei) {
            int mid = (si + ei) / 2;
            
            if(arr[mid] == data){

                if(arr[mid + 1] == data)
                    si = mid + 1;
                else 
                    return mid;

            } else if(arr[mid] < data) 
                si = mid + 1;
            else 
                ei = mid - 1;
        }

        return -1;
    }

    public static int lastIndex(int[] arr, int data) {
        if(arr[arr.length - 1] == data)
            return arr.length - 1;

        int si = 0, ei = arr.length - 1;
        while(si <= ei) {
            int mid = (si + ei) / 2;
            
            if(arr[mid] == data) {

                if(arr[mid + 1] == data)
                    si = mid + 1;
                else 
                    return mid;

            } else if(arr[mid] < data)
                si = mid + 1;
            else 
                ei = mid - 1;
        }

        return -1;
    }
    


    // ----------------------------------------------------------
    // leetcode 34. FindFirst and Last Position of Element in Sorted Array 
    public int[] searchRange(int[] arr, int target) {
        if(arr.length == 0)
            return new int[]{-1, -1};   

        return new int[] {firstIndex(arr, target), lastIndex(arr, target)};
    }

    public int closesetElement(int[] arr, int data) {
        
        int si = 0, ei = arr.length - 1;
        
        if(data < arr[si])
            return si;
        else if(data > arr[ei])
            return ei;

        while(si <= ei) {
            int mid = (si + ei) / 2;
            if(arr[mid] == data)
                return mid;
            else if(arr[mid] < data)
                si = mid + 1;
            else 
                ei = mid - 1;
        }

        return data - arr[ei] < arr[si] - data ? ei : si;
    }

    public int perfectLocation(int[] arr, int data) {
        int si = 0, ei = arr.length;

        while(si < ei) {
            int mid = (si + ei) / 2;

            if(arr[mid] <= data)
                si = mid + 1;
            else 
                ei = mid;
        }

        return ei; // return si;
    }


    // leetcode 74.
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int si = 0, ei = n * m - 1;

        while(si <= ei) {
            int mid = (si + ei) / 2, r = mid / m, c = mid % m;

            if(matrix[r][c] == target)
                return true;
            else if(matrix[r][c] < target)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return false;
    }
     // git add . && git commit -m "26 oct 2021 tue levelup Searching and Sorting class-1" && git push origin main


    // 27 oct 2021 wed
     
    
}