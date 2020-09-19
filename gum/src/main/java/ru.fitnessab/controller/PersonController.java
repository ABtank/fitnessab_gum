package ru.fitnessab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fitnessab.persist.entity.Growth;
import ru.fitnessab.persist.entity.Person;
import ru.fitnessab.persist.entity.Waist;
import ru.fitnessab.persist.entity.Weigth;
import ru.fitnessab.persist.repo.GrowthRepository;
import ru.fitnessab.persist.repo.PersonRepository;
import ru.fitnessab.persist.repo.WaistRepository;
import ru.fitnessab.persist.repo.WeigthRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GrowthRepository growthRepository;

    @Autowired
    private WaistRepository waistRepository;

    @Autowired
    private WeigthRepository weigthRepository;

    @GetMapping
    public String allPerson(Model model) {
        List<Person> people = personRepository.findAll();
        model.addAttribute("persons", people);
        return "persons";
    }

    @GetMapping("/{id}")
    public String editPerson(@PathVariable("id") Integer id, Model model) {
        Person person = personRepository.findById(id).get();
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/create")
    public String createPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person";
    }

    @PostMapping("/update")
    public String updatePerson(Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person";
        }
        personRepository.save(person);
        return "redirect:/person";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id, Model model) {
        Person person = personRepository.findById(id).get();
        model.addAttribute("person", person);
        return "person_delete";
    }

    @PostMapping("/delete")
    public String deletePerson(Person person) {
        personRepository.delete(person);
        return "redirect:/person";
    }

    @GetMapping("/measurements/{id}")
    public String goPersonMeasurements(@PathVariable("id") Integer id, Model model) {
        Person person = personRepository.findById(id).get();
        Growth growth = new Growth();
        Waist waist = new Waist();
        Weigth weigth = new Weigth();
        model.addAttribute("person", person);
        model.addAttribute("growth", growth);
        model.addAttribute("waist", waist);
        model.addAttribute("weigth", weigth);
        return "person_measurements";
    }

    @PostMapping("/measurements")
    public String addPersonMeasurements(Person person, Growth growth, Waist waist, Weigth weigth, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person";
        }
//        personRepository.save(person);
        growthRepository.save(growth);
//        weigthRepository.save(weigth);
//        waistRepository.save(waist);
        return "redirect:/person";
    }
}
