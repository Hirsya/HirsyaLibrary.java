import HirsyaLibrary.stack.HirsyaStack;
import HirsyaLibrary.stack.EmptyStackException;

public class MainStack {
    public static void main(String[] args) {
        HirsyaStack<Integer> s = new HirsyaStack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Isi stack : " + s);
        System.out.println("Size      : " + s.size());
        System.out.println("Peek      : " + s.peek());
        System.out.println("Empty     : " + s.isEmpty());

        System.out.println("Pop       : " + s.pop());
        System.out.println("Pop       : " + s.pop());
        System.out.println("Peek      : " + s.peek());
        System.out.println("Sisa      : " + s);

        s.clear();
        System.out.println("Setelah clear: size=" + s.size() + " empty=" + s.isEmpty());

        s.push(9);
        System.out.println("Tambah lagi  : " + s + " size=" + s.size());

        s.pop();
        System.out.println("Kosong       : size=" + s.size() + " empty=" + s.isEmpty());

        try {
            s.pop();
        } catch (EmptyStackException e) {
            System.out.println("Exception    : " + e.getMessage());
        }

        HirsyaStack<String> words = new HirsyaStack<>();
        words.push("a");
        words.push("b");
        System.out.println("String stack : " + words + " peek=" + words.peek());
    }
}
