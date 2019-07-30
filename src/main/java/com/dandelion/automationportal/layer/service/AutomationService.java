package com.dandelion.automationportal.layer.service;

import com.dandelion.automationportal.model.projection.AutomationTypeProjection;

import java.util.List;

public interface AutomationService {

    List<AutomationTypeProjection> findAllTypes();
}
