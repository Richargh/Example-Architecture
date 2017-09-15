package de.richargh.example.sadaas;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.NameSuffixTypeMatcher;
import com.structurizr.analysis.StructurizrAnnotationsComponentFinderStrategy;
import com.structurizr.analysis.TypeMatcherComponentFinderStrategy;
import com.structurizr.model.Component;
import com.structurizr.model.Container;
import com.structurizr.model.Model;
import com.structurizr.model.SoftwareSystem;

import java.util.HashSet;
import java.util.Set;

public class Architecture {

    private Set<Component> components = new HashSet<>();


    public void analyzer() throws Exception {
        Workspace workspace = new Workspace("Spring PetClinic",
                "This is a C4 representation of the Spring PetClinic sample app (https://github.com/spring-projects/spring-petclinic/)");
        Model model = workspace.getModel();
        SoftwareSystem springPetClinic = model.addSoftwareSystem("Spring PetClinic",
                "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.");
        Container webApplication = springPetClinic.addContainer("Web Application",
                "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.",
                "Java and Spring");
    }

}
