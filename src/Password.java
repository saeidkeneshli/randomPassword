
public class Password {
    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    @Override
    public String toString() {
        return Value;
    }
}
