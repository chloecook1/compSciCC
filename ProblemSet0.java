import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSet0 {

    public static void main(String[] args) {
        // countInRange example
        int[] x = {14, 1, 22, 17, 36, 7, -43, 5};
        System.out.println(countInRange(x, 4, 17));

        // clump example
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("hi");
        listOfStrings.add("there");
        listOfStrings.add("what");
        listOfStrings.add("is");
        listOfStrings.add("up?");
        clump(listOfStrings);

        // magic square example
        int[][] square = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        System.out.println(isMagicSquare(square));

        // median example
        int[] arr = {2, 3, 10, 1, 5};
        System.out.println(median(arr));
    }

    public static int countInRange(int[] array, int min, int max) {
        int count = 0;
        for (int num : array) { //for each loop
            if (num >= min && num <= max) {
                count++;
            }
        }
        return count;
    }

    public static void clump(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String clumped = "(" + list.get(i) + " " + list.get(i + 1) + ")"; 
            list.set(i, clumped);
            list.remove(i + 1);  // remove next element since it's already clumped
        }
        System.out.println(list);
    }

    public static boolean isMagicSquare(int[][] square) {
        int size = square.length; //square, so size is same both ways
        int sum = 0;

        // magic sum for the first row
        for (int i = 0; i < size; i++) {
            sum += square[0][i];
        }

        // check all rows
        for (int i = 1; i < size; i++) {
            int rows = 0;
            for (int j = 0; j < size; j++) {
                rows += square[i][j];
            }
            if (rows != sum){
                return false;
            } 
        }

        // check all columns
        for (int i = 0; i < size; i++) {
            int cols = 0;
            for (int j = 0; j < size; j++) {
                cols += square[j][i];
            }
            if (cols != sum){
                return false;
            } 
        }

        // check both diagonals
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < size; i++) {
            diag1 += square[i][i];
            diag2 += square[i][size - i - 1]; //- 1 because of indexes
        }

        if(diag1 == sum && diag2 == sum){
            return true;
        }
        return false;
    }

    public static int median(int[] array) {
        //counter array
        int[] bucket = new int[100];
        //number freq
        for(int i = 0; i < array.length; i++){
            bucket[array[i]]++;
        }
        //median ind.
        int medianInd = (array.length/2)+1;
        //count
        int count = 0;
        int med = 0; //median var
        for(int i = 0; i < bucket.length; i++){
            count+=bucket[i];
            if(count == medianInd){
                med = i;
                break;
            }
        }
        return med;
    }
}