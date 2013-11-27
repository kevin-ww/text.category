package com.zx.classifier.textanalysis.lucene.impl;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class PorterStemStopWordAnalyzer extends Analyzer {
    public static final String [] stopWords = 
        {"and","of","the","to","is","their","can","all","i","in"};
    
    public TokenStream tokenStream(String fieldName, Reader reader) {
        Tokenizer tokenizer = new StandardTokenizer(reader);
        TokenFilter lowerCaseFilter = new LowerCaseFilter(tokenizer);
        TokenFilter stopFilter = new StopFilter(lowerCaseFilter,stopWords);
        TokenFilter stemFilter =  new PorterStemFilter(stopFilter);
        return stemFilter;
    } 
}
