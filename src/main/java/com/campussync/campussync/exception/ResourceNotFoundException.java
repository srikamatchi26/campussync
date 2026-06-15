package com.campussync.campussync.exception;


public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private Long resourceId;

    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(resourceName + " not found with id: " + resourceId);
        this.resourceName = resourceName;
        this.resourceId   = resourceId;
    }

    public String getResourceName() { return resourceName; }
    public Long getResourceId()     { return resourceId; }
}