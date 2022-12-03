public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";

    private final StringBuilder pool;

    public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded) {

        pool = new StringBuilder();

        if (uppercaseIncluded) pool.append(UPPERCASE_LETTERS);

        if (lowercaseIncluded) pool.append(LOWERCASE_LETTERS);

        if (numbersIncluded) pool.append(NUMBERS);
    }


    public String getAlphabet() {
        return pool.toString();
    }
}
