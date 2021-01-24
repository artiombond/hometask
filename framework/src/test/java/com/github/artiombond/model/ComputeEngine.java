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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return numberOfInstances == that.numberOfInstances &&
                numberOfGPUs == that.numberOfGPUs &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineSeries, that.machineSeries) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(datacentrLocation, that.datacentrLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineClass, machineSeries, machineType, numberOfGPUs, gpuType, localSSD, datacentrLocation, committedUsage);
    }
}
