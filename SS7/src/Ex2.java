public class Ex2 {
    public static void main(String[] args) {
        StringBuilder str= new StringBuilder("Hello, Java World!");
        System.out.println("Chuỗi ban đầu :"+str.toString());
        str.delete(5,9);
        System.out.println("Sau khi xóa:" +str.toString());
        str.replace(8,14,"Universe");
        System.out.println("Sau khi thay thế: "+str.toString());
    }
}
