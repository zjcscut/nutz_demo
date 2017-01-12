package org.throwable.nutz.mock.servlet.multipart.inputing;

import org.nutz.lang.Streams;

import java.io.*;

public class FileInputing implements Inputing {

    private InputStream ins;
    private File file;
    private long length;

    public FileInputing(File f) throws FileNotFoundException {
        length = f.length();
        file = f;
    }

    public int read() throws IOException {
        return ins.read();
    }

    public long size() {
        return length;
    }

    public void close() throws IOException {
        ins.close();
    }

    public void init() throws IOException {
        ins = new BufferedInputStream(Streams.fileIn(file));
    }

}
