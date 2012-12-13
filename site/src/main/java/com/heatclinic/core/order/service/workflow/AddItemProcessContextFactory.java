package com.heatclinic.core.order.service.workflow;

import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.ProcessContextFactory;
import org.broadleafcommerce.core.workflow.WorkflowException;

import java.util.Map;

public class AddItemProcessContextFactory implements ProcessContextFactory {

	@Override
	public ProcessContext createContext(Object seedData)
			throws WorkflowException {
		if (!(seedData instanceof Map)){
            throw new WorkflowException("Seed data instance is incorrect. " +
                    "Required class is "+Map.class.getName()+" " +
                    "but found class: "+seedData.getClass().getName());
        }
        
        AddItemContext context = new AddItemContext();
        context.setSeedData(seedData);
        return context;
	}

}
