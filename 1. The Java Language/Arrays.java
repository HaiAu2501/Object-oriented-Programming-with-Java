@SuppressWarnings("unused")
public class Arrays {
    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        // Mảng là một kiểu dữ liệu dùng để lưu trữ nhiều giá trị cùng kiểu dữ liệu.
        // Mảng trong Java có độ dài cố định và không thể thay đổi sau khi đã khởi tạo.

        // Khai báo (declaration) mảng các số nguyên
        int[] arrayOfInts; // Cách 1
        float arrayOfFloats[]; // Cách 2 (giống C)

        // Khởi tạo (initialization) mảng
        /*
         * Toán tử new được sử dụng để tạo một mảng mới.
         * Cú pháp: new kiểu_dữ_liệu[số_phần_tử]
         */
        arrayOfInts = new int[5]; // Mảng arrayOfInts có 5 phần tử kiểu int

        // Kích thước của mảng (số phần tử) được lưu trong thuộc tính length
        System.out.println(arrayOfInts.length); // In ra 5

        // Phương thức sao chép mảng
        int[] sourceArray = { 1, 2, 3, 4, 5 };
        int[] destArray = new int[5];

        System.arraycopy(sourceArray, 0, destArray, 0, 5);

        for (int i = 0; i < destArray.length; i++) {
            System.out.println(destArray[i]);
        }

        // Mảng ẩn danh (anonymous array) là một mảng không cần tên
        // Ví dụ sử dụng phương thức sumOfArray để tính tổng mảng ẩn danh
        int sum = sumOfArray(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(sum); // In ra 15

        // Mảng đa chiều (multidimensional array)
        int[][] matrix = new int[2][3]; // Mảng 2 chiều 2x3
    }
}
