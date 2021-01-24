package com.github.artiombond.service;

import com.github.artiombond.model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String NUMBER_OF_INSTANCES = "testdata.engine.instances";
    private static final String MACHINE_CLASS = "testdata.engine.class";
    private static final String MACHINE_SERIES = "testdata.engine.series";
    private static final String MACHINE_TYPE = "testdata.engine.machinetype";
    private static final String NUMBER_OF_GPUS = "testdata.engine.gpus";
    private static final String GPU_TYPE = "testdata.engine.gputype";
    private static final String LOCAL_SSD = "testdata.engine.ssd";
    private static final String DATACENTR_LOCATION = "testdata.engine.datacentr";
    private static final String COMMITED_USAGE = "testdata.engine.usage";

    public static ComputeEngine getComputeEngineWithCredentials(){
        return new ComputeEngine(Integer.parseInt(TestDataReader.getTestData(NUMBER_OF_INSTANCES)),
                TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_SERIES),
                TestDataReader.getTestData(MACHINE_TYPE),
                Integer.parseInt(TestDataReader.getTestData(NUMBER_OF_GPUS)),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTR_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE));
    }
}
