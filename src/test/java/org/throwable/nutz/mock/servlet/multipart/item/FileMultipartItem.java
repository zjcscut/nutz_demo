package org.throwable.nutz.mock.servlet.multipart.item;





import org.throwable.nutz.mock.servlet.multipart.MultipartItem;
import org.throwable.nutz.mock.servlet.multipart.inputing.InputingHelper;

import java.io.File;

public class FileMultipartItem extends MultipartItem {

    /*
     * public FileMultipartItem(String boundary, String name, File f, String
     * contentType) { super(boundary + "\r\n");
     * addInputing(Inputings.fileName(name, f.getName()));
     * addInputing(Inputings.contentType(contentType));
     * addInputing(Inputings.blankLine()); addInputing(Inputings.file(f));
     * addInputing(Inputings.blankLine()); }
     */

    public FileMultipartItem(    InputingHelper helper,
                                String boundary,
                                String name,
                                File f,
                                String contentType) {
        super(helper, boundary + "\r\n");
        addInputing(helper.fileName(name, f.getName()));
        addInputing(helper.contentType(contentType));
        addInputing(helper.blankLine());
        addInputing(helper.file(f));
        addInputing(helper.blankLine());
    }

}
