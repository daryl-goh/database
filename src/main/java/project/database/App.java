package project.database;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException 
    {
        Database db = new Database(args[0]);
        Session sess = new Session(db);
        sess.run();
    }
}
