public class T4 extends Thread implements AutoCloseable {

    T3 t;

    public T4(T3 t) throws InterruptedException {
        this.t = t;
        //setPriority(1);
        join();
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "   T4   " + Thread.currentThread().getPriority());
        t.metoda();
        System.out.println(t.getName());
    }

    @Override
    public void close() throws Exception {

    }
}
