package com.zx.classifier.textanalysis;

import java.io.IOException;

public interface PhrasesCache {
    public boolean isValidPhrase(String text) throws IOException;
}
