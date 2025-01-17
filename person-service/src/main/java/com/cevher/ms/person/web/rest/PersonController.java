package com.cevher.ms.person.web.rest;

import com.cevher.ms.person.domain.Person;
import com.cevher.ms.person.service.PersonService;
import com.cevher.ms.person.vm.ResponseTempVM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/")
    public Person savePerson(@RequestBody Person person) {
        log.info("savePerson by PersonController");
        return personService.savePerson(person);
    }

    @GetMapping("/")
    public List<Person> findAllPerson() {
        log.info("findAllPerson by PersonController");
        return personService.findAllPerson();
    }

    @GetMapping("/{id}")
    public Person getPersonById(
            @PathVariable("id") Long personId) {
        log.info("getPersonWithDepartment by PersonController");
        return personService.getPersonById(personId);
    }

    @GetMapping("/rel/{id}")
    public ResponseTempVM getPersonWithDepartment(
            @PathVariable("id") Long personId) {
        log.info("getPersonWithDepartment by PersonController");
        return personService.getPersonWithDepartment(personId);
    }

}