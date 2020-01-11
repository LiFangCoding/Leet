package _151_200;

import common.Read4;

/**
 * Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.
 * <p>
 *  
 * <p>
 * Method read4:
 * <p>
 * The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.
 * <p>
 * The return value is the number of actual characters read.
 * <p>
 * Note that read4() has its own file pointer, much like FILE *fp in C.
 * <p>
 * Definition of read4:
 * <p>
 * Parameter:  char[] buf
 * Returns:    int
 * <p>
 * Note: buf[] is destination not source, the results from read4 will be copied to buf[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/read-n-characters-given-read4-ii-call-multiple-times
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _158_ReadNCharactersGivenRead4II_Call_multipletimes extends Read4 {
    int size = 0;
    int i = 0;
    char[] temp = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;

        while (index < n) {
            if (size == 0) {
                size = read4(temp);
                if (size == 0) {
                    break;
                }
            }

            while (index < n && i < size) {
                buf[index++] = temp[i++];
            }

            if (i == size) {
                // 说明临时字符数组中的内容已经读完，size置零以便执行下一次read4操作
                i = 0;
                size = 0;
            }
        }

        return index;
    }
}
