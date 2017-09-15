package de.richargh.example.sadaas;

import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.NameSuffixTypeMatcher;
import com.structurizr.analysis.StructurizrAnnotationsComponentFinderStrategy;
import com.structurizr.analysis.TypeMatcherComponentFinderStrategy;
import com.structurizr.model.Container;

public class ArchitectureComponentFinder {

    private final Container container;
    private int componentCount;

    public ArchitectureComponentFinder(Container container){
        this.container = container;
    }

    public void analyze() throws Exception {
        ComponentFinder componentFinder = new ComponentFinder(container, "de.db",
                new TypeMatcherComponentFinderStrategy(
                        new NameSuffixTypeMatcher("Controller", "Controller description", "Controller technology"),
                        new NameSuffixTypeMatcher("Repository", "Repository description", "Repository technology")),
                new StructurizrAnnotationsComponentFinderStrategy(),
                new TypeMatcherComponentFinderStrategy(new LoggingTypeMatcher("desc", "tech")));

        componentCount = componentFinder.findComponents().size();
    }

    public int componentCount() {
        return componentCount;
    }

}
