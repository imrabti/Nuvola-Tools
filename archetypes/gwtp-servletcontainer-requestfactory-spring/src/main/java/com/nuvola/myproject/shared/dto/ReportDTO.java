/**
 * Copyright 2012 Nuvola Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.nuvola.myproject.shared.dto;

import java.util.Map;

public class ReportDTO {
     private String reportName;

     private Map<String, Object> reportParameters;

     public String getReportName() {
          return reportName;
     }

     public void setReportName(String reportName) {
          this.reportName = reportName;
     }

     public Map<String, Object> getReportParameters() {
          return reportParameters;
     }

     public void setReportParameters(Map<String, Object> reportParameters) {
          this.reportParameters = reportParameters;
     }
}
