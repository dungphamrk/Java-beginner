public class Ex6 {
    public static void main(String[] args) {
        int [] originalArray={1,1,1,1,2,2,2,2,3,3,5,5,66,7,8,5,4};
        int [] markingArray=new int[1000];
        for (int i = 0; i < markingArray.length; i++) {
            markingArray[i]=0;
        }
        for(int value:originalArray){
            markingArray[value]++;
        }
        int maxCountNumber=0;
        for (int i = 0; i < markingArray.length; i++) {
            if(markingArray[i]>maxCountNumber){
                maxCountNumber=markingArray[i];
            }
        }
        for(int i=0;i<markingArray.length;i++){
            if(markingArray[i]==maxCountNumber){
                System.out.printf("Phần tử %d, Số lần xuất hiện: %d%n", i, markingArray[i]);
            }
        }
    }
}
