package com.dimas.brosalin.Quartz;

import com.dimas.brosalin.Services.HazelcastPersistanceToMongoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by DmitriyBrosalin on 21/05/2017.
 */
public class JobToSchedule extends QuartzJobBean {

    private HazelcastPersistanceToMongoService persistanceToMongoService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        persistanceToMongoService.doPersistanceJob();
    }

    public HazelcastPersistanceToMongoService getPersistanceToMongoService() {
        return persistanceToMongoService;
    }

    public void setPersistanceToMongoService(HazelcastPersistanceToMongoService persistanceToMongoService) {
        this.persistanceToMongoService = persistanceToMongoService;
    }
}
