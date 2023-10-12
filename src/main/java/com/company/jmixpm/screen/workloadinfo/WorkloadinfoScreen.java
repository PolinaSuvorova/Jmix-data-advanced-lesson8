package com.company.jmixpm.screen.workloadinfo;

import io.jmix.core.KeyValueMapper;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.ui.action.Action;
import io.jmix.ui.model.KeyValueContainer;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("WorkloadinfoScreen")
@UiDescriptor("workloadinfo-screen.xml")
public class WorkloadinfoScreen extends Screen {
    @Autowired
    private KeyValueContainer workloadDc;
    public WorkloadinfoScreen withItem(KeyValueEntity item){
        workloadDc.setItem(item);
        return this;
    }

    @Subscribe("closeWindow")
    public void onCloseWindow(final Action.ActionPerformedEvent event) {
        closeWithDefaultAction();

    }

}