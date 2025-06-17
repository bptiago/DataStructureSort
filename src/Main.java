import reader.CsvReader;
import structure.ArrayList;

// TODO: System.nanoTime() PARA MEDIR TEMPO DE CADA EXECUÇÃO
// TODO: LER OS DEMAIS ARQUIVOS E APLICAR SORT

public class Main {
    public static void main(String[] args) {
        imprimirRelatorio("aleatorio");
        imprimirRelatorio("crescente");
        imprimirRelatorio("decrescente");
    }

    public static void imprimirRelatorio(String fileName) {
        int fileNum = 100;

        for (int i = 0; i < 3; i++) {
            CsvReader reader = new CsvReader();
            ArrayList<Integer> nums = reader.read(String.format("src/reader/%s_%d.csv", fileName, fileNum));

            long inicio1 = System.nanoTime();
            ArrayList<Integer> insertionSortNums = SortAlgorithm.insertionSort(nums);
            long fim1 = System.nanoTime();

            long inicio2 = System.nanoTime();
            ArrayList<Integer> bubbleSortNums = SortAlgorithm.bubbleSort(nums);
            long fim2 = System.nanoTime();

            long inicio3 = System.nanoTime();
            ArrayList<Integer> quickSortNums = SortAlgorithm.quickSort(nums);
            long fim3 = System.nanoTime();

            long timerInsertionSort = fim1 - inicio1;
            long timerBubbleSort = fim2 - inicio2;
            long timerQuickSort = fim3 - inicio3;

            System.out.println(String.format("Leitura do arquivo: %s_%d.csv", fileName, fileNum));

            System.out.println(String.format("Algoritmo Insertion Sort - %d ns (nanosegundos)", timerInsertionSort));
//            System.out.println(SortAlgorithm.listToString(insertionSortNums)); --> imprime a lista ordenada como STRING

            System.out.println(String.format("Algoritmo Bubble Sort - %d ns (nanosegundos)", timerBubbleSort));
//            System.out.println(SortAlgorithm.listToString(bubbleSortNums)); --> imprime a lista ordenada como STRING

            System.out.println(String.format("Algoritmo QuickSort Sort - %d ns (nanosegundos)\n", timerQuickSort));
//            System.out.println(SortAlgorithm.listToString(bubbleSortNums)); --> imprime a lista ordenada como STRING

            fileNum *= 10;
        }
    }
}
