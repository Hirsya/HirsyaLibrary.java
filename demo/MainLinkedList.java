import HirsyaLibrary.linkedlist.HirsyaLinkedList;

public class MainLinkedList {
    public static void main(String[] args) {
        HirsyaLinkedList<String> list = new HirsyaLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Isi list  : " + list);
        System.out.println("Size      : " + list.size());
        System.out.println("First     : " + list.getFirst());
        System.out.println("Last      : " + list.getLast());
        System.out.println("getAt(1)  : " + list.getAt(1));
        System.out.println("Empty     : " + list.isEmpty());

        list.addFirst("Z");
        System.out.println("addFirst  : " + list);

        list.insertAt(2, "X");
        System.out.println("insertAt  : " + list);

        System.out.println("contains B: " + list.contains("B"));
        System.out.println("indexOf C : " + list.indexOf("C"));

        System.out.println("delete B  : " + list.delete("B") + " -> " + list);
        System.out.println("delete Q  : " + list.delete("Q"));

        list.delete("Z");
        list.delete("C");
        System.out.println("Setelah hapus depan & belakang: " + list);

        list.clear();
        System.out.println("Setelah clear: size=" + list.size() + " empty=" + list.isEmpty());

        list.add("baru");
        System.out.println("Tambah lagi  : " + list);

        try {
            list.getAt(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception    : " + e.getMessage());
        }

        HirsyaLinkedList<Integer> numbers = new HirsyaLinkedList<>();
        numbers.add(10);
        numbers.add(20);
        System.out.println("Integer list : " + numbers + " contains 10=" + numbers.contains(10));
    }
}
