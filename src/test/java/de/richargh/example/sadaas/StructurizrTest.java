package de.richargh.example.sadaas;

import com.structurizr.*;
import com.structurizr.analysis.*;
import com.structurizr.model.*;
import org.testng.annotations.*;
import static org.mockito.Mockito.*;

@Test
public class StructurizrTest {

    @Test
    public class RelevantClassesAreFoundViaReflection{

        @Test
        public void findAtLeastAllComponentsInClasspath() throws Exception {
            final int componentCount = 3;
            final String namespace = "de.richargh.example.sadaas";
            Container tmp = generateContainer();
            AbstractTypeMatcher test = mock(AbstractTypeMatcher.class);
            ComponentFinder componentFinder = new ComponentFinder(
                    tmp, namespace, new TypeMatcherComponentFinderStrategy(test));

            componentFinder.findComponents().size();

            verify(test, atLeast(componentCount)).matches(any());
        }
    }

    @Test
    public class AComponentDiagram{

        @Test
        public void doesNotCrash() throws Exception {
            StructurizrSimple.main(new String[0]);
        }
    }

    private static Container generateContainer(){
        Workspace workspace = new Workspace(
                "Project name",
                "This is test project");
        Model model = workspace.getModel();
        SoftwareSystem springPetClinic = model.addSoftwareSystem(
                "System name",
                "description");
        Container webApplication = springPetClinic.addContainer(
                "Web Application",
                "Allows people to....",
                "Java");
        return webApplication;
    }

}