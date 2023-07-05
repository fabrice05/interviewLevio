package ca.levio.interview.controllers;

import ca.levio.interview.services.IManagedOrganisation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public class BaseManagedOrganisationController<T> {
    private final IManagedOrganisation<T> manageOrganisationStructure;

    public BaseManagedOrganisationController(IManagedOrganisation<T> manageOrganisationStructure) {
        this.manageOrganisationStructure = manageOrganisationStructure;
    }

    @GetMapping
    public List<T> getAll() {
        return manageOrganisationStructure.getAllDto();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable UUID id) {
        return manageOrganisationStructure.getDTo(id);
    }

    @PostMapping
    public T create(@RequestBody T s) {
        return manageOrganisationStructure.saveDto(s);
    }

    @PutMapping("/{id}")
    public T updateInterview(@PathVariable UUID id, @RequestBody T s) {
        return manageOrganisationStructure.saveDto(s);
    }

    @DeleteMapping("/{id}")
    public T delete(@PathVariable UUID id) {
       return manageOrganisationStructure.deleteDto(id);
    }
}
