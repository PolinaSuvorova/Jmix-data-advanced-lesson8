package com.company.jmixpm.app;

import com.company.jmixpm.entity.Task;

import javax.persistence.*;

public class TaskJpaListener {
    // private static final Logger log = (Logger) LoggerFactory.getLogger(TaskJpaListener.class);

    @PreUpdate
    @PreRemove
    @PrePersist
    public void beforeUpdate(Task task) {
        //     log.info(task.getClass().getSimpleName() + "before update" + task.getName());
    }

    @PostUpdate
    @PostRemove
    @PostPersist
    public void afterUpdate(Task task) {

        //log.info(task.getClass().getSimpleName() + "after update" + task.getName());
    }
}
