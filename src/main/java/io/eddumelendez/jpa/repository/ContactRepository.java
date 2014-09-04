package io.eddumelendez.jpa.repository;

import io.eddumelendez.jpa.domain.Contact;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	Contact findByName(String name);

}
