package zw.co.muzvidzwa.afm;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("zw.co.muzvidzwa.afm");

        noClasses()
            .that()
            .resideInAnyPackage("zw.co.muzvidzwa.afm.service..")
            .or()
            .resideInAnyPackage("zw.co.muzvidzwa.afm.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..zw.co.muzvidzwa.afm.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
