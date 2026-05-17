package hust.soict.globalict.garbage;

public class NoGarbage {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append("garbage");  // no new object each time

            // Optional: print occasionally
            if (sb.length() % 100000 == 0) {
                System.out.println("Length: " + sb.length());
            }
        }
    }
}