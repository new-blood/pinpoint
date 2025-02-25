/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.pinpoint.web.applicationmap.histogram;

import com.navercorp.pinpoint.web.applicationmap.rawdata.AgentHistogram;
import com.navercorp.pinpoint.web.applicationmap.rawdata.AgentHistogramList;
import com.navercorp.pinpoint.web.view.AgentResponseTimeViewModel;
import com.navercorp.pinpoint.web.view.TimeViewModel;
import com.navercorp.pinpoint.web.vo.Application;
import com.navercorp.pinpoint.common.server.util.time.Range;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * most of the features have been delegated to AgentHistorgramList upon refactoring
 * TODO: functionality reduced to creating views - need to be renamed or removed
 * @author emeroad
 */
public class AgentTimeHistogram {

    private static final Comparator<AgentResponseTimeViewModel> AGENT_NAME_COMPARATOR
            = Comparator.comparing(AgentResponseTimeViewModel::getAgentName);

    private final Application application;
    private final Range range;
    private final AgentHistogramList agentHistogramList;

    public AgentTimeHistogram(Application application, Range range) {
        this.application = Objects.requireNonNull(application, "application");
        this.range = Objects.requireNonNull(range, "range");
        this.agentHistogramList = new AgentHistogramList();
    }

    public AgentTimeHistogram(Application application, Range range, AgentHistogramList agentHistogramList) {
        this.application = Objects.requireNonNull(application, "application");
        this.range = Objects.requireNonNull(range, "range");
        this.agentHistogramList = Objects.requireNonNull(agentHistogramList, "agentHistogramList");
    }


    public List<AgentResponseTimeViewModel> createViewModel(TimeHistogramFormat timeHistogramFormat) {
        final List<AgentResponseTimeViewModel> result = new ArrayList<>();
        for (AgentHistogram agentHistogram : agentHistogramList.getAgentHistogramList()) {
            Application agentId = agentHistogram.getAgentId();
            List<TimeHistogram> timeList = sortTimeHistogram(agentHistogram.getTimeHistogram());
            AgentResponseTimeViewModel model = createAgentResponseTimeViewModel(agentId, timeList, timeHistogramFormat);
            result.add(model);
        }
        result.sort(AGENT_NAME_COMPARATOR);
        return result;
    }

    private List<TimeHistogram> sortTimeHistogram(Collection<TimeHistogram> timeMap) {
        List<TimeHistogram> timeList = new ArrayList<>(timeMap);
        timeList.sort(TimeHistogram.TIME_STAMP_ASC_COMPARATOR);
        return timeList;
    }

    private AgentResponseTimeViewModel createAgentResponseTimeViewModel(Application agentName, List<TimeHistogram> timeHistogramList, TimeHistogramFormat timeHistogramFormat) {
        List<TimeViewModel> responseTimeViewModel = createResponseTimeViewModel(timeHistogramList, timeHistogramFormat);
        AgentResponseTimeViewModel agentResponseTimeViewModel = new AgentResponseTimeViewModel(agentName, responseTimeViewModel);
        return agentResponseTimeViewModel;
    }

    private List<TimeViewModel> createResponseTimeViewModel(List<TimeHistogram> timeHistogramList, TimeHistogramFormat timeHistogramFormat) {
        return new TimeViewModel.TimeViewModelBuilder(application, timeHistogramList).setTimeHistogramFormat(timeHistogramFormat).build();
    }
}
