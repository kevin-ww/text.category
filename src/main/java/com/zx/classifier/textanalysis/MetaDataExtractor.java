package com.zx.classifier.textanalysis;

import com.zx.classifier.MetaDataVector;

public interface MetaDataExtractor {
    public MetaDataVector extractMetaData(String title, String body);
}
