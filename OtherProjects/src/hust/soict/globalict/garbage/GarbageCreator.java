package hust.soict.globalict.garbage;

public class GarbageCreator {
    public static void main(String[] args) {

        String s = "";

        while (true) {
            s += "garbage";  // creates new String every time

            // Optional: print occasionally so you see progress
            if (s.length() % 100000 == 0) {
                System.out.println("Length: " + s.length());
            }
        }
    }
}