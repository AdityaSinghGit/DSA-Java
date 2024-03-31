package formatting_and_others;

public class StringBufferInJava {
    public static void main(String[] args) {
        // constructor 1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        // constructor 2
        StringBuffer sb2 = new StringBuffer("Can pass string in the constructor as well");
        System.out.println(sb2);

        // constructor 3
        // Can specify the capacity of the empty string buffer's object initially.
        StringBuffer sb3 = new StringBuffer(30);
        System.out.println(sb3.capacity());

        sb.append("Testing as string");
        sb.insert(0, "Aditya ");
        sb.replace(7, 8, "t");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        // Removes all spaces
        String name = "A di  t     y       a";
        System.out.println(name.replaceAll("\\s", ""));

    }
}

// String Buffer : It is a mutable sequence of characters in Java.

/*
 * ---------StringBuffer Advantages over String---------
 * 1- MUTABLE : As strings are immutable
 * 2- EFFIIENT : As we don't need to make newer objects everytime
 * 3- THREAD SAFE(slow) : If a thread is already working on a data, it will
 * prevent other threads to work on the same.
 * NOTE: StringBuilder is not thread safe.
 */