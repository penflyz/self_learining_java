public class StudyJava {
    public static void main(String[] args) {
        int arr[] = {1,6,3,5,7};
        ArrayMaoPao arrayMaoPao = new ArrayMaoPao();
        arrayMaoPao.way(arr);
        System.out.println("冒泡排序从小到大结果");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class ArrayMaoPao {
    public void way(int a[]) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}