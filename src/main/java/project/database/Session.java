package project.database;

import java.io.Console;
import java.util.List;

public class Session implements Runnable {
    public static final String SEARCH = "search ";
    public static final String COUNT = "count ";
    public static final String EXIT = "exit";

    private final Database dataDB;

    public Session(Database db) {
        dataDB = db;
    }

    @Override
    public void run() {
        Console cons = System.console();
        boolean stop = false;
        List<String> result;
        while (!stop) {
            String input = cons.readLine("> ");
            input = input.trim();

            if (input.startsWith(SEARCH)) {
                input = input.substring(SEARCH.length()).trim();
                result = dataDB.search(input);
                if (result.size() > 0)
                    printList(result);
                else
                    System.out.printf("Your search of '%s' returns no  result\n", input);
            } else if (input.startsWith(COUNT)) {
                input = input.substring(COUNT.length()).trim();
                result = dataDB.search(input);
                if (result.size() > 0)
                    System.out.printf("There are %d results with the phrase '%s' in the title\n", result.size(), input);
                else
                    System.out.printf("There are no results with the phrase '%s' in the title\n", input);
            } else if (EXIT.equals(input))
                stop = true;
            
            else  
                System.err.printf("Unknown command: '%s'\n", input);
            System.out.println();
        }
    }
    private void printList(List<String> data) {
        for (int i = 0; i < data.size(); i++)
            System.out.printf("%d. %s\n", i + 1, data.get(i));
            
    }
    
}
