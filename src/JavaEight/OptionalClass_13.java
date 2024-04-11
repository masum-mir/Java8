package JavaEight;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalClass_13 {
    public static void main(String[] args) {

        Optional<String> name = getName(10);

        if(name.isPresent()) {
           System.out.println(name.get());
        }
        name.ifPresent(System.out::println);

        Optional<String> status = getStatus(10);
        String convert = status.isPresent() ? status.get() : "Default";
        convert = status.orElse("Default");
        convert = status.orElseGet(()-> "Default");
        convert = status.orElseThrow(NoSuchElementException::new);
        System.out.println(convert);

        Optional<String> st = getStatus(11);
        Optional<String> s = st.map(x -> x.toUpperCase());
        s.ifPresent(System.out::println);

    }

    private static Optional<String> getName(int id) {
        String name = null;
        return Optional.ofNullable(name);
    }
    private static Optional<String> getStatus(int id) {

        return Optional.empty();
    }
}
