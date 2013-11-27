package com.zx.classifier.textanalysis.lucene.impl;

import com.zx.classifier.textanalysis.InverseDocFreqEstimator;

public class EqualInverseDocFreqEstimator implements InverseDocFreqEstimator {
    public double estimateInverseDocFreq(Tag tag) {
       return 1.0;
    }
    public void addCount(Tag tag){
        
    }
}
