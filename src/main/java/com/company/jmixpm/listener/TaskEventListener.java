package com.company.jmixpm.listener;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TaskEventListener {

    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onTaskChangedBeforeCommit(final EntityChangedEvent<Task> event) {
        Project project = null;
        if (event.getType() == EntityChangedEvent.Type.DELETED) {
            Id<Project> id = event.getChanges().getOldReferenceId("project");
            if (id != null) {
                project = dataManager.load(id).one();
            }
        } else {
            Task task1 = dataManager.load(event.getEntityId()).one();
            project = task1.getProject();
        }
        if (project == null) return;

        int totalEstimatedEfforts = project.getTasks().stream()
                .mapToInt(task ->
                        task.getEstimatedEfforts() == null ?
                                0 : task.getEstimatedEfforts())
                .sum();

        project.setTotalEstimatedEfforts(totalEstimatedEfforts);
        dataManager.save(project);
    }
}