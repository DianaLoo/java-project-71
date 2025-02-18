package hexlet.code.formatters;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import java.io.IOException;

public class MyPrettyPrinter extends DefaultPrettyPrinter {
    @Override
    public DefaultPrettyPrinter createInstance() {
        return new MyPrettyPrinter();
    }
    @Override
        public void writeObjectFieldValueSeparator(JsonGenerator jg) throws IOException {
        jg.writeRaw(": ");
    }
}

