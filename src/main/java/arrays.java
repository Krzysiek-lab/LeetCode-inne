import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class arrays {

    public static void main(String[] args) {

        Integer[] tab1 = {1, 2, 4, 7, 12, 5, 88, 8, 0, 33, 3};
        Integer[] tab2 = {1, 2, 2, 3, 6, 6, 4, 7, 12, 5, 88, 8, 0, 33, 3, 1111};
        Integer[] tab3 = {1, 0, 1, 0, 0, 0, 1, 1, 1};
        Integer[] tab4 = {49, 1, 3, 200, 2, 4, 70, 5};
        String[] strr = {"c", "g", "a", "r", "b"};
        Integer[] tab5 = {1, -2, 0, 5, -1, -4};
        Integer[] tab7 = {1, 2, 0, 5, 4};
        Integer[] tab6 = new Integer[]{1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14};
        System.out.println(Arrays.toString(sort(tab1)));
        System.out.println(Arrays.toString(sort(strr)));


        System.out.println(sum(tab1));
        grid();

        System.out.println(avrege(tab1));

        System.out.println(contains(tab1, 88));

        System.out.println(find(strr, "g"));

        System.out.println(Arrays.toString(remove(tab1, 7)));

        findMaxAndMin(tab1);
        System.out.println(Arrays.toString(reverse(tab1)));
        System.out.println("duplicates: " + findDuplicate(tab2));
        System.out.println("common: " + findCommon(tab1, tab2));

        System.out.println("pairs: " + pairs(tab1, 12).entrySet());
        System.out.println(Arrays.toString(segregate(tab3)));
        System.out.println("longest: " + Arrays.toString(longestCon(tab4)));
        System.out.println("SumN: " + sumN(tab4, 6));

        System.out.println("triplets: " + triplets(tab5, 2));
        System.out.println("sortedInReverse: " + Arrays.toString(sortReverse(tab5)));
        System.out.println("rearrange: " + Arrays.toString(rearrange(tab6)));
        System.out.println("biggest: " + biggest(tab7));
    }


    public static <T> T[] sort2(T[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static Object[] sort(Object[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static <T> int sum(T[] arr) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = value + ((Integer) arr[i]);
        }
        return value;
    }

    public static void grid() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print("- ");
            }
            System.out.println();
        }
    }

    public static <T> float avrege(T[] arr) {
        float value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = value + ((Integer) arr[i]);
        }
        return (value / arr.length);
    }

    public static <T> boolean contains(T[] arr, T t) {
        List<T> tab = Arrays.asList(arr);
        return tab.contains(t);
    }

    public static <T> int find(T[] arr, T t) {
        return Arrays.binarySearch(arr, t);
    }

    public static <T> T[] remove(T[] arr, T t) {
        List<T> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(t);
        arr = (T[]) list.toArray();
        return arr;
    }

    public static <T> void findMaxAndMin(T[] arr) {
        Arrays.sort(arr);
        T max = arr[arr.length - 1];
        T min = arr[0];

        System.out.println("max: " + max + " " + "min: " + min);
    }

    public static <T> T[] reverse(T[] arr) {
        T[] arr2 = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[arr.length - (i + 1)];
        }
        return arr2;
    }

    public static <T> List<T> findDuplicate(T[] arr) {
        //T[] arr2 = Arrays.stream(arr).distinct().toArray(size -> new T[size]);

        List<T> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].equals(arr[j]) && j != i) {
                    list.add((T) Array.get(arr, j));
                }
            }
        }
        return list;
    }

    public static <T> List<T> findCommon(T[] arr, T[] arr2) {
        List<T> list1 = new ArrayList<>(Arrays.asList(arr));
        List<T> list2 = new ArrayList<>(Arrays.asList(arr2));
        list1.removeIf(e -> !list2.contains(e));
        return list1;
    }

    public static <T> List<T> removeDuplicate(T[] arr) {
        List<T> list = new ArrayList<>(Arrays.asList(arr));
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static <T> T SecondLargest(T[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    public static <T> T SecondSmallest(T[] arr) {
        Arrays.sort(arr);
        return arr[2];
    }

    public static Integer[] toArray(List<Integer> arr) {
        Integer[] arr2 = new Integer[arr.size()];
        arr2 = arr.toArray(new Integer[0]);
        return arr2;
    }

    public static <T> boolean equals(T[] arr, T[] arr2) {
        return Arrays.equals(arr2, arr);
    }

    public static <T extends Number> Map<T, T> pairs(T[] arr, int value) {
        Map<T, T> mapa = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].intValue() + arr[j].intValue() == value) {
                    mapa.put(arr[i], arr[j]);
                }
            }
        }
        return mapa;
    }

    public static <T extends Number> T[] segregate(T[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static Integer[] longestCon(Integer[] arr) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(arr));
        List<List<Integer>> lista2 = new ArrayList<>();
        for (int k = 0; k < arr.length; k++) {
            lista2.add(k, new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            lista2.get(i).add(arr[i]);
            for (int j = 0; j < arr.length; j++) {
                if (lista.contains(arr[i] + j + 1)) {
                    lista2.get(i).add(arr[i] + j + 1);
                } else {
                    break;
                }
            }
            Iterator<Integer> iterator = lista2.get(i).iterator();
            if (iterator.hasNext() && iterator.next() == null) {
                iterator.remove();
            }
        }
        lista2.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> ts, List<Integer> t1) {
                return ts.size() > t1.size() ? 1 : (ts.size() < t1.size() ? -1 : 0);
            }
        });
        Integer[] tabs = new Integer[lista2.size()];
        List<Integer> lista3 = lista2.get(lista2.size() - 1);
        tabs = lista3.toArray(new Integer[0]);

        return tabs;
    }

    public static <T extends Number> String sumN(T[] arr, Integer given) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                if ((Integer) arr[i] + (Integer) arr[j] == given) {
                    mapa.put((Integer) arr[i], (Integer) arr[j]);
                }
        }
        return mapa.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors
                .toMap(e -> e.getKey(), x -> x.getValue())).toString().
                replaceAll("[\\[\\](){}]", "").replaceAll("=", " i ");
    }

    public static <T extends Number> String triplets(T[] arr, Integer given) {
        Map<Integer, String> mapa = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                for (int k = 0; k < arr.length; k++) {
                    if ((Integer) arr[i] <= (Integer) arr[j] && (Integer) arr[j] <= (Integer) arr[k]
                            && (Integer) arr[i] + (Integer) arr[j] + (Integer) arr[k] == given && i != j && j != k && i != k) {
                        mapa.put((Integer) arr[i], String.valueOf(String.valueOf(arr[j]) + " i " + String.valueOf(arr[k])));
                    }
                }
        }
        return mapa.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors
                .toMap(e -> e.getKey(), x -> x.getValue())).toString().
                replaceAll("[\\[\\](){}]", "").replaceAll("=", " i ")
                .replaceAll(",", " |");
    }

    public static Integer[] sortReverse(Integer[] arr) {
        Arrays.sort(arr);
        Arrays.sort(arr, Comparator.reverseOrder());
        return arr;
    }

    public static Integer[][] createAnArray(int one, int two) {
        Integer[][] arr = new Integer[one][two];
        return arr;
    }

    public static Integer getTotal(Integer[][] arr) {
        int totalValue = 0;
        for (Integer[] tab : arr) {
            totalValue = totalValue + Arrays.stream(tab).reduce(0, (a, b) -> a + b);
        }
        return totalValue;
    }

    public static float getAverage(Integer[][] arr) {
        int totalValue = 0;
        int totalSize = 0;
        for (Integer[] tab : arr) {
            totalValue = totalValue + Arrays.stream(tab).reduce(0, (a, b) -> a + b);
            totalSize = totalSize + tab.length;
        }
        return (float) totalValue / totalSize;
    }

    public static Integer[] rearrange(Integer[] arr) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(lista);
        for (int i = 1; i < arr.length; i = i + 2) {
            if (lista.get(i) < lista.get(i + 1) && i + 2 < arr.length) {
                int index1 = lista.indexOf(lista.get(i + 1));
                int index2 = lista.indexOf(lista.get(i));
                Collections.swap(lista, index1, index2);
            }
        }
        int index = lista.indexOf(lista.get(lista.size() - 1));
        int index2 = lista.indexOf(lista.get(lista.size() - 2));
        if (lista.get(index) > lista.get(index2)) {
            Collections.swap(lista, index, index2);
        }
        return lista.toArray(new Integer[0]);
    }

    public static Integer[] shuffle(Integer[] arr) {
        List<Integer> lista = new ArrayList<>(Arrays.asList(arr));
        Collections.shuffle(lista);
        return lista.toArray(new Integer[0]);
    }

    public static String biggest(Integer[] arr) {
        Arrays.sort(arr, Comparator.reverseOrder());
        StringBuilder end = new StringBuilder();
        for (Integer v : arr) {
            end.append(String.valueOf(v));
        }
        return new String(end);
    }

}






