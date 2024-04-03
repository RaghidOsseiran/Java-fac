import java.time.LocalTime;
import java.util.Objects;

/**
 * One other Business object class
 */
public class AnotherBo implements Comparable {
    private String name;
    private String address;
    private String birthDate;

    public AnotherBo(String name, String address, String birthDate) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof AnotherBo) {
            AnotherBo anotherBo = (AnotherBo) o;
            return Objects.equals(name, anotherBo.name) &&
                    Objects.equals(address, anotherBo.address) &&
                    Objects.equals(birthDate, anotherBo.birthDate);
        }
        return false;
    }

    @Override
    public int hashCode() {
//        LocalTime now = LocalTime.now();
//        return now.getSecond(); // this messes around with the hash of the key, so after a sleep thread if the time is not done correctly, it will say that the hashmap doesnt
        // contain the key
        return name.hashCode() + birthDate.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof AnotherBo)) {
            return -1;
        }
        if (o != null && o.equals(o)) {
            return 0;
        } else {
            AnotherBo bo = (AnotherBo) o;
            return name.compareTo(bo.name);
        }
    }
}
