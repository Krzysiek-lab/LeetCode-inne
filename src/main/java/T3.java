public class T3 {

    private volatile String name = "jan";

    public synchronized void metoda() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + "    " + Thread.currentThread().getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
