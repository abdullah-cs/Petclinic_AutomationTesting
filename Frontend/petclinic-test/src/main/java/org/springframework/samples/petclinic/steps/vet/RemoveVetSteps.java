package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.vet.AllVetsPage;
import static org.junit.Assert.assertTrue;

public class RemoveVetSteps {
    private final AllVetsPage allVets = new AllVetsPage();

    @Given("I am on the All Veterinarian page")
    public void iAmOnTheAllVeterinarianPage() {
        allVets.navigateToAllPets();
        assertTrue(allVets.isCurrent());
    }

    @When("I click on delete button next to any vet")
    public void iClickOnDeleteButtonNextToAnyVet() {
        allVets.deleteFirst();
    }

    @Then("that vet will be removed from the table")
    public void thatVetWillBeRemovedFromTheTable() {
        assertTrue(allVets.isDeleted());
        allVets.closeBrowser();
    }
}
