package project.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Database implements Predicate<String> {

    private final List<String> datas = new LinkedList<>();
    private String searchTerms = "";

    public Database(String data) throws IOException {

        FileReader fr = new FileReader(data);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while (null != (line = br.readLine()))
            datas.add(line);
        fr.close();
    }

    @Override
    public boolean test(String v) {
        return v.toLowerCase().contains(searchTerms);
    }
    
    public List<String> search2(String terms) {
        searchTerms = terms.toLowerCase();
        return datas.stream()
            .filter(this)
            .toList(); // to convert stream to List
    }

    public List<String> search(String terms) {
        final String t = terms.toLowerCase();
        return datas.stream()
            .filter(v -> v.toLowerCase().contains(t))
            .toList();
    }
}
