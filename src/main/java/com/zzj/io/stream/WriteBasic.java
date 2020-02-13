package com.zzj.io.stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Jone
 * @version 1.0.0
 * @Description 字符流写
 * @createTime 2020年02月14日 00:18
 *
 * 输出字符数组：public void write​(char[] cbuf) throws IOException；
 * 输出字符串：public void write​(String str) throws IOException；
 * 追加内容：public Writer append​(CharSequence csq) throws IOException；
 *
 */
public class WriteBasic {
    public static void main(String[] args) throws IOException {
        String pathName = "/Users/zujiangzou/Desktop/demotest/test.txt";
        File file = new File(pathName);
        Writer writer = new FileWriter(file);
        writer.write("iamyaoyao");
        writer.append("iamjone");
        writer.close();
    }
}
/**
 * 在使用OutputStream进行输出时，
 * 如果没有使用close()方法关闭输出流会发现内容依然可以正常的输出；
 * 在使用Writer进行输出时，如果没有使用close()方法关闭输出，
 * 内容将无法进行输出，因为Writer使用到了缓冲区，当使用close()方法时实际上会强制刷新缓冲区，
 * 将内容进行输出，如果没有关闭，那么将无法进行输出操作，
 * 如果此时想要在不关闭的情况下将缓冲区的内容进行输出，
 * 可以使用flush()方法强制刷新缓冲区，写入内容。
 * 而字节流在进行输出处理时并不会使用到缓冲区，使用缓冲区的字符流更加适合于中文数据处理，
 * 所以在日后的开发中，如果涉及包含中文信息的输出，一般都会使用字符流进行处理，
 * 但是从另一个角度上，字节流和字符流的基本处理形式是相似的，
 * 由于IO大多情况下都是进行数据的传输使用（二进制），所以字节流也是非常重要的。
 *
 */
