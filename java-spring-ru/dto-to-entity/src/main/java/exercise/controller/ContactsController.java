package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody ContactCreateDTO contactData) {
        var contact = toEntity(contactData);
        contactRepository.save(contact);
        return toDTO(contact);
    }

    public ContactDTO toDTO(Contact contact) {
        var contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setPhone(contact.getPhone());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setCreatedAt(contact.getCreatedAt());
        contactDTO.setUpdatedAt(contact.getUpdatedAt());
        return contactDTO;
    }
    public Contact toEntity(ContactCreateDTO contactDTO) {
        var contact = new Contact();
        contact.setPhone(contactDTO.getPhone());
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        return contact;
    }
    // END
}
