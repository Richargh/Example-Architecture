package de.richargh.example.sadaas;

import com.structurizr.*;
import com.structurizr.analysis.*;
import com.structurizr.model.*;
import org.testng.annotations.*;
import static org.mockito.Mockito.*;

@Test
public class StructurizrTest{

    @Test
    public class Reflection{

        @Test
        public void shouldFindAllComponentsInClasspath() throws Exception {
            final int componentCount = 3;
            Container tmp = generateContainer();
            AbstractTypeMatcher test = mock(AbstractTypeMatcher.class);
            ComponentFinder componentFinder = new ComponentFinder(
                    tmp, "de.db", new TypeMatcherComponentFinderStrategy(test));

            componentFinder.findComponents().size();

            verify(test, atLeast(componentCount)).matches(any());
        }
    }

    private static Container generateContainer(){
        Workspace workspace = new Workspace(
                "Spring PetClinic",
                "This is a C4 representation of the Spring PetClinic sample app (https://github.com/spring-projects/spring-petclinic/)");
        Model model = workspace.getModel();
        SoftwareSystem springPetClinic = model.addSoftwareSystem(
                "Spring PetClinic",
                "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.");
        Container webApplication = springPetClinic.addContainer(
                "Web Application",
                "Allows employees to view and manage information regarding the veterinarians, the clients, and their pets.",
                "Java and Spring");
        return webApplication;
    }

}