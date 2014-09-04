package io.eddumelendez.jpa.repository;

import io.eddumelendez.jpa.domain.Contact;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dataAccessContext-test.xml")
public class ContactRepositoryIT {
	
	private ContactRepository contactRepository;
	
	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	@Test
	@Rollback(value = true)
	public void should_insert_contact() {
		Contact contact = createContact("Eddu");
		Contact contact2 = createContact("Luisa");
		Contact contact3 = createContact("Fredy");
		Contact contact4 = createContact("Yrene");
		
		contactRepository.save(contact);
		contactRepository.save(contact2);
		contactRepository.save(contact3);
		contactRepository.save(contact4);
		
		long count = contactRepository.count();
		Assert.assertEquals(4, count);
	}
	
	private Contact createContact(String name) {
		Contact contact = new Contact();
		contact.setName(name);
		return contact;
	}
}
