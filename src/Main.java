import reader.CsvReader;
import structure.ArrayList;

// TODO: System.nanoTime() PARA MEDIR TEMPO DE CADA EXECUÇÃO
// TODO: LER OS DEMAIS ARQUIVOS E APLICAR SORT

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReader();

        // Arquivos aleatórios
        int file_num = 100;
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> nums = reader.read(String.format("src/reader/aleatorio_%d.csv", file_num));

            long inicio = System.nanoTime();
            ArrayList<Integer> sortedNums = SortAlgorithm.insertionSort(nums);
            long fim = System.nanoTime();

            long timer = fim - inicio;

            System.out.println(String.format("Leitura do arquivo: aleatorio_%d.csv - %d ns (nanosegundos)", file_num, timer));
            System.out.println(SortAlgorithm.listToString(sortedNums));
            System.out.println(); // Pular linha

            file_num *= 10;
        }

        file_num = 100;
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> nums = reader.read(String.format("src/reader/crescente_%d.csv", file_num));

            long inicio = System.nanoTime();
            ArrayList<Integer> sortedNums = SortAlgorithm.insertionSort(nums);
            long fim = System.nanoTime();

            long timer = fim - inicio;

            System.out.println(String.format("Leitura do arquivo: crescente_%d.csv - %d ns (nanosegundos)", file_num, timer));
            System.out.println(SortAlgorithm.listToString(sortedNums));
            System.out.println(); // Pular linha

            file_num *= 10;
        }

        file_num = 100;
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> nums = reader.read(String.format("src/reader/decrescente_%d.csv", file_num));

            long inicio = System.nanoTime();
            ArrayList<Integer> sortedNums = SortAlgorithm.insertionSort(nums);
            long fim = System.nanoTime();

            long timer = fim - inicio;

            System.out.println(String.format("Leitura do arquivo: decrescente_%d.csv - %d ns (nanosegundos)", file_num, timer));
            System.out.println(SortAlgorithm.listToString(sortedNums));
            System.out.println(); // Pular linha

            file_num *= 10;
        }
    }
}
