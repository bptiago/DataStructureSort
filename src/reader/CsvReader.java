package reader;

import structure.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public ArrayList<Integer> read(String caminhoRelativo) {
        ArrayList<Integer> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoRelativo))) {
            br.readLine();

            String linha;

            while ((linha = br.readLine()) != null) {

                int numero = Integer.parseInt(linha.trim());
                data.add(numero);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return data;
    }
}
