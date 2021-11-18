public class T1 extends Thread implements AutoCloseable {

    T3 t;

    public T1(T3 t) throws InterruptedException {
        this.t = t;
        //setPriority(3);
        join();
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+"   T1   "+Thread.currentThread().getPriority());
        t.metoda();
        System.out.println(t.getName());
    }

    @Override
    public void close() throws Exception {

    }
}
