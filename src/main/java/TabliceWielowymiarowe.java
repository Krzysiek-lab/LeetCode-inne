import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TabliceWielowymiarowe {

    public static void main(String[] args) {


//        int[][] tab = new int[3][];
//        tab[0] = new int[3];
//        tab[1] = new int[4];
//        tab[2] = new int[5];
//
//
//        for (int i = 0; i < tab.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                tab[i][j] = i;
//            }
//        }
//
//        //System.out.print(Arrays.deepToString(tab));
//
//
//        int[][] tabliczka = new int[10][10];
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//
//                tabliczka[i][j] = (i + 1) * (j + 1);
//            }
//            //System.out.println(Arrays.toString(tabliczka[i]));
//
//            for (int[] tabf : tabliczka) {
//                System.out.println(Arrays.toString(tabf));
//
//            }
//        }

        // int[][] tabs = {{1,2,3},{1,2,3,4,5},{2,3,4,5},{1,2,3,4}};
        // to to samo co:
        // int[][] tabs = new int[4][];
        //tabs[0] = new int[3];
        //tabs[1] = new int[5];
        //tabs[2] = new int[4];
        //tabs[3] = new int[4];


        // tablica 3 wymiarowa

//        int[][][] ttt = {
//                {
//                        {1, 2, 3},
//                        {2, 3, 4}
//                },
//                {
//                        {1, 2, 3},
//                        {1, 2, 3},
//                        {3, 4, 5}
//                }
//        };
//
//        int[][][] ts = new int[2][][];
//
//        ts[0] = new int[2][];
//        ts[1] = new int[3][];
//        ts[0][0] = new int[3];
//        ts[0][1] = new int[3];
//        ts[1] = new int[3][];
//        ts[1][0] = new int[3];
//        ts[1][1] = new int[3];
//        ts[1][2] = new int[3];
//
//        ts[0][0][0] = 1;
//        ts[0][0][1] = 2;
//        ts[0][0][2] = 3;
//
//        ts[0][1][0] = 2;
//        ts[0][1][1] = 3;
//        ts[0][1][2] = 4;
/////
//
//        ts[1][0][0] = 1;
//        ts[1][0][1] = 2;
//        ts[1][0][2] = 3;
//
//        ts[1][1][0] = 1;
//        ts[1][1][1] = 2;
//        ts[1][1][2] = 3;
//
//        ts[1][2][0] = 3;
//        ts[1][2][1] = 4;
//        ts[1][2][2] = 5;
//
//
//        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
////        List<Integer> list2 = new ArrayList<>(list).forEach(e -> System.out.println(e));
//
//        System.out.println("czy sa parzyste: " + list.stream().anyMatch(e -> e % 2 == 0));
//        System.out.println("wszystkie parzyste: " + list.stream().allMatch(e -> e % 2 == 0));
//
//
//        Integer[] k = new Integer[list.size()];
//        k = list.toArray(new Integer[0]);
//
//
//        System.out.println(Arrays.deepEquals(ttt, ts));
//
//        int[][] ty = new int[][]{{1, 2, 3}, {1, 2, 3}, {2, 3, 4}};
//
//        ///////////
//
//        int[][][] iop = new int[3][][];
//
//        iop[0] = new int[4][];
//        iop[0][0] = new int[3];
//        iop[0][1] = new int[4];
//        iop[0][2] = new int[2];
//        iop[0][3] = new int[1];
//
//        iop[1] = new int[3][];
//        iop[1][0] = new int[5];
//        iop[1][1] = new int[6];
//        iop[1][2] = new int[7];
//
//        iop[2] = new int[4][];
//        iop[2][0] = new int[4];
//        iop[2][1] = new int[5];
//        iop[2][2] = new int[6];
//        iop[2][3] = new int[7];
//
//        for (int[][] tab : iop) {
//            for (int[] tab2 : tab) {
//                Arrays.fill(tab2, 6);
//
//                Array.set(tab2, 0, 7);
//                System.out.println("weź: " + Array.get(tab2, 0));
//                System.out.println("znajdz: " + Arrays.binarySearch(tab2, 6));
//                System.out.println(Arrays.toString(tab2));
//
//            }
//        }


        // System.out.print(Arrays.deepToString(iop));

        // metoda(4);

        mm();

        String[] tab = {"this", "is", "a", "string"};
        String value = String.join("/", tab);
        System.out.println(value);

    }


    public static void metoda(int value) {

        int[][] tab = new int[value][];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new int[i + 1];


        }
        for (int[] tabb : tab) {
            System.out.println(Arrays.toString(tabb));
        }

    }


    IntStream iii = IntStream.of(1, 2, 3, 4, 5);
    IntStream lll = IntStream.range(1, 5);


    public static void mm() {

        List<Integer> h = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> jj = new ArrayList<>(h);
        jj = jj.stream().map(e -> e = e + 2).collect(Collectors.toList());
        jj.forEach(e -> System.out.println(e));
    }


}

