import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class testt {


    public static void main(String[] args) {

        Car inst1 = new Car();
        Car inst2 = new Car();
        Car inst3 = new Car();
        Car inst4 = new Car();
        Car inst5 = new Car();


        inst1.setMaxSpeed(100);
        inst1.setAcceleration(50);

        inst2.setMaxSpeed(100);
        inst2.setAcceleration(100);


        inst3.setMaxSpeed(100);
        inst3.setAcceleration(150);


        inst4.setMaxSpeed(100);
        inst4.setAcceleration(800);


        inst5.setMaxSpeed(100);
        inst5.setAcceleration(250);


        Car[] tabb = {inst1, inst2, inst3, inst4, inst5};

        System.out.println(max(tabb));

        testt t = new testt();
        System.out.println(t.calculate(4));
        Car[] tabbb = new Car[0];
        // max(tabbb);


        System.out.println(palindrom("bob"));
        System.out.println(palindrom("boc"));
        System.out.println("palindromInt: " + palindromInt(111));
        System.out.println("palindromInt: " + palindromInt(1231));

        String[] arrS = {"a", "a", "b", "b", "b", "c", "d", "e"};
        System.out.println("distinct array: " + Arrays.toString(distinctArray(arrS)));

        System.out.println("square root: " + square(2, 2));
        System.out.println(prime(2));
        System.out.println(prime(13));
        System.out.println(prime(10));
        System.out.println(prime(66));
        System.out.println(prime(67));

        System.out.println("fibonacci: " + fibonacii(5));
    }

    public int calculate(int index) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 6, 11, 20, 37, 68));
        if (index > 2) {
            int value = list.get(index - 1) + list.get(index - 2) + list.get(index - 3);
            list.add(index, value);
        }
        return list.get(index);
    }


    public static Car max(Car[] tab) {
        if (tab.length == 0) {
            throw new IllegalArgumentException("wrong array size");
        }
        Arrays.sort(tab, new Comparator<Car>() {
            @Override
            public int compare(Car t0, Car t1) {
                return t0.getMaxSpeed() > t1.getMaxSpeed() ? 1 : (t0.getMaxSpeed() < t1.getMaxSpeed()) ? -1 :
                        (t0.getAcceleration() > t1.getAcceleration()) ? 1 : (t0.getAcceleration() < t1.getAcceleration()) ? -1 : 0;
            }
        });
        return tab[tab.length - 1];
    }


    public static boolean palindrom(String given) {
        StringBuffer sb = new StringBuffer(given);
        StringBuffer sb2 = new StringBuffer(given);
        return (sb.reverse().compareTo(sb2)) == 0 ? true : false;
    }


    public static boolean palindromInt(int given) {
        char[] arr = String.valueOf(given).toCharArray();
        char[] arr2 = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[arr2.length - 1 - i] = arr[i];
        }
        return (Arrays.compare(arr, arr2) == 0) ? true : false;
    }


    public static Object[] distinctArray(Object[] arr) {
        arr = Arrays.stream(arr).distinct().toArray();
        return arr;
    }


    public static int square(int value, int power) {
        int endValue = value;
        if (value == 1) {
            return 1;
        } else if (power == 1) {
            return value;
        } else {
            for (int i = 1; i < power; i++) {
                endValue = endValue * value;
            }
        }
        return endValue;
    }


    public static boolean prime(int number) {
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < 10; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count > 2 ? false : true;
    }


    public static int fibonacii(int positon) {
        if (positon == 1 || positon == 2) {
            return 1;
        } else return fibonacii(positon - 1) + fibonacii(positon - 2);
    }
}
