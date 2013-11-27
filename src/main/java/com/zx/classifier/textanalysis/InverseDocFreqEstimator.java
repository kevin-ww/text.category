package com.zx.classifier.textanalysis;

public interface InverseDocFreqEstimator {
    public double estimateInverseDocFreq(Tag tag);
    public void addCount(Tag tag);
}
