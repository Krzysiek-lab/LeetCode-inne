import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        T3 inst_0 = new T3();
        try (T1 inst1 = new T1(inst_0); T2 inst2 = new T2(inst_0); T4 inst4 = new T4(inst_0);) {
            inst1.start();
            inst1.join();
            inst2.start();
            inst2.join();
            inst4.start();

//        CompletableFuture.runAsync(inst1)
//                .thenRunAsync(inst2)
//                .thenRunAsync(inst4);
        }
        catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}