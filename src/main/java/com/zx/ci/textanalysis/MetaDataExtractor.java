package com.zx.ci.textanalysis;

import com.zx.ci.MetaDataVector;

public interface MetaDataExtractor {
    public MetaDataVector extractMetaData(String title, String body);
}
