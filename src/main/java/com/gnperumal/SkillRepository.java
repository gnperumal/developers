package com.gnperumal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    public List<Skill> findByLabel(String label);
}
