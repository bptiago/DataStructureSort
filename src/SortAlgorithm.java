import structure.ArrayList;

public class SortAlgorithm {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> array) {
        if (array == null || array.size() <= 1) {
            return null;
        }

        for (int i = 1; i < array.size(); i++) {

            int key = array.get(i);
            int j = i - 1;

            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }

            array.set(j + 1, key);
        }

        long fim = System.nanoTime();
        return array;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
        if (array == null || array.size() <= 1) {
            return null;
        }

        int n = array.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return array;
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {
        if (array == null || array.size() <= 1) {
            return null;
        }
        _quickSort(array, 0, array.size() - 1);
        return array;
    }

    private static void _quickSort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Ordena recursivamente os elementos antes e depois da partição.
            _quickSort(array, low, pi - 1);
            _quickSort(array, pi + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);

        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);

        return i + 1;
    }

    private static void swap(ArrayList<Integer> numbersList, int i, int j) {
        int temp = numbersList.get(i);
        numbersList.set(i, numbersList.get(j));
        numbersList.set(j, temp);
    }

    public static String listToString(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
