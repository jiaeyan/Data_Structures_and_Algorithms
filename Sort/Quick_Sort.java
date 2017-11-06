package sort;

public class Quick_Sort {

	public static void main(String[] args) {
		int[] arr = {4,2,10,5,7,9,8,3,1,6,0};
		Quick_Sort qs = new Quick_Sort();
		qs.sort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
	}
	
	public void sort(int[] arr, int low, int high) {
		if (low < high) {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
	}
	
	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot){
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
	}
}
