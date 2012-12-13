package com.heatclinic.core.order.service.workflow;

import org.broadleafcommerce.core.workflow.ProcessContext;

import java.util.Map;

public class AddItemContext implements ProcessContext {
	public final static long serialVersionUID = 1L;

    protected boolean stopEntireProcess = false;
    protected Map<String, Object> seedData;

    @SuppressWarnings("unchecked")
    public void setSeedData(Object seedObject) {
        seedData = (Map<String, Object>) seedObject;
    }

    public boolean stopProcess() {
        this.stopEntireProcess = true;
        return stopEntireProcess;
    }

    public boolean isStopped() {
        return stopEntireProcess;
    }

    public Map<String, Object> getSeedData(){
        return seedData;
    }
}
