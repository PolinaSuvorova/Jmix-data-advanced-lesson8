package com.company.jmixpm.screen.workload;

import com.company.jmixpm.screen.workloadinfo.WorkloadinfoScreen;
import io.jmix.core.KeyValueMapper;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("WorkloadScreen")
@UiDescriptor("workLoad-screen.xml")
public class WorkloadScreen extends Screen {
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private Table<KeyValueEntity> workLoadTab;

    @Subscribe("workLoadTab.workLoadInfo")
    public void onWorkLoadTabWorkLoadInfo(final Action.ActionPerformedEvent event) {
        KeyValueEntity selected = workLoadTab.getSingleSelected();
        if (selected == null){
            return;
        }
        screenBuilders.screen(this)
                .withScreenClass(WorkloadinfoScreen.class)
                .build()
                .withItem(selected)
                .show();
    }
}