package com.cs544.project.adapter;

import com.cs544.project.domain.Location;
import com.cs544.project.dto.LocationDto;

public class LocationAdapterImpl extends AbstractGenericDTOConverter<LocationDto, Location>{
    public LocationAdapterImpl(){
        super(LocationDto.class, Location.class);
    }
}
