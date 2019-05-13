package Sort;

public class IntWrapper {
    public static class MyInt{
        int val;
        public MyInt(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        int a = 1;
        int b = 2;
        MyInt aWrapper = new MyInt(a);
        MyInt bWrapper = new MyInt(b);
        swap(aWrapper, bWrapper);
        System.out.println(aWrapper.val);
        System.out.println(bWrapper.val);
    }

    public static void swap(MyInt a, MyInt b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

}
