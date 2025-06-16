import reader.CsvReader;
import structure.ArrayList;

// TODO: System.nanoTime() PARA MEDIR TEMPO DE CADA EXECUÇÃO
// TODO: LER OS DEMAIS ARQUIVOS E APLICAR SORT

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReader();

        ArrayList<Integer> aleatorio_100 = reader.read("src/reader/aleatorio_100.csv");
        ArrayList<Integer> insertion_sort_aleatorio_100 = SortAlgorithm.insertionSort(aleatorio_100);
        ArrayList<Integer> bubble_sort_aleatorio_100 = SortAlgorithm.bubbleSort(aleatorio_100);
        ArrayList<Integer> quick_sort_aleatorio_100 = SortAlgorithm.bubbleSort(aleatorio_100);

        System.out.println(SortAlgorithm.listToString(insertion_sort_aleatorio_100));
        System.out.println(SortAlgorithm.listToString(bubble_sort_aleatorio_100));
        System.out.println(SortAlgorithm.listToString(quick_sort_aleatorio_100));
    }
}
