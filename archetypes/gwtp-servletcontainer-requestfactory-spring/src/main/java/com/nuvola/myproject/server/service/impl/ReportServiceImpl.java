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

package com.nuvola.myproject.server.service.impl;

import com.nuvola.myproject.server.service.ReportService;
import com.nuvola.myproject.shared.dto.ReportDTO;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService, ResourceLoaderAware {
     private ResourceLoader resourceLoader;

     @Override
     public byte[] generatePdf(ReportDTO reportDTO) throws Exception {
          Resource resource = getResource("classpath:/META-INF/jaspertemplates/" +
                  reportDTO.getReportName() + ".jasper");
          // TODO: Change this empty dataSource and provide valid jasper template
          JREmptyDataSource emptyDataSource = new JREmptyDataSource();
          JasperPrint jasperPrint = JasperFillManager.fillReport(resource.getInputStream(),
                  reportDTO.getReportParameters(), emptyDataSource);
          return JasperExportManager.exportReportToPdf(jasperPrint);
     }

     @Override
     public void setResourceLoader(ResourceLoader resourceLoader) {
          this.resourceLoader = resourceLoader;
     }

     public Resource getResource(String location){
          return resourceLoader.getResource(location);
     }
}
