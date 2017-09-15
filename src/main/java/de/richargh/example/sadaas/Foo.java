
package de.richargh.example.sadaas;

import com.structurizr.*;
import com.structurizr.analysis.*;
import com.structurizr.io.plantuml.PlantUMLWriter;
import com.structurizr.model.*;
import com.structurizr.view.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

import de.richargh.example.sadaas.components.FooComponent;
import de.richargh.example.sadaas.components.TestController;
import net.sourceforge.plantuml.SourceStringReader;

class Foo {
    public static void main(String[] args) throws Exception {
        new FooComponent();
        new TestController();

        System.out.println("Fooo");

        Workspace workspace = new Workspace("Spring PetClinic",
                "This is a C4 representation of the Spring PetClinic sample app (https://github.com/spring-projects/spring-petclinic/)");
        Model model = workspace.getModel();

        // SoftwareSystem springPetClinic = model.addSoftwareSystem("Spring PetClinic",
        //         "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.");
        // Person clinicEmployee = model.addPerson("Clinic Employee", "An employee of the clinic");

        // clinicEmployee.uses(springPetClinic, "Uses");

        // Container webApplication = springPetClinic.addContainer("Web Application",
        //         "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.",
        //         "Java and Spring");
        // Container relationalDatabase = springPetClinic.addContainer("Relational Database",
        //         "Stores information regarding the veterinarians, the clients, and their pets.",
        //         "Relational Database Schema");

        // clinicEmployee.uses(webApplication, "Uses", "HTTPS");
        // webApplication.uses(relationalDatabase, "Reads from and writes to", "JDBC");

        Person user = model.addPerson("User", "A user of my software system.");
        SoftwareSystem softwareSystem = model.addSoftwareSystem("Software System", "My software system.");
        user.uses(softwareSystem, "Uses");

        SoftwareSystem springPetClinic = model.addSoftwareSystem("Spring PetClinic",
                "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.");
        Person clinicEmployee = model.addPerson("Clinic Employee", "An employee of the clinic");
        Container webApplication = springPetClinic.addContainer("Web Application",
                "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.",
                "Java and Spring");

        ViewSet views = workspace.getViews();
        ComponentView componentView = views.createComponentView(webApplication, "Components", null);
        SystemContextView contextView = views.createSystemContextView(softwareSystem, "SystemContext",
                "An example of a System Context diagram");

        final String namespace = "de.richargh.example.sadaas";
        ComponentFinder componentFinder = new ComponentFinder(webApplication, namespace,
                new TypeMatcherComponentFinderStrategy(
                        new NameSuffixTypeMatcher("Controller", "Controller description", "Controller technology"),
                        new NameSuffixTypeMatcher("Repository", "Repository description", "Repository technology")),
                new StructurizrAnnotationsComponentFinderStrategy(),

                new TypeMatcherComponentFinderStrategy(new LoggingTypeMatcher("desc", "tech")));

        Set<Component> components = componentFinder.findComponents();
        System.out.println("Found " + components.size() + " components");

        webApplication.addComponent("Home Page Controller", "Serves up the home page.", "manually added controller");

        // create views
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        // components.forEach(componentView::add);
        componentView.addAllElements();

        // write to file
        StringWriter stringWriter = new StringWriter();
        PlantUMLWriter plantUMLWriter = new PlantUMLWriter();
        plantUMLWriter.write(componentView, stringWriter);

        String diagram = stringWriter.toString();
        System.out.println("Diagram");
        System.out.println(diagram);

        writeToFile("newfile.txt", diagram);
        diagram = String.join("\n", Files.readAllLines(new File("oldfile.txt").toPath(), Charset.defaultCharset()));
        writeImageToFile("newfile.png", diagram);
    }

    private static void writeToFile(String fileName, String diagram) throws IOException {
        System.out.println("Saving Diagram in Textform");
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter txt = new PrintWriter(file)) {
            txt.println(diagram);
        }
    }

    private static void writeImageToFile(String fileName, String diagram) throws IOException {
        System.out.println("Saving Diagram as Image");
        SourceStringReader reader = new SourceStringReader(diagram);
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (OutputStream png = new FileOutputStream(file)) {
            String desc = reader.generateImage(png);
            System.out.println(desc);
        }
    }

    private class BlubComponent {
        
    }
}