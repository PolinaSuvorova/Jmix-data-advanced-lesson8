package com.company.jmixpm.screen.roadmap;

import io.jmix.ui.screen.*;
import com.company.jmixpm.entity.RoadMap;

@UiController("RoadMap.browse")
@UiDescriptor("road-map-browse.xml")
@LookupComponent("roadMapsTable")
public class RoadMapBrowse extends StandardLookup<RoadMap> {
}