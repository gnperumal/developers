package com.gnperumal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Skill javascript = new Skill("javascript", "Javascript language skill");
        Skill ruby = new Skill("ruby", "Ruby language skill");
        Skill emberjs = new Skill("emberjs", "Emberjs framework");
        Skill angularjs = new Skill("angularjs", "Angularjs framework");

        skillRepository.save(javascript);
        skillRepository.save(ruby);
        skillRepository.save(emberjs);
        skillRepository.save(angularjs);

        List<Developer> developers = new LinkedList<Developer>();
        developers.add(new Developer("Narayanaperumal", "Gurusamy", "gnperumal@gmail.com",
                Arrays.asList(new Skill[]{javascript, ruby})));
        developers.add(new Developer("Akroor", "Azhagar", "akroor@gnperumal.com",
                Arrays.asList(new Skill[]{emberjs, ruby})));
        developers.add(new Developer("Michael", "Williams", "michael.williams@gnperumal.com",
                Arrays.asList(new Skill[]{angularjs, ruby})));
        developers.add(new Developer("Fred", "Miller", "f.miller@gnperumal.com",
                Arrays.asList(new Skill[]{emberjs, angularjs, javascript})));
        developers.add(new Developer("Bob", "Brown", "brown@gnperumal.com",
                Arrays.asList(new Skill[]{emberjs})));
        developerRepository.save(developers);
    }

}