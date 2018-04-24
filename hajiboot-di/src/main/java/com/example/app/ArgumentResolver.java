package com.example.app;

import java.io.InputStream;

public interface ArgumentResolver {
    Argument resolver(InputStream stream);
}
