/**
 * 
 */
package com.zx.classifier.tagcloud.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.zx.classifier.tagcloud.FontSizeComputationStrategy;
import com.zx.classifier.tagcloud.TagCloud;
import com.zx.classifier.tagcloud.TagCloudElement;
import com.zx.classifier.tagcloud.VisualizeTagCloudDecorator;
import com.zx.classifier.tagcloud.impl.HTMLTagCloudDecorator;
import com.zx.classifier.tagcloud.impl.LinearFontSizeComputationStrategy;
import com.zx.classifier.tagcloud.impl.LogFontSizeComputationStrategy;
import com.zx.classifier.tagcloud.impl.TagCloudElementImpl;
import com.zx.classifier.tagcloud.impl.TagCloudImpl;


/**
 * @author salag1
 *
 */
public class TagCloudTest extends TestCase {
    
    public void testTagCloud() throws Exception {
        String firstString = "binary";
        int numSizes = 3;
        String fontPrefix = "font-size: ";
 
        List<TagCloudElement> l = new ArrayList<TagCloudElement>();
        l.add(new TagCloudElementImpl("tagging",1));
        l.add(new TagCloudElementImpl("schema",3));
        l.add(new TagCloudElementImpl("denormalized",1));
        l.add(new TagCloudElementImpl("database",2));
        l.add(new TagCloudElementImpl(firstString,1));
        l.add(new TagCloudElementImpl("normalized",1));
        
        FontSizeComputationStrategy strategy = 
            new LinearFontSizeComputationStrategy(numSizes,fontPrefix);
        TagCloud cloudLinear = new TagCloudImpl(l,strategy);
        System.out.println(cloudLinear);
        strategy = new LogFontSizeComputationStrategy(numSizes,fontPrefix);
        TagCloud cloudLog = new TagCloudImpl(l,strategy);
        System.out.println(cloudLog);
        List<TagCloudElement> elements = cloudLinear.getTagCloudElements();
        //Check the sort order
        assertTrue("First tag should be " + firstString,
                firstString.equals(elements.get(0).getTagText()));
        //Schema should be the 5th element and font size should be (numSizes-1)
        assertTrue("Fifth tag should be " + "schema",
                "schema".equals(elements.get(4).getTagText()));
        String expectedFont = fontPrefix + (numSizes-1);
        assertTrue("Fifth tag font should be " + expectedFont,
                expectedFont.equals(elements.get(4).getFontSize()));
        //write to file
        String fileName = "testTagCloudChap2.html";
        writeToFile(fileName,cloudLinear);
    }
    
    private static void writeToFile(String fileName, TagCloud cloud) 
        throws IOException {
        BufferedWriter out = new BufferedWriter(
                new FileWriter(fileName));
        VisualizeTagCloudDecorator decorator = new HTMLTagCloudDecorator();
        out.write(decorator.decorateTagCloud(cloud));
        out.close();
    }
}
