package com.company.jmixpm.listener;

import com.company.jmixpm.entity.User;
import io.jmix.core.event.EntityChangedEvent;
import io.jmix.core.event.EntityLoadingEvent;
import io.jmix.core.event.EntitySavingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserEventListener {
    private static final Logger log = LoggerFactory.getLogger(UserEventListener.class);

    @EventListener
    public void onUserLoading(final EntityLoadingEvent<User> event) {
        log.info("Entity Loading " + event.getEntity());
    }

    @EventListener
    public void onUserSaving(final EntitySavingEvent<User> event) {
        log.info("Entity Saving " + event.getEntity());
    }

    @EventListener
    public void onUserChangedBeforeCommit(final EntityChangedEvent<User> event) {
        log.info("Entity ChangedBeforeCommit " + event.getEntityId());
    }

    @TransactionalEventListener
    public void onUserChangedAfterCommit(final EntityChangedEvent<User> event) {
        log.info("Entity ChangedAfterCommit " + event.getEntityId());
    }
}