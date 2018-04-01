/**
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.qq.tars.quickstart.server.testapp.impl;

import java.io.IOException;
import java.util.Properties;

import com.qq.tars.quickstart.server.testapp.HelloServant;
import com.qq.tars.support.log.Logger;
import com.qq.tars.support.log.Logger.LogType;

public class HelloServantImpl implements HelloServant {

	private final static Logger FLOW_LOGGER = Logger.getLogger("flow", LogType.LOCAL);

	@Override
	public String hello(int no, String name) {

		FLOW_LOGGER.info(" hello call ");
		try {
			Properties prop = new Properties();
			prop.load(HelloServantImpl.class.getClassLoader().getResourceAsStream("helloServer.conf"));
			FLOW_LOGGER.info("asdfsafd : " + prop.getProperty("testkey"));
		} catch (IOException e) {
			FLOW_LOGGER.warn("config load failure");
		}
		return String.format("hello no=%s, name=%s, time=%s", no, name, System.currentTimeMillis());
	}
}
