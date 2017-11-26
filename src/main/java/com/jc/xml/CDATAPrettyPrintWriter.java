package com.jc.xml;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

import java.io.Writer;

/**
 * 支持CDATA块
 * @author jiangchong
 * @since 2017/11/26 17:34
 * @version 1.0
 */
public class CDATAPrettyPrintWriter extends PrettyPrintWriter {
    @Override
    public void startNode(String name, Class clazz) {
        super.startNode(name, clazz);
    }

    /**
     * 对所有xml节点的转换都增加CDATA标记
     * @param writer 字符流
     * @param text 文本
     */
    @Override
    protected void writeText(QuickWriter writer, String text) {
        writer.write("<![CDATA[");
        writer.write(text);
        writer.write("]]>");
    }

    public CDATAPrettyPrintWriter(Writer writer) {
        super(writer);
    }
}
