package lesson.design.patterns.builder;

import org.testng.annotations.Test;

public class ContactBuilderTest {

    @Test
    public void contactBuilderTest() {
        Contact mike = Contact.builder()
                .setFirstName("Mike")
                .setLastName("Brown")
                .setDateOfBirth("01-01-1980")
                .build();
        System.out.println(mike);
    }
}
