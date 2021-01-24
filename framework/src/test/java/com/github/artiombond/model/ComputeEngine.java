package com.github.artiombond.model;

import java.util.Objects;

public class ComputeEngine {
    private int numberOfInstances;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private int numberOfGPUs;
    private String gpuType;
    private String localSSD;
    private String datacentrLocation;
    private String committedUsage;

    public ComputeEngine(int numberOfInstances, String machineClass, String machineSeries, String machineType,
                         int numberOfGPUs, String gpuType, String localSSD, String datacentrLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.machineClass = machineClass;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.datacentrLocation = datacentrLocation;
        this.committedUsage = committedUsage;
    }


    public String getMachineClass() {
        return machineClass;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public int getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacentrLocation() {
        return datacentrLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

}
