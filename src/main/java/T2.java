public class T2 extends Thread implements AutoCloseable {

    T3 t;

    public T2(T3 t) throws InterruptedException {
        this.t = t;
        //setPriority(2);
        join();
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "   T2   " + Thread.currentThread().getPriority());
        t.metoda();
        t.setName("adam");
    }

    @Override
    public void close() throws Exception {

    }
}
