public class Main {
    public static void main(String[] args) {
        DB mydb = new DB();
        mydb.connectDb();

//        Table table = new Table();
//        table.createTable();
        Operations op = new Operations();
        op.read();
//        op.update();
//        op.read();
//        op.delete();



    }
}