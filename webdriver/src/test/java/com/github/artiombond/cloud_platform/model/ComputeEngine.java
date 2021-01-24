package com.github.artiombond.cloud_platform.model;

public class ComputeEngine {
    private int numberOfInstances;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private int numberOfGpus;
    private String gpuType;
    private String localSSD;
    private String datacentrLocation;
    private String commitmentTerm;

    public ComputeEngine(int numberOfInstances,String machineClass, String machineSeries, String machineType, int numberOfGpus,
                         String gpuType, String localSSD, String datacentrLocation, String commitmentTerm) {
        this.numberOfInstances = numberOfInstances;
        this.machineClass = machineClass;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGpus = numberOfGpus;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.datacentrLocation = datacentrLocation;
        this.commitmentTerm = commitmentTerm;
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

    public int getNumberOfGpus() {
        return numberOfGpus;
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

    public String getCommitmentTerm() {
        return commitmentTerm;
    }
}
