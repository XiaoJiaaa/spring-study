public class DemoMain {

    public static void main(String[] args) {
        // 斐波那契数列
        int fibonacciIndex = 9;
        int fibonacciResult = fibonacci(fibonacciIndex);
        System.out.println("下标(从0开始)" + fibonacciIndex + "的值为：" + fibonacciResult);
    }
    /**
     * 斐波那契数列
     * @param index 斐波那契数列的下标（从0开始）
     * @return int
     */
    private static int fibonacci(int index) {
        System.out.println(index);
        if (index == 0 || index == 1) {
            System.out.println("return:"+index);
            return index;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }

}
