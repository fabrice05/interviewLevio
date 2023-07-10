package ca.levio.interview.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public abstract class ManageOrganisationStructure <T>{
  private JpaRepository repository;
  public ManageOrganisationStructure(JpaRepository repository) {
    this.repository=repository;
  }
protected   T save(T s) {
   s= (T) repository.save(s);
    return s;
  }
// qbstrqct T ,qp
    protected T get(UUID id) {
    return (T) repository.getReferenceById(id);
  }

    protected List<T> getAll() {
    return repository.findAll();
  }

    protected T delete(UUID id) {
    T s= get(id);
     repository.deleteById(id);
     return s;
  }
}
