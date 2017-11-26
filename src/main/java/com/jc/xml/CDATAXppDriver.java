package com.jc.xml;

import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.io.Writer;

/**
 * 支持CDATA块
 * @author jiangchong
 * @since 2017/11/26 17:33
 * @version 1.0
 */
public class CDATAXppDriver extends XppDriver {
    @Override
    public HierarchicalStreamWriter createWriter(Writer out) {
        return new CDATAPrettyPrintWriter(out);
    }
}
