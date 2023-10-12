package com.company.jmixpm.screen.roadmap;

import com.company.jmixpm.entity.Estimation;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.RoadMap;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("RoadMap.edit")
@UiDescriptor("road-map-edit.xml")
@EditedEntityContainer("roadMapDc")
public class RoadMapEdit extends StandardEditor<RoadMap> {
    @Autowired
    private Notifications notifications;

    @Subscribe(id = "roadMapDc", target = Target.DATA_CONTAINER)
    public void onRoadMapDcItemPropertyChange(final InstanceContainer.ItemPropertyChangeEvent<RoadMap> event) {
        notifications.create()
                .withCaption("Roadmap " + event.getProperty())
                .show();
    }

    @Subscribe(id = "estimationDc", target = Target.DATA_CONTAINER)
    public void onEstimationDcItemPropertyChange(final InstanceContainer.ItemPropertyChangeEvent<Estimation> event) {
        notifications.create()
                .withCaption("Estimation " + event.getProperty())
                .show();
    }

}