package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String str;
    public ReversedSequence(String str) {
        StringBuilder sb = new StringBuilder(str);
        this.str = sb.reverse().toString();
    }

    @Override
    public String toString() {
        return  str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.substring(start, end);
    }
}
// END
