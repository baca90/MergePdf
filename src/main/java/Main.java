import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Merger merger = new Merger(args[0],args[1]);
        merger.mergeNow();
    }
}