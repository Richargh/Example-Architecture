
package de.richargh.example.sadaas;

import com.structurizr.analysis.AbstractTypeMatcher;

public class LoggingTypeMatcher extends AbstractTypeMatcher {
    
        public LoggingTypeMatcher(String description, String technology) {
            super(description, technology);
        }
    
        @Override
        public boolean matches(Class type) {
            System.out.println("Supplied with "+type.getSimpleName());
            return false;
        }
    
    }