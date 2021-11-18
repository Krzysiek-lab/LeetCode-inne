import java.util.*;
import java.util.stream.Collectors;


public class PhoneBook {

    // List.of nie trzeba new i przy Arrays.asList tez nie i tworzone sa nie mutowalne listy
    // Optional.empty() to zwraca pusty Optional nie "";
    // Optionala trzeba zwracac jesli metoda zwraca Optionala chyba ze metoda zwraca Object, mozna zadelkarowac Obejct jako ty zwracany i zrocic Optionala
    // mozna zwrocic Optionala jesli typem zwracanym jest inny obiekt (nie Object) ale trzeba zwrocic z orElse() albo orElseGet(); albo orelseThrow()
    // orElseThrow(() -> new Exception);
    // Optional.ofNullable przyjmuje nulle jako argumenty tez i zwraca pusty optional jak jest null ale nie wyrzuca wyjatku
    // strea.limit() okresla ile obiektow ze streama wyciagnac np. list.steam.limit(1).collect(Collectors.toList); pobierze 1 element z listy czyli pierwszy
    // findAny() i findFirst() ze strrama zwracają Optional
    // moze byc Optional<?> i jako tez typ zwracany

    String name;
    Integer number;


    static PhoneBook inst1 = new PhoneBook("Jos de Vos", 609123456);
    static PhoneBook inst2 = new PhoneBook("An de Toekan", 505444333);
    static PhoneBook inst3 = new PhoneBook("Kris de Vis", 690666888);


    static List<PhoneBook> list = List.of(inst1, inst2, inst3);

    List<PhoneBook> list2 = new ArrayList<>();

    {
        list2.add(inst1);
        list2.add(inst2);
        list2.add(inst3);

    }

    public PhoneBook() {

    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public PhoneBook(String name, Integer Number) {
        this.name = name;
        this.number = Number;
    }

    static void print() {
        System.out.println(list);
    }

    public static Optional<Integer> findPhoneNumberByName(String name) {
        Integer numberph = null;
        for (PhoneBook ph : list) {
            if (ph.name.equals(name)) {
                numberph = ph.number;
            }
        }
        if (numberph == null) {
            return Optional.empty();
        } else return Optional.ofNullable(numberph);
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public static Optional<String> findNameByPhoneNumber(Integer number) {
        String nameph = null;
        for (PhoneBook ph : list) {
            if (ph.number.equals(number)) {
                nameph = ph.name;
            }
        }
        if (nameph == null) {
            return Optional.empty();
        } else return Optional.of(nameph);

    }

    public static PhoneBook findPhoneNumberByNameAndPunishIfNothingFound(String name) {
        Optional<PhoneBook> inst = list.stream().filter(e -> e.name.equals(name)).findAny();
        return inst.orElseThrow(() -> new IllegalArgumentException("No phone number found"));
    }

    public static void findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(Integer number) {
        Optional<PhoneBook> inst = list.stream().filter(e -> e.number.equals(number)).findAny();
        if (inst.isPresent()) {
            System.out.println(inst);
        } else print();
    }

    public static String pesel(Long pesel) throws InvalidPeselException {
        char[] arr = pesel.toString().toCharArray();
        String[] str = new String[arr.length];
        if (pesel.toString().toCharArray().length == 11) {
            char[] arr2 = Arrays.copyOfRange(arr, 0, 7);
            for (int i = 0; i < arr2.length; i++) {
                str[i] = String.valueOf(arr2[i]);
            }
        }
        List<String> lista = new ArrayList<>(Arrays.asList(str));
        lista.removeIf(e -> e == null);
        String[] arr3 = new String[lista.size()];
        arr3 = lista.toArray(new String[0]);

        String value = String.join("", arr3);
        if (value.equals("")) {
            value = null;
        }
        return Optional.ofNullable(value).orElseThrow(() -> new InvalidPeselException("zły pesel"));
    }

    public static PhoneBook findByNumber(Integer number) {
        if (list.stream().anyMatch(e -> e.number.equals(number))) {
            return list.stream().filter(e -> e.number.equals(number)).collect(Collectors.toList()).get(0);
        } else return list.stream().filter(e -> e.name.equals("Jos de Vos")).collect(Collectors.toList()).get(0);
    }

    public static PhoneBook findPhoneNumberByNameOrNameByPhoneNumber(String name, Integer number) {
        Optional<PhoneBook> opt = list.stream().filter(e -> e.name.equals(name)).findAny();
        return opt.orElseGet(() -> findByNumber(number));
    }

    public static PhoneBook mmm() {
        Optional<PhoneBook> o = Optional.of(list.get(0));
        return o.orElseGet(() -> list.get(0)); // nie mozna zwrocic optionala jesli typem zwrcanym jest jakis konkretny obiekt wyjatkiem jent Object!!!
    }

    public static List<PhoneBook> getList() {
        return list;
    }

    public static PhoneBook biggest() {
        PhoneBook inst = new PhoneBook();
        inst.list2.sort(new Comparator<PhoneBook>() {
            @Override
            public int compare(PhoneBook t, PhoneBook t1) {
                return (t.number.compareTo(t1.number));
            }
        });
        return list.get(list.size() - 1);
    }

    public static String join() {
        PhoneBook inst = new PhoneBook();
        List<String> sr = new ArrayList<>();
        inst.list2.stream().map(e -> e.name).forEach(e -> sr.add(e));
        String[] arr = new String[sr.size()];
        arr = sr.toArray(new String[0]);
        return String.join(",", arr);

    }

    public static Map<String, List<Map.Entry<String, PhoneBook>>> groupBuName() {
        PhoneBook inst = new PhoneBook();
        Map<String, PhoneBook> mapa = new HashMap<>();
        mapa = inst.list2.stream().collect(Collectors.toMap(e -> e.name, e -> e));
        return mapa.entrySet().stream().collect(Collectors.groupingBy(e -> e.getKey()));
    }

    public static void main(String[] args) {

        System.out.println(findNameByPhoneNumber(609713456));

        System.out.println(findPhoneNumberByName("Kris de Vis"));

        System.out.println("name and number: " + findPhoneNumberByNameOrNameByPhoneNumber("Anh de Toekan", 905444333));

        System.out.println("biggest: " + biggest());

        System.out.println("join: " + join());

        System.out.println("grupowanie: " + groupBuName().values());

        try {
            System.out.println("pesel: " + pesel(91050806692L));
        } catch (InvalidPeselException e) {
            System.out.println("zlapano pesel");
        }

        try {
            System.out.println(findPhoneNumberByNameAndPunishIfNothingFound("Kris de V"));
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument");
        } finally {
            findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(9);
        }

        LinkedList<Integer> linked = new LinkedList<>();

        LinkedHashSet<Integer> hash = new LinkedHashSet<>();
        hash.add(1);
        hash.add(3);
        hash.add(2);
        hash.add(4);
        hash.add(5);

        Integer v = 0;

        for (Integer k : hash.stream().limit(1).collect(Collectors.toSet())) {
            v = k;
        }
        System.out.println(v);
        System.out.println(hash);

        Set<Integer> se = new HashSet<>();
        se.add(1);
        se.add(12);
        se.add(13);
        se.add(4);

//        System.out.println(list.stream().limit(1).collect(Collectors.toList()));
//        Optional<String> ooo = Optional.of("Sd").or(() -> Optional.of("asd"));
//        System.out.println(ooo.get());

    }
}
