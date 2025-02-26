/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seatunnel.app.controller;

import org.apache.seatunnel.app.bean.engine.EngineDataType;
import org.apache.seatunnel.app.common.Result;
import org.apache.seatunnel.app.domain.response.engine.Engine;
import org.apache.seatunnel.app.service.IEngineService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/seatunnel/api/v1/engine")
@RestController
public class EngineController {

    @Resource private IEngineService engineService;

    @GetMapping("/list")
    @ApiOperation(value = "list all supported engines", httpMethod = "GET")
    public Result<List<Engine>> listSupportEngines() {
        return Result.success(engineService.listSupportEngines());
    }

    @GetMapping("/type")
    @ApiOperation(value = "list all supported Data Type", httpMethod = "GET")
    public Result<List<String>> listSupportDataTypes() {
        return Result.success(
                Arrays.stream(engineService.listSupportDataTypes())
                        .map(EngineDataType.DataType::getName)
                        .collect(Collectors.toList()));
    }
}
